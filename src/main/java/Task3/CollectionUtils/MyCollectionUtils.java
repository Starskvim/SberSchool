package Task3.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? super T> newArrayList() {
        return  new ArrayList<T>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        if(source.size()<size) throw new IllegalArgumentException("size > source.size");
        List<? super T> list = new ArrayList<>();
        int added = 0;
        for (T elem :source) {
            if(added == size) break;
            list.add(elem);
            added++;
        }
        return list;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return !Collections.disjoint(c1, c2);
    }

    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min,T max) {
        List<? super T> rez = new ArrayList<>();
        int i = 0;
        for (T elem:list) {
            if(elem.compareTo(min) >= 0 && elem.compareTo(max)>=0)
                rez.add(elem);
        }
        return rez;
    }

    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<? super T> rez = new ArrayList<>();
        int i=0;
        for (T elem:list) {
            if(comparator.compare(elem, min)>=0 && comparator.compare(elem,max)<=0)
                rez.add(elem);
        }
        return rez;
    }
}
