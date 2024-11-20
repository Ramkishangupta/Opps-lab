package assignment4;

class Pentagon extends Shape {

    
    Pentagon(double sideLength) {
        super(sideLength, 0);
    }

    
    @Override
    void compute_area() {
        double area = (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * dimension1 * dimension1;
        System.out.println("Area of Pentagon: " + area);
    }
}
