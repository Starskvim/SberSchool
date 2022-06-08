package Task16;

import Task16.Cache.Cacheble;
import Task16.Source.H2DB;

import java.util.ArrayList;

public interface Test {

    @Cacheble(H2DB.class)
    public ArrayList<Integer> test(int n);
}
