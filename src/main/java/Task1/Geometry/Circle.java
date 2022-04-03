package Task1.Geometry;

public class Circle extends Figure implements CircleInt {

    public Circle(Double length){
        a = length;
    }

    @Override
    public double calculateRadius() {
        return a / (2 * Math.PI);
    }

    @Override
    public double calculateArea() {
        return (a * a) * Math.PI;
    }

}
