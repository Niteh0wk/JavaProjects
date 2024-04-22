import java.util.HashMap;
import java.util.Scanner;

public class Wörterbuch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menuSelection;

        String englishWord;
        String germanWord;
        String deleteWordPair;
        String searchTranslation;

        boolean exit = false;

        HashMap<String, String> englishGerman = new HashMap<>();
        HashMap<String, String> germanEnglish = new HashMap<>();

        do {
            do {
                System.out.println("Select a menu Point:");
                System.out.println("1. Add a Translation");
                System.out.println("2. Delete a Translation");
                System.out.println("3. Translator");
                System.out.println("0. Exit");
                menuSelection = sc.nextInt();
            }while (menuSelection <= -1 || menuSelection >= 4);


            if (menuSelection == 1){
                System.out.println("Type in the english Translation:");
                englishWord = sc.next();
                System.out.println("Type in the german Translation:");
                germanWord = sc.next();
                englishGerman.put(englishWord, germanWord);
                germanEnglish.put(germanWord, englishWord);
            }
            if (menuSelection == 2){
                System.out.println("Type in the german/english word you want to delete:");
                deleteWordPair = sc.next();
                englishGerman.remove(deleteWordPair);
                germanEnglish.remove(deleteWordPair);
            }
            if (menuSelection == 3){
                System.out.println("Type in the german/english word you want to translate:");
                searchTranslation = sc.next();
                if (englishGerman.containsKey(searchTranslation)){
                    System.out.println(englishGerman.get(searchTranslation));
                }else if (germanEnglish.containsKey(searchTranslation)){
                    System.out.println(germanEnglish.get(searchTranslation));
                }
            }
            if (menuSelection == 0){
                exit = true;
            }
        }while (!exit);

    }
}
