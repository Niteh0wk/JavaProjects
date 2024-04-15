public class Schleifen1 {
    public static void main(String[] args) {

        for (int x = 0; x < 101; x++){
            if (x % 3 == 0 && x % 5 == 0){
                System.out.println("Oachkatzlschwoaf");
            }else if (x % 3 == 0){
                System.out.println("Oachkatzl");
            }else if (x % 5 == 0){
                System.out.println("Schwoaf");
            }else {
                System.out.println(x);
            }

        }
    }
}
