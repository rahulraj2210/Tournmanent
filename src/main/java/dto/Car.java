package dto;

public class Car {

    int carId;

    String carName;

    double baseSpeed;

    double topSpeed;

    int carPartId;

    public Car(int carId, String carName, double baseSpeed, double topSpeed, int carPartId) {
        this.carId = carId;
        this.carName = carName;
        this.baseSpeed = baseSpeed;
        this.topSpeed = topSpeed;
        this.carPartId = carPartId;
    }

    public String getCarName() {
        return carName;
    }

    public double getBaseSpeed() {
        return baseSpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public int getCarPartId() {
        return carPartId;
    }

    public int getCarId() {
        return carId;
    }

}
