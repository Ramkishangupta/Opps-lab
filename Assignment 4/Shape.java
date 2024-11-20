package assignment4;

abstract class Shape {
    double dimension1;
    double dimension2;


    Shape(double dim1, double dim2) {
        this.dimension1 = dim1;
        this.dimension2 = dim2;
    }

    abstract void compute_area();
}

