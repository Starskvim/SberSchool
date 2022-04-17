package Task3.LinkedList;

import java.util.Iterator;

public class MainApp {

    public static void main(String[] args) {

        MyLinkedList<Integer> test = new MyLinkedList<>();
        MyLinkedList<Integer> testTwo = new MyLinkedList<>();


        System.out.println("-----------Iterator-------------");
        for (int i = 0; i < 5; i++){
            int number = (int) (Math.random() * 10);
            int nombersTwo = (int) (Math.random() * 10);
            System.out.print(" - " + number);
            test.add(number);
            testTwo.add(nombersTwo);
        }

        System.out.println("\n");

        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.print(" - " + integer);
        }

        System.out.println("\n");
        System.out.println("---------Add all------------");

        test.addAll(testTwo);
        Iterator<Integer> iteratorTwo = test.iterator();
        while (iteratorTwo.hasNext()){
            Integer integer = iteratorTwo.next();
            System.out.print(" - " + integer);
        }

        System.out.println("\n");
        System.out.println("--------------------------");
    }

}
