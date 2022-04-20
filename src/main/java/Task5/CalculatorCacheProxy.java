package Task5;

import java.util.HashMap;

public class CalculatorCacheProxy implements Calculator {

    private Calculator calculator = new CalculatorImp();

    private HashMap<Integer, Integer> cachedValues=new HashMap<>();

    public void clearCache() {
        cachedValues = new HashMap<>();
    }

    @Override
    public int calc(int number) {
        if(cachedValues.containsKey(number)){
            return cachedValues.get(number);
        } else{
            int result = calculator.calc(number);
            cachedValues.put(number,result);
            return result;
        }
    }

    public void printCache(){
        System.out.println(cachedValues);
    }
}
