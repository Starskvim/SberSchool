package Task14;

import Task14.CacheCalculator.CacheType;

import java.util.Date;
import java.util.List;

public interface Service {
    @Cache(cacheType = CacheType.IN_MEMORY,
            fileNamePrefix = "data",
            zip = true, identityBy = {String.class, double.class},
            listList = 2)
    List<String> doHardWork(String item, double value, Date date);
}
