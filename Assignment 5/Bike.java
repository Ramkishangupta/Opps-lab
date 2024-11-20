package assignment5;

class Bike implements Vehicle {
    private int speed;
    private int gear;
    private final int maxSpeed = 120;  

    public Bike() {
        this.speed = 0;
        this.gear = 1;
    }

    @Override
    public void changeGear(int newGear) {
        if (newGear >= 1 && newGear <= 6) {
            gear = newGear;
            updateSpeedForGear();
            System.out.println("Bike gear changed to: " + gear);
            System.out.println("Bike speed changed to: " + speed);
        } else {
            System.out.println("Invalid gear. Please select a gear between 1 and 6.");
        }
    }

    private void updateSpeedForGear() {
        int speedIncrement;
        int maxGearSpeed;

        switch (gear) {
            case 1:
                speedIncrement = (speed <= 30) ? 10 : 0;
                maxGearSpeed = 30;
                break;
            case 2:
                speedIncrement = (speed <= 45) ? 15 : 0;
                maxGearSpeed = 45;
                break;
            case 3:
                speedIncrement = (speed <= 80) ? 20 : 0;
                maxGearSpeed = 80;
                break;
            case 4:
                speedIncrement = (speed <= 120) ? 40 : 0;
                maxGearSpeed = 120;
                break;
            case 5:
                speedIncrement = (speed <= 60) ? 30 : 0;
                maxGearSpeed = 60;
                break;
            case 6:
                speedIncrement = (speed <= 50) ? 40 : 0;
                maxGearSpeed = 50;
                break;
            default:
                speedIncrement = 0;
                maxGearSpeed = 0;
        }

        if (speed + speedIncrement <= maxGearSpeed) {
            speed += speedIncrement;
        } else {
            System.out.println("To increase speed, change gear or reduce speed.");
        }
    }

    @Override
    public void speedUp(int increment) {
        if (speed == 0) {
            speed = 10; 
        } else {
            if (increment <= 30 && speed <=	 maxSpeed) {
                speed += increment;
            }
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        System.out.println("Bike speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        if (decrement <= 25) {
            speed -= decrement;
            if (speed < 0) {
                speed = 0;
            }
            System.out.println("Bike speed decreased to: " + speed);
        }
    }

    public void printState() {
        System.out.println("Bike state - Speed: " + speed + ", Gear: " + gear);
    }
}
