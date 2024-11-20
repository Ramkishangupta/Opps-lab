package ass7;
import java.util.*;

public class ass7 {
    int evenCount = 0;
    int oddCount = 0;
    int primeCount = 0;
    int nonPrimeCount = 0;
    int palindromeStringCount = 0;
    int nonPalindromeStringCount = 0;
    int palindromeNumberCount = 0;
    int nonPalindromeNumberCount = 0;

    ArrayList<Integer> numberList = new ArrayList<Integer>();
    ArrayList<String> stringList = new ArrayList<String>();

    void checkOddEven(int number) {
        if (number % 2 == 0 || number == 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }

    void checkPrime(int number) {
        if (number < 2) {
            nonPrimeCount++;
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeCount++;
            } else {
                nonPrimeCount++;
            }
        }
    }

    void checkPalindromeNumber(int number) {
        int original = number;
        int reversed = 0;
        int remainder;
        while (number > 0) {
            remainder = number % 10;
            reversed = (reversed * 10) + remainder;
            number = number / 10;
        }
        if (original == reversed) {
            palindromeNumberCount++;
        } else {
            nonPalindromeNumberCount++;
        }
    }

    void checkPalindromeString(String str) {
        StringBuilder reversedStr = new StringBuilder(str);
        if (str.equals(reversedStr.reverse().toString())) {
            palindromeStringCount++;
        } else {
            nonPalindromeStringCount++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ass7 checker = new ass7();
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        ArrayList<String> stringList = new ArrayList<String>();
        int mainChoice;
        int subChoice, stringSubChoice;
        int numberListSize, numberInput, stringListSize;
        String stringInput;

        do {
            System.out.println("********************MENU**********************");
            System.out.println("1. Enter 1 for INTEGER input");
            System.out.println("2. Enter 2 for STRING input");
            System.out.println("3. Enter 3 to EXIT");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    System.out.print("Enter the number of integers: ");
                    numberListSize = scanner.nextInt();
                    for (int i = 0; i < numberListSize; i++) {
                        System.out.print("Enter the number for index " + i + ": ");
                        numberInput = scanner.nextInt();
                        numberList.add(numberInput);
                    }
                    do {
                        System.out.println("********************SUB_MENU**********************");
                        System.out.println("1. Check EVEN or ODD");
                        System.out.println("2. Check PRIME or NOT");
                        System.out.println("3. Check PALINDROME or NOT");
                        System.out.println("4. EXIT");
                        System.out.print("Enter your sub-choice: ");
                        subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 1:
                                for (int number : numberList) {
                                    checker.checkOddEven(number);
                                }
                                System.out.println("Total EVEN numbers: " + checker.evenCount);
                                System.out.println("Total ODD numbers: " + checker.oddCount);
                                break;

                            case 2:
                                for (int number : numberList) {
                                    checker.checkPrime(number);
                                }
                                System.out.println("Total PRIME numbers: " + checker.primeCount);
                                System.out.println("Total NON-PRIME numbers: " + checker.nonPrimeCount);
                                break;

                            case 3:
                                for (int number : numberList) {
                                    checker.checkPalindromeNumber(number);
                                }
                                System.out.println("Total PALINDROME numbers: " + checker.palindromeNumberCount);
                                System.out.println("Total NON-PALINDROME numbers: " + checker.nonPalindromeNumberCount);
                                break;

                            case 4:
                                System.out.println("Exiting...");
                                break;

                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    } while (subChoice != 4);
                    break;

                case 2:
                    System.out.print("Enter the number of strings: ");
                    stringListSize = scanner.nextInt();
                    for (int i = 0; i < stringListSize; i++) {
                        System.out.print("Enter the string for index " + i + ": ");
                        stringInput = scanner.next();
                        stringList.add(stringInput);
                    }
                    do {
                        System.out.println("********************SUB_MENU**********************");
                        System.out.println("1. Check PALINDROME or NOT");
                        System.out.println("2. EXIT");
                        System.out.print("Enter your sub-choice: ");
                        stringSubChoice = scanner.nextInt();

                        switch (stringSubChoice) {
                            case 1:
                                for (String str : stringList) {
                                    checker.checkPalindromeString(str);
                                }
                                System.out.println("Total PALINDROME strings: " + checker.palindromeStringCount);
                                System.out.println("Total NON-PALINDROME strings: " + checker.nonPalindromeStringCount);
                                break;

                            case 2:
                                System.out.println("Exiting...");
                                break;

                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    } while (stringSubChoice != 2);
                    break;

                case 3:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (mainChoice != 3);
    }
}
