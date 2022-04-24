package Task6.Iterator;

import java.util.Iterator;
import java.util.List;

public class MyReverseIterator<T> implements Iterator {

    private List<T> list;
    private int pos = 0;

    public MyReverseIterator(List<T> list) {
        this.list = list;
        this.pos = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        if (list == null || list.size() == 0)
            return false;
        return pos >= 0;
    }

    @Override
    public T next() {
        return pos >= 0 ? list.get(pos--) : null;
    }
}
