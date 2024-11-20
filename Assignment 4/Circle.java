package assignment4;

class Circle extends Shape {

    
    Circle(double radius) {
        super(radius, 0);
    }

    void compute_area() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}