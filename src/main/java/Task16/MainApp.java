package Task16;

import Task16.Cache.ChacheProxy;

public class MainApp {

    public static void main(String[] args) {
        Test testImp = new ChacheProxy().cache(new TestImp());
        System.out.println(testImp.test(6));
        System.out.println(testImp.test(5));
        System.out.println(testImp.test(8));
    }
}
