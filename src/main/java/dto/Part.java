package dto;

public class Part {

    int carPartId;

    int partId;

    double price;

    double speedBoost;

    public Part(int carPartId, int partId, double price, double speedBoost) {
        this.carPartId = carPartId;
        this.partId = partId;
        this.price = price;
        this.speedBoost = speedBoost;
    }

    public int getCarPartId() {
        return carPartId;
    }

    public void setCarPartId(int carPartId) {
        this.carPartId = carPartId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpeedBoost() {
        return speedBoost;
    }

    public void setSpeedBoost(double speedBoost) {
        this.speedBoost = speedBoost;
    }

}
