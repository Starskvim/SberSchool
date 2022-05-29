package Task14.CacheCalculator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CalculatorCacheProxy implements Calculator {
    // Ссылка на оригинальный объект
    private Calculator calculator = new CalculatorImp();

    private ConcurrentMap<Integer, Integer> cachedValues=new ConcurrentHashMap<>();

    public void clearCache() {
        calculator = null;
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
