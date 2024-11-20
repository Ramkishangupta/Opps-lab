package assignment5;

class Car implements Vehicle {
    private int speed;
    private int gear;
    private final int maxSpeed = 180;  // Maximum speed for Car

    public Car() {
        this.speed = 0;
        this.gear = 1;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear >= 1 && newGear <= 6) {
            gear = newGear;
            if(newGear==1) {
                speed = speed + 15; 
            }
            else if(newGear==2) {
            	speed = speed + 25;
            }
            else if(newGear==3) {
            	speed = speed + 35;
            }
            else if(newGear==4) {
            	speed = speed + 45;
            }
            else if(newGear==5) {
            	speed = speed + 55;
            }
            else if(newGear==6) {
            	speed = speed - 10;
            }
            System.out.println("Car gear changed to: " + gear);
            System.out.println("Car speed changed to: " + speed);
        } else {
            System.out.println("Invalid gear. Please select a gear between 1 and 6.");
        }
    }

    @Override
    public void speedUp(int increment) {
        if (speed == 0) {
            speed = 15; 
        } else {
        	if(increment<50) {
                speed += increment;
        	}
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        System.out.println("Car speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
    	if(decrement <= 40) {
    		speed -= decrement;
            if (speed < 0) {
            	speed = 0;
            	gear = 0;
            }
            System.out.println("Car speed decreased to: " + speed +"gear is: "+gear);
    	}
    }

    public void printState() {
        System.out.println("Car state - Speed: " + speed + ", Gear: " + gear);
    }
}