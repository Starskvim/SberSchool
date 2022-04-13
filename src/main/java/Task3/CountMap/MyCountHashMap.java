package Task3.CountMap;

import java.util.HashMap;
import java.util.Map;

public class MyCountHashMap<T> implements CountMap<T> {

    private HashMap<T,Integer> hashMap = new HashMap<>();

    @Override
    public void add(T element) {
        hashMap.put(element, hashMap.getOrDefault(element, 0) + 1);
    }

    @Override
    public int getCount(T element) {
        return hashMap.getOrDefault(element,0);
    }

    @Override
    public int remove(T o) {
        int uses = getCount(o);
        hashMap.remove(o);
        return uses;
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    //

    @Override
    public void addAll(CountMap<? extends T> source) {
        Map<? extends T, Integer> map =source.toMap();
        for(T elem:source.toMap().keySet()){
            hashMap.put(elem, hashMap.getOrDefault(elem, 0) + map.getOrDefault(elem,0));
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return hashMap;
    }


    @Override
    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(hashMap);
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
