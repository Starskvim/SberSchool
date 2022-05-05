package Task8;

import java.util.Date;

public class MainApp {

    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy(".\\");
        Service service = cacheProxy.cache(new ServiceImp());
        System.out.println(service.doHardWork("1",5,new Date()));
        System.out.println(service.doHardWork("1",6,new Date()));
        System.out.println(service.doHardWork("1",6,new Date()));
        System.out.println(service.doHardWork("1",5,new Date()));
    }
}
