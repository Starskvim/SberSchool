package Task1.Geometry;

public class Square extends Figure implements AngleInt {

    public Square (Double inputA) {
        a = inputA;
    }

    @Override
    public double calculatePerimeter() {
        return a * 4;
    }

    @Override
    public double calculateArea() {
        return a*a;
    }
}
