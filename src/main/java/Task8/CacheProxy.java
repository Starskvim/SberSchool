package Task8;

import java.lang.reflect.Proxy;

public class CacheProxy {
    private final String cacheDir;

    public CacheProxy(String cacheDirectory) {
        this.cacheDir = cacheDirectory;
    }

    public <T> T cache(Object objectForCach) {
        return (T) Proxy.newProxyInstance(objectForCach.getClass().getClassLoader(),
                objectForCach.getClass().getInterfaces(), new Cacher(objectForCach, cacheDir));
    }
}
