public class Schleifen2 {
    public static void main(String[] args) {

        for (int x = 1; x < 11; x++){
            System.out.println(x + "er Reihe:");
            for (int y = 1; y < 11; y++){
                System.out.println(y + " * " + x + " = " + y*x);
            }
        }
    }
}
