package assignment6;
import java.util.Scanner;
public class exceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = null;
        int arrayLength = 0;

        while (true) {
            try {
                System.out.println("Enter the size of the array: ");
                arrayLength = Integer.parseInt(scanner.nextLine()); 

//                if (arrayLength < 0) {
//                    throw new NegativeArraySizeException("Array size cannot be negative");
//                }
                numbers = new int[arrayLength];
                break;  
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer for array size.");
            } catch (NegativeArraySizeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        for (int i = 0; i < arrayLength; i++) {
            while (true) {
                try {
                    System.out.println("Enter an integer for index " + i + ": ");
                    numbers[i] = Integer.parseInt(scanner.nextLine());  
                    break; 
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid integer for index " + i + ".");
                }
            }
        }

        if (arrayLength >= 2) {
            while (true) {
                try {
                    int result = numbers[0] / numbers[1];  
                    System.out.println("The result of division of numbers[0] by numbers[1] is: " + result);
                    break;  
                } catch (ArithmeticException e) {
                    System.out.println("Error: Division by zero is not allowed.");
                    while (true) {
                        try {
                            System.out.println("Enter a non-zero integer for index 1: ");
                            numbers[1] = Integer.parseInt(scanner.nextLine());  
                            break;  
                        } catch (NumberFormatException e1) {
                            System.out.println("Error: Please enter a valid integer for index 1.");
                        }
                    }
                }
            }
        }
        boolean ans=true;
        while (ans) {
            try {
                System.out.println("\nEnter the index of the array element you want to access (or -1 to exit): ");
                int index = Integer.parseInt(scanner.nextLine());

                if (index == -1) {
                    break;  
                }

                if (index >= 0 && index < arrayLength) {
                    System.out.println("Element at index " + index + " is: " + numbers[index]);
                } else {
                    System.out.println("Error: Index is out of bounds. Valid index range is from 0 to " + (arrayLength - 1));
                }

                System.out.println("Enter 'yes' to exit, or anything else to continue:");
                String result = scanner.nextLine();

                if (result.equalsIgnoreCase("yes")) {  
                    ans = false;  
                    break; 
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index is out of bounds. Valid index range is from 0 to " + (arrayLength - 1));
            }
        }
        System.out.println("Program has finished executing.");
        scanner.close();
    }

}

