package app.v1.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota Corolla", "ABC-123", false));
        cars.add(new Car("Honda Civic", "XYZ-456", true));
        cars.add(new Car("BMW X5", "JKL-789", true));

        List<User> users = new ArrayList<>();

        users.add(new User("Alice"));
        users.add(new User("Bob"));
        users.add(new User("Charlie"));



        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== Welcome, please choose the option ===");

            while (true) {
                System.out.println("\n=== User Management System ===");
                System.out.println("1. Add User");
                System.out.println("2. View Users");
                System.out.println("3. Login user");
                System.out.println("4. View Bookings");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1: {
                        System.out.print("Enter user name: ");
                        String username = scanner.nextLine();
                        User newUser = new User(username);
                        users.add(newUser);
                        break;
                    }
                    case 2:
                        for(User user : users) {
                            System.out.println(user.toString());
                        }
                        break;
                    case 3:
                        System.out.print("Enter user name: ");
                        String username = scanner.nextLine();
                        boolean found = false;
                        for (User user : users) {
                            if (Objects.equals(username, user.getUsername())) {
                                found = true;
                                userMenu(user, scanner, cars);
                            }
                        }
                        if (!found) {
                            System.out.println("User not found");
                        }
                        break;
                    case 4:
                        System.out.println("All bookings: ");
                        for (int i = 0; i < users.size(); i++) {
                            if (!users.get(i).getBookings().isEmpty()) {
                                System.out.println((i + 1) + ". " + users.get(i).toString());
                                for (int j = 0; j < users.get(i).getBookings().size(); j++) {
                                    System.out.println((j + 1) + ". " + users.get(i).getBookings().get(j).toString());
                                }
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
    }

    static void userMenu(User user, Scanner scanner, List<Car> cars) {
        List<Car> availableCars = cars.stream()
                .filter(Car::isAvailable)
                .toList();

        while (true) {
            System.out.println("\n=== Please choose the option  ===");
            System.out.println("1. View Bookings");
            System.out.println("2. Add Booking");
            System.out.println("3. Delete Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    if (!user.getBookings().isEmpty()){
                        for (int i = 0; i < user.getBookings().size(); i++) {
                            System.out.println((i + 1) + ". " + user.getBookings().get(i).toString());
                        }
                    } else {
                        System.out.println(" Bookings not found ");
                    }

                    break;
                }
                case 2:
                    if (!availableCars.isEmpty()) {
                        for (int i = 0; i < availableCars.size(); i++) {
                            System.out.println((i + 1) + ". " + availableCars.get(i).toString());
                        }
                        System.out.print("Enter the number of car: ");
                        int carIndex = Integer.parseInt(scanner.nextLine());

                        System.out.print("Duration of booking(days): ");
                        int days = Integer.parseInt(scanner.nextLine());

                        try{
                            Booking booking = new Booking(availableCars.get(carIndex - 1), days);
                            availableCars.get(carIndex - 1).setAvailable(false);

                            user.addBooking(booking);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error: Incorrect input");
                        }

                    } else {
                        System.out.println(" There is no car available ");
                    }

                    break;
                case 3:
                    System.out.println("Your Bookings: ");
                    for (int i = 0; i < user.getBookings().size(); i++) {
                        System.out.println((i + 1) + ". " + user.getBookings().get(i).toString());
                    }

                    System.out.print("Enter the id of Booking: ");
                    int bookingIndex = Integer.parseInt(scanner.nextLine());
                    user.getBookings().remove(bookingIndex - 1);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}