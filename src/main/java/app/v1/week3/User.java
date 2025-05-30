package app.v1.week3;

import java.util.ArrayList;
import java.util.List;

public class User {

    String username;
    List<Booking> bookings = new ArrayList<>();

    User(String username){
        this.username = username;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }
}
