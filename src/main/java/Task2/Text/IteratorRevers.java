package Task2.Text;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorRevers<T> implements Iterable<T> {

    private List<T> data;
    public IteratorRevers(List<T> list){
        this.data = list;
    }

    @Override
    public Iterator<T> iterator() {
        final ListIterator<T> iterator = data.listIterator(data.size());
        return new Iterator<>(){
            @Override
            public T next(){
                return iterator.previous();
            }
            @Override
            public boolean hasNext(){
                return iterator.hasPrevious();
            }
        };
    }

}
