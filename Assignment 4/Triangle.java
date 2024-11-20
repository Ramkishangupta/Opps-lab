package assignment4;

class Triangle extends Shape {

    // Constructor to initialize dimensions
    Triangle(double base, double height) {
        super(base, height);
    }

    @Override
    void compute_area() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}