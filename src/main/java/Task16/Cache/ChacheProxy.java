package Task16.Cache;

import java.lang.reflect.Proxy;

public class ChacheProxy {
    public <T> T cache(Object cachedObject) {
        return (T) Proxy.newProxyInstance(cachedObject.getClass().getClassLoader(),
                cachedObject.getClass().getInterfaces(), new Cacher(cachedObject));
    }
}
