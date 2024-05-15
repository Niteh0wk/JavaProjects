import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LKW extends Vehicle {
    String manufacturer;
    String belongsTo;
    int speedometer;
    int wheels;
    int averageSpeed;
    boolean motor;
    int horsepower;
    int seats;
    boolean trailer;
    int cargo;

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public LKW(int averageSpeed, String manufacturer, String belongsTo, int horsepower) {
        this.averageSpeed = averageSpeed;
        this.manufacturer = manufacturer;
        this.belongsTo = belongsTo;
        this.horsepower = horsepower;
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

        System.out.println("LKW:");
        System.out.println(startLocation + ": " + formattedStartTime);
        System.out.println("Duration: " + (driveDuration.toHours()) + " hours and " + (driveDuration.toMinutes() % 60) + " minutes");
        System.out.println(destination + ": " + formattedEndTime);
        System.out.println();
    }

    @Override
    public String toString() {
        return "LKW{" +
                "Manufacturer= " + manufacturer +
                ", Belongs to= " + belongsTo +
                ", Horsepower=" + horsepower +
                '}';
    }
}
