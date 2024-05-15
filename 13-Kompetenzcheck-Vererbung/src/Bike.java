import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bike extends Vehicle {
    String belongsTo;
    int speedometer;
    int averageSpeed;
    int wheels;
    int seats;

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public Bike(int averageSpeed, String belongsTo) {
        this.averageSpeed = averageSpeed;
        this.belongsTo = belongsTo;
    }

    @Override
    public String honk() {
        return null;
    }

    @Override
    public void drive(String startLocation, int distance, String destination) {
        LocalDateTime startTime = LocalDateTime.now();

        double averageSpeed = getAverageSpeed();

        double driveDurationInMinutes = (distance / averageSpeed) * 60;

        Duration driveDuration = Duration.ofMinutes((long) driveDurationInMinutes);

        LocalDateTime endTime = startTime.plus(driveDuration);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedStartTime = startTime.format(formatter);
        String formattedEndTime = endTime.format(formatter);

        System.out.println("BIKE:");
        System.out.println(startLocation + ": " + formattedStartTime);
        System.out.println("Duration: " + (driveDuration.toHours()) + " hours and " + (driveDuration.toMinutes() % 60) + " minutes");
        System.out.println(destination + ": " + formattedEndTime);
        System.out.println();
    }

    @Override
    public String toString() {
        return "[" +
                "Belongs to= " + belongsTo +
                ']';
    }
}
