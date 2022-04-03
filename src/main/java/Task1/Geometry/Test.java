package Task1.Geometry;

public class Test {

    public static void main(String[] args) {

        Square square = new Square(25.0);
        Circle circle = new Circle(8.0);
        Triangle triangle = new Triangle(10.0, 5.0, 7.0);
        Rect rect = new Rect(8.0, 15.0);

        System.out.println("square.calculatePerimeter - " + square.calculatePerimeter());
        System.out.println("square.calculateArea - " +square.calculateArea());

        System.out.println("circle.calculateRadius - " + circle.calculateRadius());
        System.out.println("circle.calculateArea - " + circle.calculateArea());

        System.out.println("triangle.calculatePerimeter -" + triangle.calculatePerimeter());
        System.out.println("triangle.calculateArea -" + triangle.calculateArea());

        System.out.println("rect.calculatePerimeter -" + rect.calculatePerimeter());
        System.out.println("rect.calculateArea - " + rect.calculateArea());

        Figure figure = new Square(25.0);

        System.out.println("figure.calculateArea - " + figure.calculateArea());

    }

}
