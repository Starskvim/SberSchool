package Task7;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Cacher implements InvocationHandler {

    private final Map<String, Object> objectsInMemory;
    private final Object cachedObj;
    private final String cacheDir;

    public Cacher(Object cachedObj, String cacheDir) {
        this.cachedObj = cachedObj;
        this.cacheDir = cacheDir;
        this.objectsInMemory=new HashMap<>();
    }

    private Object retriveFromCache(CacheHelper cacheHelper, Method method, Object[] args) throws Exception {
        String cachResourceName = cacheHelper.getResourceCacheName(args);

        if (objectsInMemory.containsKey(cachResourceName)) {
            System.out.println("Getting from memory...");
            return objectsInMemory.get(cachResourceName);
        }

        if (cacheHelper.isCachedInFile()) {
            System.out.println("Resource cached in file, trying to get val...");

            File cacheFile = Paths.get(cacheDir, cachResourceName).toFile();

            if (!cacheFile.exists()) {
                System.out.println("Not found cache file, creating...");
                Object result = method.invoke(cachedObj, args);
                cacheHelper.saveToDisk(result,cacheFile,cacheHelper.isZip());
                return result;
            }

            return cacheHelper.getCacheFromDisk(cacheFile,cacheHelper.isZip());
        }

        Object result = method.invoke(cachedObj, args);
        objectsInMemory.put(cachResourceName, result);
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        CacheHelper cacheHelper = new CacheHelper(method);

        if (!cacheHelper.isCached()) {
            return method.invoke(cachedObj,args);
        }

        return cacheHelper.trimList(retriveFromCache(cacheHelper,method,args));
    }

}
