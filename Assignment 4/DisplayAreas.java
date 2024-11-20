package assignment4;
import java.util.Scanner;
public class DisplayAreas {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the shape to calculate the area:");
        System.out.println("1. Rectangle");
        System.out.println("2. Triangle");
        System.out.println("3. Circle");
        System.out.println("4. Pentagon");
        int choice = scanner.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1:
                System.out.println("Enter the length and width of the rectangle:");
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();

                shape = new Rectangle(length, width);
                break;

            case 2:
               
                System.out.println("Enter the base and height of the triangle:");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();


                shape = new Triangle(base, height);
                break;

            case 3:
                System.out.println("Enter the radius of the circle:");
                double radius = scanner.nextDouble();

  
                shape = new Circle(radius);
                break;

            case 4:

                System.out.println("Enter the side length of the pentagon:");
                double sideLength = scanner.nextDouble();

                shape = new Pentagon(sideLength);
                break;

            default:
                System.out.println("Invalid choice! Please select 1, 2, 3, or 4.");
                System.exit(0);
        }

        if (shape != null) {
            shape.compute_area();
        }

        scanner.close();
    }
}