package Task1.Convert;

public class TestConvert {

    public static void main(String[] args) {

        double c = 33.0;

        System.out.println("C:" + c);
        System.out.println("F:" + Converters.getFahrenheitConverter().convert(c));
        System.out.println("K:" + Converters.getKelvinConverter().convert(c));

    }
}
