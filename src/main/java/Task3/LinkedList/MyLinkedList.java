package Task3.LinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements LinkedList<E>{

    Long size = 0L;
    private Node<E> first;
    private Node<E> last;

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

        Node<E> newNode = new Node<>(element);
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

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            add(element);
        }
        if (index == size) {
            last.next = newNode;
            last = newNode;
        }
        Node<E> oldNode = first;
        for (int i = 0; i < index; i++) {
            oldNode = oldNode.next;
        }
        Node<E> oldPrevious = oldNode.previous;
        oldPrevious.next = newNode;
        oldNode.previous = newNode;

        newNode.previous = oldPrevious;
        newNode.next = oldNode;
        size++;

    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        Node<E> memory = null;
        if (index == 0) {
            first = first.next;
        } else {
            memory = (Node<E>) get(index);
            Node<E> node = (Node<E>) get(index - 1);
            node.next = memory.next;
        }
        size--;
        return (E) memory;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if(hasNext()){
                    E data = (E) current.element;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
    }

    @Override
    public boolean addAll(LinkedList<E> list) {
        if (list.size() == 0){
            return false;
        } else {
            Iterator<E> iterator = list.iterator();
            while (iterator.hasNext()){
                E obj = iterator.next();
                add(obj);
            }
            return true;
        }
    }

    @Override
    public LinkedList<E> copy(LinkedList<E> list) {
        MyLinkedList<E> copy = new MyLinkedList<>();
        copy.addAll(list);
        return copy;
    }

    public Long size(){
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0L;
    }

}
