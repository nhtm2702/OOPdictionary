
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary manage = new Dictionary();

    /*public void insertFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        String EL = sc.next();
        String VN = sc.next();
        Word new_word = new Word(EL, VN);
        manage.dictionary.add(new_word);
    }*/

    public void dictionaryLookup(String find) {
        for (int i = 0; i < manage.dictionary.size(); i++) {
            if (manage.dictionary.get(i).word_target.equals(find)) {
                System.out.println(find);
            }
        }
    }

    /*public void insertFromFile() {
        while (!StdIn.isEmpty()) {
            String EL = StdIn.readString();
            String VN = StdIn.readString();
            Word new_word = new Word(EL, VN);
            manage.dictionary.add(new_word);
        }
    }*/

    public void insertFromFile() throws FileNotFoundException {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("dictionary.txt")));
            while (sc.hasNext()) {
                String EL = sc.next();
                String VN = sc.next();
                Word new_word = new Word(EL, VN);
                manage.dictionary.add(new_word);
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }  //chưa thể nhập từ có dấu cách
}
