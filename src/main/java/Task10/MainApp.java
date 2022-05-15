package Task10;

import com.google.common.math.BigIntegerMath;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class MainApp {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {

        String input = readFile("Task10.txt");
        List<Integer> numbers = Arrays.stream(input.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println("-------------------Stream------------------------");

        long start1 = System.currentTimeMillis();
        numbers.stream().parallel().forEach(MainApp::calculateFactorial);
        long fin1 = System.currentTimeMillis();

        System.out.println("-------------------ExecutorService------------------------");

        long start2 = System.currentTimeMillis();
        for(Integer number : numbers){
            Future<BigInteger> future = executorService.submit(new WorkerThread(number));
            try {
                System.out.println("For number " + number + " - result - " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long fin2 = System.currentTimeMillis();

        System.out.println("--------------------Solo--------------------------");

        long start3 = System.currentTimeMillis();
        numbers.forEach(MainApp::calculateFactorial);
        long fin3 = System.currentTimeMillis();

        System.out.println("-----------------------------------------------------");

        System.out.println("Time Stream - " + (fin1 - start1));
        System.out.println("Time ExecutorService - " + (fin2 - start2));
        System.out.println("Time solo - " + (fin3 - start3));


    }

    @SneakyThrows
    private static String readFile(String file){
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();


        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);

            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }


    private static void calculateFactorial(int n){
        BigInteger result = BigIntegerMath.factorial(n);
        System.out.println("For number " + n + " - result - " + result);
    }

//    private static void calculateFactorialStream(int n){
//        long result = LongStream.rangeClosed( 1, n )
//                .reduce(1, ( long a, long b ) -> a * b);
//        System.out.println("For number " + n + " - result - " + result);
//    }
}
