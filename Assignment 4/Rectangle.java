package assignment4;

class Rectangle extends Shape {

    Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    void compute_area() {
        double area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}