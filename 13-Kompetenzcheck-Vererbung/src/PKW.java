import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PKW extends Vehicle {
    String manufacturer;
    String belongsTo;
    int speedometer;
    int averageSpeed;
    int wheels;
    boolean motor;
    int horsepower;
    int seats;
    boolean honk;


    public int getAverageSpeed() {
        return averageSpeed;
    }

    public PKW(int averageSpeed, boolean honk, String manufacturer, String belongsTo, int wheels, boolean motor, int horsepower, int seats) {
        this.averageSpeed = averageSpeed;
        this.honk = honk;
        this.manufacturer = manufacturer;
        this.belongsTo = belongsTo;
        this.wheels = wheels;
        this.motor = motor;
        this.horsepower = horsepower;
        this.seats = seats;
    }

    @Override
    public String honk() {
        if (honk){
            return "<)) HONK <)) HONK";
        }else {
            return "No honk :(";
        }

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

        System.out.println("PKW:");
        System.out.println(startLocation + ": " + formattedStartTime);
        System.out.println("Duration: " + (driveDuration.toHours()) + " hours and " + (driveDuration.toMinutes() % 60) + " minutes");
        System.out.println(destination + ": " + formattedEndTime);
        System.out.println(honk());
        System.out.println();
    }

    @Override
    public String toString() {
        return "[" +
                "Manufacturer= " + manufacturer +
                ", Belongs to= " + belongsTo +
                ", Horsepower= " + horsepower +
                ']';
    }
}
