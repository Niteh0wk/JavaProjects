import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Mengenlehre {
    public static void main(String[] args) {
        Set<Integer> A = new HashSet<>();
        A.add(1);
        A.add(3);
        A.add(5);
        Set<Integer> B = new HashSet<>();
        B.add(3);
        B.add(5);
        B.add(7);
        Set<Integer> C = new HashSet<>();
        C.add(5);
        C.add(7);
        C.add(9);
        System.out.println("ALL UNIONS");
        System.out.println(union(A,B));
        System.out.println(union(A,C));
        System.out.println(union(B,C));
        System.out.println("ALL INTERSECTIONS");
        System.out.println(intersection(A,B));
        System.out.println(intersection(A,C));
        System.out.println(intersection(B,C));
        System.out.println(intersection(B,A));
        System.out.println(intersection(C,A));
        System.out.println(intersection(C,B));
        System.out.println("Union A ∪ B ∪ C");
        System.out.println(union(A,union(B,C)));
        System.out.println("Beispiel A ∪ (B ∩ C)");
        System.out.println(union(A,intersection(B,C)));
    }
    public static HashSet<Integer> union(Set<Integer> A, Set<Integer> B){
         HashSet<Integer> result = new HashSet<>(A);
         result.addAll(B);
         return result;
    }
    public static HashSet<Integer> intersection(Set<Integer> A, Set<Integer> B){
        HashSet<Integer> result = new HashSet<>(A);
        result.retainAll(B);
        return result;
    }
}