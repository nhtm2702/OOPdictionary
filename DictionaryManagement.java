import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary manage = new Dictionary();

    public void dictionaryLookup(String find) {
        for (int i = 0; i < manage.dictionary.size(); i++) {
            String check = manage.dictionary.get(i).word_target;
            if (check.equals(find)) {
                System.out.println(manage.dictionary.get(i).word_explain);
            }
        }
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("E:\\Dictionary\\src\\dictionary.txt")));
            while (sc.hasNext()) {
                String EL = sc.nextLine();
                String VN = sc.nextLine();
                Word new_word = new Word(EL, VN);
                manage.dictionary.add(new_word);
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}