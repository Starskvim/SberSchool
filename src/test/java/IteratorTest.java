
import Task6.Iterator.MyReverseIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {

    @Test
    public void iterateTest() throws Exception {
        List<Integer> inputLines = new ArrayList<>();
        inputLines.add(1);
        inputLines.add(5);
        inputLines.add(3);
        inputLines.add(4);

        List<Integer> resultLines = new ArrayList<>();
        resultLines.add(4);
        resultLines.add(3);
        resultLines.add(5);
        resultLines.add(1);

        MyReverseIterator iterMy = new MyReverseIterator(inputLines);

        int i = 0;

        while (iterMy.hasNext()) {
            if (resultLines.get(i) != iterMy.next())
                Assertions.fail("Не корректный порядок");
            i++;
        }
    }

}
