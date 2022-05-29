package Task14.CacheCalculator;

import java.util.stream.IntStream;

public class CalculatorImp implements Calculator{

    public CalculatorImp() {
    }

    private void PRIVATE_METHOD(){
        System.out.println("hello from private method!");
    }

    @Override
    public int calc(int number) {
        return IntStream.rangeClosed(1, number)
                .reduce(1, (int x, int y) -> x * y);
    }
}
