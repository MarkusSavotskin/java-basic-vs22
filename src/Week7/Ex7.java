package Week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex7 {
    private static class Dictionary {
        private HashMap<String, String> dictionary = new HashMap<String, String>();

        public void add(String word, String translation) {
            dictionary.put(word, translation);
        }

        public String translate(String word) {
            return dictionary.get(word);
        }

        public int amountOfWords() {
            return dictionary.size();
        }

        public ArrayList<String> translationList() {
            ArrayList<String> list = new ArrayList<>();
            for (String key : this.dictionary.keySet()) {
                list.add(key + " = " + dictionary.get(key));
            }
            return list;
        }
    }

    private static class TextUserInterface {
        private Scanner reader;
        private Dictionary dictionary;

        public TextUserInterface(Scanner reader, Dictionary dictionary) {
            this.reader = reader;
            this.dictionary = dictionary;
        }

        public void start() {
            String enteredStatement;
            String key;
            String value;
            System.out.println("Info:");
            System.out.println("    add - adds a word pair to the dictionary");
            System.out.println("    translate - asks a word and prints its translation");
            System.out.println("    quit - quit the text user interface");

            while (true) {
                System.out.println();
                System.out.print("Statement: ");
                enteredStatement = this.reader.nextLine();

                if (enteredStatement.equals("quit")) {
                    break;

                } else if (enteredStatement.equals("add")) {
                    System.out.print("In Estonian: ");
                    key = this.reader.nextLine();
                    System.out.print("Translation: ");
                    value = this.reader.nextLine();
                    dictionary.add(key, value);

                } else if (enteredStatement.equals("translate")) {
                    System.out.print("Give a word: ");
                    System.out.println("Translation: " + dictionary.translate(this.reader.nextLine()));

                } else {
                    System.out.println("Unknown statement");
                }
            }
            System.out.println("Cheers!");
        }
    }

    public static void main(String[] args) {
        String input = "translate\n" + "monkey\n" +
                "translate\n" + "cheese\n" +
                "add\n" + "cheese\n" + "juust\n" +
                "translate\n" + "cheese\n" +
                "quit\n";

        //Scanner reader = new Scanner(System.in);
        Scanner reader = new Scanner(input);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}
