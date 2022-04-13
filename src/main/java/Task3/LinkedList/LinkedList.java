package Task3.LinkedList;


import java.util.Collection;
import java.util.Iterator;

public interface LinkedList<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    T remove(int index);

    Iterator<T> iterator();

    boolean addAll (Collection<T> collection);

    boolean copy(Collection<T> collection);

}
