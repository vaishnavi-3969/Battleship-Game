abstract class Shape {
    abstract double getPerimeter();
    abstract double getArea();
}
class Circle extends Shape {
    private double a;
    private static final double PI = Math.PI;

    public Circle(double one) {
        this.a = one;
    }
    public double getPerimeter() {
        return 2 * PI * a;
    }
    public double getArea() {
        double rK2 = Math.pow(a, 2);
        return PI * rK2;
    }
}
class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double one, double two) {
        this.a = one;
        this.b = two;
    }
    public double getPerimeter() {
        return (a + b) * 2;
    }
    public double getArea() {
        return a * b;
    }
}
class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double one, double two, double three) {
        this.a = one;
        this.b = two;
        this.c = three;
    }
    public double getPerimeter() {
        return a + b + c;
    }
    public double getArea() {
        double div2 = (a + b + c) / 2;
        return Math.sqrt(div2 * ((div2 - a) * (div2 - b) * (div2 - c)));
    }
}