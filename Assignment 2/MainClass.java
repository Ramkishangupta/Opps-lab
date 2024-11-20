package assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Publication {
    private String title;
    private double price;
    private int copies;
    private int stock;
    private int no;
    
//    private int total =0;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price");
        }
    }

    public int getCopies() {
        return this.copies;
    }

    public void setCopies(int copies) {
        if (copies >= 0) {
            this.copies = copies;
        } else {
            System.out.println("Invalid number of copies");
        }
    }
    

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNo() {
        return this.no;
    }

    public void setGetNo(int no) {
        this.no = no;
    }

    public void orderCopies(int pcopies) {
        if (pcopies > stock + copies) {
            System.out.println("Error: Order quantity should not exceed available stock.");
        } else {
            stock -= pcopies;
            copies += pcopies;
            no = pcopies;
        }
    }

    public abstract void sellCopy(int qty, double price);
}
class Book extends Publication {
    private String author;

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void orderCopies(int pcopies) {
        if (pcopies > getStock() + getCopies()) {
            System.out.println("Error: Order quantity should not exceed available stock.");
        } else {
            setStock(getStock() - pcopies);
            setCopies(getCopies() + pcopies);
            setGetNo(pcopies);
        }
    }

    @Override
    public void sellCopy(int qty, double price) {
        System.out.println("Total Book Sales: $" + (qty * price));
    }
}
class Magazine extends Publication {
    private String issue;

    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public void orderCopies(int pcopies) {
        if (pcopies > getStock() + getCopies()) {
            System.out.println("Error: Order quantity should not exceed available stock.");
        } else {
            setStock(getStock() - pcopies);
            setCopies(getCopies() + pcopies);
            setGetNo(pcopies);
        }
    }

    @Override
    public void sellCopy(int qty, double price) {
        System.out.println("Total Magazine Sales: $" + (qty * price));
    }

    public void setOrderQty(int qty) {
        setCopies(qty);
    }
}
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        List<Magazine> magazines = new ArrayList<>();
        int totalCostBooks = 0;
        int totalCostMagzines = 0;

        while (true) {
            System.out.println("Enter 1 to input Book:");
            System.out.println("Enter 2 to input Magazines:");
            System.out.println("Enter 3 to get book sales:");
            System.out.println("Enter 4 to get magazine sales:");
            System.out.println("Enter 5 to get total sales:");
            System.out.println("Enter 0 to quit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }
            
            
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of books:");
                    int numBooks = scanner.nextInt();
                    scanner.nextLine(); 

                    for (int i = 0; i < numBooks; i++) {
                        System.out.println("Enter details for book " + (i + 1));
                        Book book = new Book();

                        System.out.print("Title: ");
                        book.setTitle(scanner.nextLine());

                        System.out.print("Author: ");
                        book.setAuthor(scanner.nextLine());

                        System.out.print("Price: ");
                        book.setPrice(scanner.nextDouble());

                        System.out.print("Stock: ");
                        book.setStock(scanner.nextInt());
                        scanner.nextLine(); 

                        System.out.print("Order number of books: ");
                        int moreCopies = scanner.nextInt();
                        scanner.nextLine(); 

                        if (moreCopies > book.getStock()) {
                            System.out.print("Restock Books: ");
                            book.setCopies(scanner.nextInt());
                            scanner.nextLine(); 
                        } else {
                            System.out.println("Wanna restock? Enter 1 to restock:");
                            int ans1 = scanner.nextInt();
                            if (ans1 == 1) {
                                System.out.print("Restock Books: ");
                                book.setCopies(scanner.nextInt());
                                scanner.nextLine(); 
                            }
                        }

                        book.orderCopies(moreCopies);
                        books.add(book);
                    }
                    break;

                case 2:
                    System.out.println("Enter the number of magazines:");
                    int numMagazines = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    for (int i = 0; i < numMagazines; i++) {
                        System.out.println("Enter details for magazine " + (i + 1));
                        Magazine magazine = new Magazine();

                        System.out.print("Title: ");
                        magazine.setTitle(scanner.nextLine());

                        System.out.print("Price: ");
                        magazine.setPrice(scanner.nextDouble());

                        System.out.print("Stock: ");
                        magazine.setStock(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline

                        System.out.print("Order number of magazines: ");
                        magazine.orderCopies(scanner.nextInt());
                        scanner.nextLine(); // Consume the newline

                        if (magazine.getStock() > magazine.getNo()) {
                            System.out.print("Restock Magazines: ");
                            magazine.setOrderQty(scanner.nextInt());
                            scanner.nextLine(); // Consume the newline
                        } else {
                            System.out.println("Wanna restock? Enter 1 to restock:");
                            int ans1 = scanner.nextInt();
                            if (ans1 == 1) {
                                System.out.print("Restock Magazines: ");
                                magazine.setOrderQty(scanner.nextInt());
                                scanner.nextLine(); // Consume the newline
                            }
                        }

                        magazines.add(magazine);
                    }
                    break;

                case 3:
                    System.out.println("\nBook Sales:");
                    for (Book book : books) {
                        System.out.println("Title: " + book.getTitle());
                        book.sellCopy(book.getNo(), book.getPrice());
                        totalCostBooks += book.getNo() * book.getPrice();
                        System.out.println(totalCostBooks);
                    }
                    break;

                case 4:
                    System.out.println("\nMagazine Sales:");
                    for (Magazine magazine : magazines) {
                        System.out.println("Title: " + magazine.getTitle());
                        magazine.sellCopy(magazine.getNo(), magazine.getPrice());
                        totalCostMagzines += magazine.getNo() * magazine.getPrice();
                        System.out.println(totalCostMagzines);
                    }
                    break;

                case 5:
                	int total=totalCostMagzines+totalCostBooks;
                    System.out.println("Total Sales: $" +total);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}


