import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement show = new DictionaryManagement();

    public void showAllWords() {
        for (int i = 0; i < show.manage.dictionary.size(); i++) {
            System.out.println("Tu TA: " + show.manage.dictionary.get(i).word_target);
            System.out.println("Tu TV: " + show.manage.dictionary.get(i).word_explain);
        }
    }

    public void dictionarySearcher(String find) {
        for (int i = 0; i < show.manage.dictionary.size(); i++) {
            int check = 0;
            String check_word = show.manage.dictionary.get(i).word_target;
            if (check_word.length() >= find.length()) {
                for (int j = 0; j < find.length(); j++) {
                    char a = find.charAt(j);
                    char b = check_word.charAt(j);
                    if (a == b) check ++;
                }
                if (check == find.length()) System.out.println(check_word);
            }
        }
    }

    public void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryCommandline dictionary = new DictionaryCommandline();
        dictionary.show.insertFromFile();
        //dictionary.showAllWords();
        Scanner sc = new Scanner(System.in);
        String EL = sc.nextLine();
        dictionary.show.dictionaryLookup(EL);
        EL = sc.nextLine();
        dictionary.dictionarySearcher(EL);
    }

}