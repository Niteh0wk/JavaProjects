import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> vehicles = new ArrayList<>();

        vehicles.add(new PKW(130,false, "Audi", "Georg", 4,true, 250,5));
        vehicles.add(new PKW(200, true, "Toyota", "Otto",4,true, 1000, 2));
        vehicles.add(new LKW(50, false,"Mercedes","Johan",400));
        vehicles.add(new LKW(40, false,"MAN","Rüdiger",450));
        vehicles.add(new Bike(15, true,"Jürgen"));
        vehicles.add(new Bike(10, false,"Ralph"));
        vehicles.add(new CargoBike(5,false,"Agatha"));
        vehicles.add(new CargoBike(7,true,"Selina"));

        for (Object vehicle : vehicles) {
            if (vehicle instanceof PKW) {
                System.out.println(vehicle);
                ((PKW) vehicle).drive("Linz", 220, "Graz");
            } else if (vehicle instanceof LKW) {
                System.out.println(vehicle);
                ((LKW) vehicle).drive("Linz", 220, "Graz");
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle);
                ((Bike) vehicle).drive("Linz", 220, "Graz");
            } else if (vehicle instanceof CargoBike) {
                System.out.println(vehicle);
                ((CargoBike) vehicle).drive("Linz", 220, "Graz");
            }
        }

        for (Object vehicle : vehicles) {
            if (vehicle instanceof PKW) {
                System.out.println(vehicle);
                ((PKW) vehicle).drive("Linz", 180, "Wien");
            } else if (vehicle instanceof LKW) {
                System.out.println(vehicle);
                ((LKW) vehicle).drive("Linz", 180, "Wien");
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle);
                ((Bike) vehicle).drive("Linz", 180, "Wien");
            } else if (vehicle instanceof CargoBike) {
                System.out.println(vehicle);
                ((CargoBike) vehicle).drive("Linz", 180, "Wien");
            }
        }

        for (Object vehicle : vehicles) {
            if (vehicle instanceof PKW) {
                System.out.println(vehicle);
                ((PKW) vehicle).drive("Wien", 200, "Graz");
            } else if (vehicle instanceof LKW) {
                System.out.println(vehicle);
                ((LKW) vehicle).drive("Wien", 200, "Graz");
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle);
                ((Bike) vehicle).drive("Wien", 200, "Graz");
            } else if (vehicle instanceof CargoBike) {
                System.out.println(vehicle);
                ((CargoBike) vehicle).drive("Wien", 200, "Graz");
            }
        }
    }
}
