import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class DictionaryCommandline {

    DictionaryManagement show = new DictionaryManagement();

    public void showAllWords() {
        Set<String> EL = show.manage.dictionary.keySet();
        for (String el : EL) {
            System.out.println(el);
            System.out.println(show.manage.dictionary.get(el));
        }
    }

    public void dictionarySearcher(String find) {
        Set<String> EL = show.manage.dictionary.keySet();
        for (String el : EL) {
            int check = 0;
            String check_word = el;
            if (check_word.length() >= find.length()) {
                for (int i = 0; i < find.length(); i++) {
                    char a = find.charAt(i);
                    char b = check_word.charAt(i);
                    if (a == b) check++;
                }
                if (check == find.length()) System.out.println(check_word);
            }
        }
    }

    public void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryCommandline dictionary = new DictionaryCommandline();
        dictionary.show.insertFromFile();
        dictionary.showAllWords();
        Scanner sc = new Scanner(System.in);
        String EL = sc.nextLine();
        dictionary.show.dictionaryLookup(EL);
        EL = sc.nextLine();
        dictionary.dictionarySearcher(EL);
    }

}