import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> cameras = new ArrayList<>();

        cameras.add("Sony");
        cameras.add("Nokia");
        cameras.add("Canon");

        ArrayList<Object> lenses = new ArrayList<>();

        lenses.add(200);
        lenses.add(400);

        Camera camera1 = new Camera();
        camera1.setBrand(cameras.getFirst().toString());
        camera1.setMegaPixels(50);
        camera1.setDisplaySize(4);
        camera1.setColored(true);


        Camera camera2 = new Camera();
        camera2.setBrand(cameras.get(1).toString());
        camera2.setMegaPixels(30);
        camera2.setDisplaySize(2);
        camera2.setColored(false);

        Camera camera3 = new Camera();
        camera3.setBrand(cameras.get(2).toString());
        camera3.setMegaPixels(45);
        camera3.setDisplaySize(6);
        camera3.setColored(false);

        Lens lens1 = new Lens();
        lens1.setFocalLength((Integer) lenses.getFirst());
        camera1.setLens(lens1);
        camera3.setLens(lens1);

        Lens lens2 = new Lens();
        lens2.setFocalLength((Integer) lenses.get(1));
        camera2.setLens(lens2);


        System.out.println(camera1 + "\n");
        System.out.println(camera2 + "\n");
        System.out.println(camera3 + "\n");
    }
}