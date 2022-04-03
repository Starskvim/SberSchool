package Task1.Geometry;

public class Triangle extends Figure implements AngleInt{

    private Double b;

    private Double c;

    public Triangle (Double inputA, Double inputB, Double inputC){
        a = inputA;
        b = inputB;
        c = inputC;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        Double p = calculatePerimeter() / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
