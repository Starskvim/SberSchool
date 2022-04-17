package Task3.LinkedList;

import java.util.Iterator;

public interface LinkedList<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    T remove(int index);

    Iterator<T> iterator();

    boolean addAll (LinkedList<T> collection);

    LinkedList<T> copy(LinkedList<T> collection);

    Long size();
}
