public class Car {

    //Attribute (Fields)
    private final String brand;
    private int speed;
    private String engine;

    //constructor
    public Car (String brand, int speed, String engine) {
        this.brand = brand;
        this.speed = speed;
    }

    //method
    public void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h.");
    }

    //getter
    public String getBrand() {
        return brand;
    }
    public String getEngine() {
        return engine;
    }

    //setter
    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
