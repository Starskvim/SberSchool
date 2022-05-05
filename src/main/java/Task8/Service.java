package Task8;

import java.util.Date;
import java.util.List;

public interface Service {
    @MyCache(cacheType = CacheType.IN_FILE, fileNamePrefix = "data", zip = true, identityBy = {String.class, double.class}, listList = 2)
    List<String> doHardWork(String item, double value, Date date);
}
