package app.v1.week3;

public class Car {
    String model;
    String plateNumber;
    boolean isAvailable;

    Car(String model, String plateNumber, boolean isAvailable) {
        this.model = model;
        this.plateNumber = plateNumber;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
