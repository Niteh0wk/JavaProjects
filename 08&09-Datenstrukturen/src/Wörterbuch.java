import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Wörterbuch {
    static HashMap<String, String> englishGerman = new HashMap<>();
    static HashMap<String, String> germanEnglish = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menuSelection;

        String englishWord;
        String germanWord;
        String deleteWordPair;
        String searchTranslation;

        boolean exit = false;

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
                addTranslation(englishWord, germanWord, englishGerman, germanEnglish);
            }
            if (menuSelection == 2){
                System.out.println("Type in the german/english word you want to delete:");
                deleteWordPair = sc.next();
                deleteTranslation(deleteWordPair, englishGerman, germanEnglish);
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

    public static void addTranslation(String englishWord, String germanWord, HashMap<String, String> englishGerman, HashMap<String, String> germanEnglish){
        englishGerman.put(englishWord, germanWord);
        germanEnglish.put(germanWord, englishWord);
    }
    
    public static void deleteTranslation(String deleteWordPair, HashMap<String, String> englishGerman, HashMap<String, String> germanEnglish){
        englishGerman.remove(deleteWordPair);
        germanEnglish.remove(deleteWordPair);
    }

}
