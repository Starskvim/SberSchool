package Task13;

public class MainCreator {


    public static void main(String[] args) {

        for (int i = 0; i < 1000000; i++){
            TestObj testObj = new TestObj((int) (Math.random() * 1000));
            System.out.println(testObj.getTest());
        }

    }

}
