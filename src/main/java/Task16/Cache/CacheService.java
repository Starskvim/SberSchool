package Task16.Cache;

import java.util.List;

public interface CacheService {
    void cacheIntList(List<Integer> value);
    List<Integer> getChachedIntList(int arg);
}
