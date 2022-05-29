package Task14;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;

public class Cacher implements InvocationHandler {

    private final ConcurrentMap<String, Object> objectsInMemory;
    private final ConcurrentMap<String, Semaphore> currentLockedFiles;
    private final Object cachedObj;
    private final String cacheDir;

    public Cacher(Object cachedObj, String cacheDir) {
        this.cachedObj = cachedObj;
        this.cacheDir = cacheDir;
        this.objectsInMemory=new ConcurrentHashMap<>();
        currentLockedFiles = new ConcurrentHashMap<>();
    }

    private Object retriveFromCache(CacheHelper cacheHelper, Method method, Object[] args) throws Exception {
        String cachResourceName = cacheHelper.getResourceCacheName(args);

        if (objectsInMemory.containsKey(cachResourceName)) {
            return objectsInMemory.get(cachResourceName);
        }

        if (cacheHelper.isCachedInFile()) {
            File cacheFile = Paths.get(cacheDir, cachResourceName).toFile();
            Semaphore fileSemaphore = currentLockedFiles.getOrDefault(cacheFile.getAbsolutePath(),new Semaphore(1));
            fileSemaphore.acquire();
            if (!cacheFile.exists()) {

                Object result = method.invoke(cachedObj, args);
                cacheHelper.saveToDisk(result,cacheFile,cacheHelper.isZip());
                return result;
            }
            Object result = cacheHelper.getCacheFromDisk(cacheFile,cacheHelper.isZip());
            fileSemaphore.release();
            return result;
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
