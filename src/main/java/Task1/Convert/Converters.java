package Task1.Convert;

public class Converters {
    public static Converter getFahrenheitConverter(){
        return c -> 9.0/5*c+32;
    }
    public static Converter getKelvinConverter(){
        return c -> c-273.15;
    }
}
