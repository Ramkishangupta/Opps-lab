package assignment5;

class Bicycle implements Vehicle {
    private int speed;
    private int gear;
    private final int maxSpeed = 25;  // Maximum speed for Bicycle

    public Bicycle() {
        this.speed = 0;
        this.gear = 1;
    }
    
    @Override
    public void changeGear(int newGear) {
        if (newGear >= 1 && newGear <= 5) {
            gear = newGear;
            if(newGear == 3 || speed==5) {
            	if(speed<=30) {
                    speed = speed +5; 
            	}
            	else if(speed>30) {
            		System.out.println("You are at the maximum speed");
            	}
            }
            else {
            	if(speed<=20) {
                    speed = speed  + 3; 
            	}
            	else if(speed>20) {
            		System.out.println("To increase speed change your gear to 3 or 5");
            	}
            }
            System.out.println("Bicycle gear changed to: " + gear);
            System.out.println("Bicycle speed changed to: " + speed);
        } else {
            System.out.println("Invalid gear. Please select a gear between 1 and 5.");
        }
    }

    @Override
    public void speedUp(int increment) {
        if (speed == 0) {
            speed = 5; 
        } else {
        	if(increment<=10) {
                speed += increment;
        	}
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        System.out.println("Bicycle speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        if(decrement<=10) {
        	speed -= decrement;
            if (speed < 0) {
            	speed = 0;
            	gear = 0;
            }
            System.out.println("Bicycle speed decreased to: " + speed);
        }
    }

    public void printState() {
        System.out.println("Bicycle state - Speed: " + speed + ", Gear: " + gear);
    }
}