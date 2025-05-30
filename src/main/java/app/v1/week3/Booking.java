package app.v1.week3;

public class Booking {
    Car car;
    int duration;

    Booking(Car car, int duration) {
        this.car = car;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Booking{" +
                ", car=" + car +
                "duration="+ duration +"(days)"+'}';
    }
}
