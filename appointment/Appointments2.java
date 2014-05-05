/*
    name: Joshua Rodriguez
    email: ewized@gmail.com
    file: Appointments.java
    problem: chapter 9 number 23 page 460
    description:
*/
import java.util.*;

public class Appointments {
    // The interface
    public interface Appointment {
        // get the message of appointment
        public String getMessage();
    }

    // The OneTime appointment class
    public static class OneTime implements Appointment {
        private String message;
        private int day;
        private int month;
        private int year;

        // Create the appointment
        public OneTime(int day, int month, int year, String message) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.message = message;
        }

        // Get the message
        public String getMessage() { return message; }

        // Get the day
        public int getDay() { return day; }

        // Get the month
        public int getMonth() { return month; }

        // Get the year
        public int getYear() { return year; }

        @Override
        public String toString() {
            return String.format(
                "Every this on %s/%s/%s you have: %s",
                getDay(),
                getMonth(),
                getYear(),
                getMessage()
            );
        }
    }

    // The Daily appointment class
    public static class Daily implements Appointment {
        private String message;

        // Create the appointment
        public Daily(String message) {
            this.message = message;
        }

        // Get the message
        public String getMessage() { return message; }

        @Override
        public String toString() {
            return String.format(
                "Every day you have: %s",
                getMessage()
            );
        }
    }

    /// The Monthly appointment class
    public static class Monthly implements Appointment {
        private String message;
        private int day;

        // Create the appointment
        public Monthly(int day, String message) {
            this.day = day;
            this.message = message;
        }

        // Get the message
        public String getMessage() { return message; }

        // Get the day
        public int getDay() { return day; }

        @Override
        public String toString() {
            return String.format(
                "Every Month on %s you have: %s",
                getDay(),
                getMessage()
            );
        }
    }

    // constants
    public static final File file = new File("database.json");

    // The driver  / tester method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Appointment> appointments = new ArrayList<Appointment>() {{
            add(new Daily("Work 9 to 5"));
            add(new Daily("School 5 to 9"));
            add(new Monthly(5, "Car Wash"));
            add(new OneTime(12,25,2014, "Christmas"));
        }};

        // Ask the user for a date
        System.out.print("Enter the day/month/year in that order: ");
        String[] line = scan.nextLine().split("/");
        int day = Integer.valueOf(line[0]);
        int month = Integer.valueOf(line[1]);
        int year = Integer.valueOf(line[2]);

        // Print out all dates that lay on that day
        System.out.printf("\nYou have the following appointments on (%s/%s/%s):\n", day, month, year);
        for (Appointment appointment : appointments) {
            if (appointment instanceof Daily) {
                System.out.println(appointment);
            }
            else if(appointment instanceof Monthly) {
                Monthly check = (Monthly)appointment;
                if (day == check.getDay()) {
                    System.out.println(appointment);
                }
            }
            else if (appointment instanceof OneTime) {
                OneTime check = (OneTime)appointment;
                if (day == check.getDay() && month == check.getMonth() && year == check.getYear()) {
                    System.out.println(appointment);
                }
            }
        }
    }

    // Load the file
    public static ArrayList<Appointment> loadAppointments() {
        
    }
}