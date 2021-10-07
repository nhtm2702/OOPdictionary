import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCommandline {

    DictionaryManagement show = new DictionaryManagement();

    public void showAllWords() {
        System.out.println("No      |Tieng Anh           |Tieng Viet");
        for (int i = 0; i < show.manage.dictionary.size(); i++) {
            int No = i + 1;
            System.out.println(No + "        |" + show.manage.dictionary.get(i).word_target + "                |" + show.manage.dictionary.get(i).word_explain);
        }
    }

    public void dictionarySearcher(String find) {
        for (int i = 0; i < show.manage.dictionary.size(); i++) {
            boolean check = false;
            String check_word = show.manage.dictionary.get(i).word_target;
            for (int j = 0; j < find.length(); j++) {
                char a = find.charAt(j);
                char b = check_word.charAt(j);
                if (a == b) check = true;
            }
            if (check == true) {
                System.out.println(check_word);
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