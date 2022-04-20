package Task5;

public class TestBeanUtil {

    String val1;

    String val2;

    int val3;

    public TestBeanUtil(String val1, String val2, int val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    @Override
    public String toString() {
        return "TestBeanUtil{" +
                "val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                ", val3=" + val3 +
                '}';
    }

    public TestBeanUtil() {
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public int getVal3() {
        return val3;
    }

    public void setVal3(int val3) {
        this.val3 = val3;
    }
}
