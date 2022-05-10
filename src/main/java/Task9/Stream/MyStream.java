package Task9.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
    private final List<T> data;

    @SafeVarargs
    public static<T> MyStream<T> of(T... elements) {
        return new MyStream<T>(Arrays.asList(elements));
    }

    private MyStream(List<? extends T> data) {
        this.data = new ArrayList<T>(data);
    }

    public void forEach(Consumer<? super T> consumerMethod) {
        for (T elem : data) {
            consumerMethod.accept(elem);
        }
    }

    public MyStream<T> filter (Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T elem : data) {
            if (predicate.test(elem)) {
                result.add(elem);
            }
        }
        return new MyStream<T>(result);
    }

    public<V> MyStream<V> map(Function<? super T, ? extends V> mapper) {
        List<V> newList = new ArrayList<>();
        for (T element : data) {
            newList.add(mapper.apply(element));
        }
        return new MyStream<V>(newList);
    }

    public MyStream<T> distinct() {
        return new MyStream<T>( new ArrayList<T>(new LinkedHashSet<T>(data)));
    }

}
