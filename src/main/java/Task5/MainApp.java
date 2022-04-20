package Task5;

public class MainApp {

    public static void main(String[] args) {
        Reflectioner.printClassAndSuperMethods(ReflectionChecker.class);
        System.out.println();

        System.out.println("Getters");
        Reflectioner.printGetters(ReflectionChecker.class);
        System.out.println();

        System.out.println("Week checker:");
        Reflectioner.weekDaysChecker();
        System.out.println();

        System.out.println("Cache proxy task:");
        Calculator calculator= new PerfomanceProxy(new CalculatorCacheProxy());
        System.out.println(calculator.calc(30));
        System.out.println(calculator.calc(30));
        System.out.println(calculator.calc(30));

        System.out.println();
        System.out.println("BeanTest");
        TestBeanUtil testBeanUtil1 =new TestBeanUtil("1","2",3);
        TestBeanUtil testBeanUtil2 = new TestBeanUtil();
        BeanUtils.assign(testBeanUtil2,testBeanUtil1);
        System.out.println(testBeanUtil2);
    }
}
