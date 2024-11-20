package Ass9b;
import java.util.*;
public class Product {
    Scanner sc = new Scanner(System.in);
    String productName;
    int costPrice, sellPrice, avStock, unitsSold = 0;
    static int totalSoldAmount = 0;

    void create() {
        System.out.println("enter PRODUCT NAME :");
        productName = sc.next();
        System.out.println("enter COST PRICE :");
        costPrice = sc.nextInt();
        System.out.println("enter SELL PRICE :");
        sellPrice = sc.nextInt();
        System.out.println("enter AVAILABLE STOCK :");
        avStock = sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, op1, op2, size, x;
        Product p = new Product();
        ArrayList<Product> arr = new ArrayList<Product>();
        ArrayList<Integer> pur = new ArrayList<Integer>();
        
        do {
            System.out.println("*************MENU************");
            System.out.println("1. enter 1 for SELLER :");
            System.out.println("2. enter 2 for CUSTOMER :");
            System.out.println("3. enter 3 to exit code :");
            System.out.print("enter your choice : ");
            ch = sc.nextInt();
            
            switch (ch) {
                case 1:
                    do {
                        System.out.println("*********SELLER MENU*********");
                        System.out.println("1. enter 1 to ADD PRODUCTS :");
                        System.out.println("2. enter 2 to BALANCE STOCK : ");
                        System.out.println("3. enter 3 to CHECK PROFIT OR LOSS :");
                        System.out.println("4. enter 4 to exit code :");
                        System.out.print("enter your choice : ");
                        op1 = sc.nextInt();
                        
                        switch (op1) {
                            case 1:
                                System.out.println("enter the NUMBER OF PRODUCTS in the list :");
                                size = sc.nextInt();
                                for (int i = 0; i < size; i++) {
                                    Product newProduct = new Product();
                                    System.out.println("enter DETAILS OF PRODUCT :" + (i + 1));
                                    newProduct.create();
                                    arr.add(newProduct);
                                    System.out.println("");
                                }
                                break;

                            case 2:
                                System.out.println("*********BALANCE STOCK SHEET***********");
                                for (int i = 0; i < arr.size(); i++) {
                                    Product product = arr.get(i);
                                    System.out.println("product: " + (i + 1) + ", product name: " + product.productName + ", its available stock: " + product.avStock);
                                }
                                System.out.println("");
                                break;

                            case 3:
                                System.out.println("*******PROFIT/LOSS SHEET FOR PRODUCTS***********");
                                for (int i = 0; i < arr.size(); i++) {
                                    Product product = arr.get(i);
                                    int profit = (product.sellPrice - product.costPrice) * product.unitsSold;
                                    int loss = (product.costPrice - product.sellPrice) * product.unitsSold;

                                    System.out.println("for product number : " + (i + 1) + " product name :" + product.productName);
                                    if (product.unitsSold > 0) {
                                        if (profit > 0) {
                                            System.out.println("it is PROFIT case ");
                                            System.out.println("PROFIT is : " + profit);
                                        } else if (loss > 0) {
                                            System.out.println("it is LOSS case ");
                                            System.out.println("LOSS is : " + loss);
                                        } else {
                                            System.out.println("NO profit or loss ");
                                        }
                                    } else {
                                        System.out.println("No sales made yet for this product.");
                                    }
                                }
                                System.out.println("");
                                break;

                            case 4:
                                System.out.println("exit code!!!");
                                break;
                            default:
                                System.out.println("enter valid choice : ");
                                break;
                        }
                    } while (op1 != 4);
                    break;

                case 2:
                    do {
                        System.out.println("**************CUSTOMER MENU*************");
                        System.out.println("1. enter 1 to see LIST OF PRODUCTS :");
                        System.out.println("2. enter 2 to PURCHASE :");
                        System.out.println("3. enter 3 to see BILL : ");
                        System.out.print("enter your choice : ");
                        op2 = sc.nextInt();
                        
                        switch (op2) {
                            case 1:
                                System.out.println("******LIST OF PRODUCTS*******");
                                for (int i = 0; i < arr.size(); i++) {
                                    Product pr = arr.get(i);
                                    System.out.println("product: " + (i + 1) + ", product name: " + pr.productName + ", product cost: " + pr.sellPrice);
                                }
                                System.out.println("");
                                break;
                                
                            case 2:
                                System.out.println("enter the NUMBER OF items TO BE PURCHASED");
                                x = sc.nextInt();
                                for (int i = 0; i < x; i++) {
                                    System.out.println("product: " + (i + 1) + " to be purchased is PRODUCT NUMBER ");
                                    int productIndex = sc.nextInt();
                                    pur.add(productIndex);

                                    Product selectedProduct = arr.get(productIndex - 1);
                                    if (selectedProduct.avStock > 0) {
                                        selectedProduct.unitsSold++;
                                        selectedProduct.avStock--;
                                    } else {
                                        System.out.println("Sorry, product out of stock.");
                                    }
                                }
                                System.out.println("list of purchased items : ");
                                for (int i = 0; i < x; i++) {
                                    Product m = arr.get(pur.get(i) - 1);
                                    System.out.println("product: " + (i + 1) + ", product name: " + m.productName);
                                }
                                System.out.println("");
                                break;

                            case 3:
                                System.out.println("*********BILL*********");
                                int totalAmount = 0;
                                for (int i = 0; i < pur.size(); i++) {
                                    Product m = arr.get(pur.get(i) - 1);
                                    System.out.println("product: " + (i + 1) + ", product name: " + m.productName + ", product cost: " + m.sellPrice);
                                    totalAmount += m.sellPrice;
                                    totalSoldAmount += m.sellPrice;
                                }
                                System.out.println("the TOTAL AMOUNT TO BE PAID: " + totalAmount);
                                System.out.println("");
                                break;

                            case 4:
                                System.out.println("exit code");
                                break;

                            default:
                                System.out.println("enter valid choice");
                        }
                    } while (op2 != 4);
                    break;
            }
        } while (ch != 3);
    }
}
