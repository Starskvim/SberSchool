package Task10;

import com.google.common.math.BigIntegerMath;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class WorkerThread implements Callable<BigInteger> {

    Integer number;

    @Override
    public BigInteger call() throws Exception {
        return BigIntegerMath.factorial(number);
    }
}
