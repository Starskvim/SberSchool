package Task1.Geometry;

public class Rect extends Figure implements AngleInt {

    private Double b;

    public Rect (Double inputA, Double inputB){
        a = inputA;
        b = inputB;
    }

    @Override
    public double calculatePerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double calculateArea() {
        return a * b;
    }
}
