package Task16.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class Cacher implements InvocationHandler {
    private final Object cachedObject;

    public Cacher(Object cachedObject) {
        this.cachedObject = cachedObject;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(Cacheble.class)) {
            CacheService cacheService = new CacheServiceImp(method.getAnnotation(Cacheble.class).value().newInstance(), method);
            List<Integer> res = cacheService.getChachedIntList((int) args[0]);

            if (res!=null) {
                return res;
            } else {
                res = (List<Integer>) method.invoke(cachedObject, args);
                cacheService.cacheIntList(res);
                return res;
            }
        } else {
            return method.invoke(cachedObject, args);
        }
    }

}
