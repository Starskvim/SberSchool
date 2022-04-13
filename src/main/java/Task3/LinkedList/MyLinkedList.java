package Task3.LinkedList;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements LinkedList<E>{

    Long size = 0L;
    private Node first;
    private Node last;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public void add(E element) {

        Node newNode = new Node(element);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;

    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean addAll(Collection<E> collection) {
        return false;
    }

    @Override
    public boolean copy(Collection<E> collection) {
        return false;
    }


}
