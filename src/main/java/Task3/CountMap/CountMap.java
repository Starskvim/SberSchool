package Task3.CountMap;

import java.util.Map;

public interface CountMap<T>  {

    void add(T element);

    int getCount(T o);

    //current count
    int remove(T o);

    int size();

    void addAll(CountMap<? extends T> source);

    Map<T, Integer> toMap();

    void toMap(Map<? super T, Integer> destination);

}
