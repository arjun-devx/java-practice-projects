public class Main {
    public static void main(String[] args) {

        Car car1 = new Car ("Tesla", 100, "mHawk"); //Created object
        car1.drive(); //calling method

        car1.setSpeed(120); //using setter.
        car1.setEngine("mHawk2.2");
        car1.drive(); //calling method again after updating the speed

        System.out.println("Brand: " + car1.getBrand() + " with Engine " + car1.getEngine()); //using getter
    }
}