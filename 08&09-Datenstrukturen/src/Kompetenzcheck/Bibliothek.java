package Kompetenzcheck;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Bibliothek {
    static HashMap<String, HashSet<String>> bib = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String search;

        addAuthor("Martin Luther King");
        addTitle("Martin Luther King", "I Have a Dream");

        addAuthor("J.K. Rowling");
        addTitle("J.K. Rowling", "Harry Potter und der Stein der Weisen");

        System.out.println("All Authors: \n" + bib.keySet());
        System.out.println("All Authors and their books: \n" + bib);
        System.out.println("Of what book would you like to know the Author?");
        search = sc.nextLine();
        System.out.println(searchAuthor(search));
        printAuthorAndTitle();
    }

    public static void addAuthor(String author){
        bib.put(author, new HashSet<>());
    }

    public static void addTitle(String author, String title){
        bib.get(author).add(title);
    }

    public static String searchAuthor(String title){
        for (String author : bib.keySet()){
            if (bib.get(author).contains(title)){
                return author;
            }
        }
        return null;
    }

    public static void printAuthorAndTitle(){
        for (String author : bib.keySet()){
            for (String title : bib.get(author)){
                System.out.println("'" + title + "' von '" + author + "'");
            }
        }
    }
}
