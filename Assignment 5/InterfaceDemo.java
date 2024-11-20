package assignment5;
import java.util.Scanner;

public class InterfaceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = null;

        while (true) {
            System.out.println("Select a Vehicle:");
            System.out.println("1. Bicycle");
            System.out.println("2. Bike");
            System.out.println("3. Car");
            System.out.println("4. Exit");

            int vech = scanner.nextInt();

            switch (vech) {
                case 1:
                    vehicle = new Bicycle();
                    break;
                case 2:
                    vehicle = new Bike();
                    break;
                case 3:
                    vehicle = new Car();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    continue;
            }

            while (true) {
                System.out.println("\nSelected Vehicle: " + vehicle.getClass().getSimpleName());
                System.out.println("Choose an action:");
                System.out.println("1. Change Gear");
                System.out.println("2. Speed Up");
                System.out.println("3. Apply Brakes");
                System.out.println("4. Display State");
                System.out.println("5. Select Another Vehicle");

                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                    	if(vech == 1) {
                    		System.out.println("Bycycle has 5 gear :"
                    				+"\n"+ "Gear 1 2 4 Speed increases by 3"
                    				+"\n"+ "Gear 3 and 5 speed increses by 5");
                    	}
                    	else if(vech == 2) {
                    		System.out.println("Bike has 6 gear :"
                    				+"\n"+"Gear 1 speed increases by 10"
                    				+"\n"+"Gear 2 speed increases by 15"
                    				+"\n"+"Gear 3 speed increases by 20"
                    				+"\n"+"Gear 4 speed increases by 40"
                    				+"\n"+"Gear 5 speed increases by 30"
                    				+"\n"+"Gear 6 speed increases by 25");
                    	}
                    	else if(vech == 3) {
                    		System.out.println("Car has 6 gear 5 to increase speed and 1 for revrese : "
                    				+"\n"+ "Gear 1 speed increases by 15"
                    				+"\n"+"Gear 1 speed increases by 25"
                    				+"\n"+"Gear 1 speed increases by 35"
                    				+"\n"+ "Gear 1 speed increases by 45"
                    				+"\n"+ "Gear 1 speed increases by 55"
                    				+"\n"+ "Gear 1 speed dec by 10");
                    	}
                        System.out.print("Enter new gear ");
                        int gear = scanner.nextInt();
                        vehicle.changeGear(gear);
                        break;
                    case 2:
                    	if(vech == 1) {
                    		System.out.println("Max speed of bycycle is 25"
                    				+"\n"+ "speed can be increased by 10 m/s max ");
                    	}
                    	else if(vech == 2) {
                    		System.out.println("Max speed of bike is 120 "
                    				+"\n"+ "speed can be increased by 30 m/s max ");
                    	}
                    	else if(vech == 3) {
                    		System.out.println("Max speed of car is 180 "
                    				+"\n"+ "speed can be increased by 50 m/s max ");
                    	}
                        System.out.print("Enter speed increment: ");
                        int speedUp = scanner.nextInt();
                        vehicle.speedUp(speedUp);
                        break;
                    case 3:
                    	if(vech == 1) {
                    		System.out.println("Speed can be decreased by 10m/s ");
                    	}
                    	else if(vech == 2) {
                    		System.out.println("Speed can be decreased by 25m/s ");
                    	}
                    	else if(vech == 3) {
                    		System.out.println("Speed can be decreased by 40m/s ");
                    	}
                        System.out.print("Enter speed decrement: ");
                        int brakes = scanner.nextInt();
                        vehicle.applyBrakes(brakes);
                        break;
                    case 4:
                        if (vehicle instanceof Bicycle) {
                            ((Bicycle) vehicle).printState();
                        } else if (vehicle instanceof Bike) {
                            ((Bike) vehicle).printState();
                        } else if (vehicle instanceof Car) {
                            ((Car) vehicle).printState();
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid action. Please select again.");
                        continue;
                }

                if (action == 5) {
                    break;
                }
            }
        }
    }
}


