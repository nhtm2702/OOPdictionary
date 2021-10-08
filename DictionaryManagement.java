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
        String VN = null;
        String EL = null;
        int d = 0;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("E:\\Dictionary\\src\\dictionary109K.txt")));
            while (sc.hasNext()) {
                String in = sc.next();
                if (in.charAt(0) == '@' && EL == null) {
                    EL = in.substring(1);
                }
                else if (in.charAt(0) == '@' && EL != null) {
                    Word new_word = new Word(EL, VN);
                    manage.dictionary.add(new_word);
                    EL = in.substring(1);
                    d = 0;
                }
                else if (in.charAt(0) == '/') {
                    VN = in;
                    d = 1;
                }
                else {
                    if (in.charAt(0) == '*') VN += '\n' + in + " ";
                    else if (in.charAt(0) == '-' || in.charAt(0) == '=')
                    {
                        if (d == 0) EL += ' ' + in;
                        else VN += '\n' + in;
                    }
                    else if (d == 0) EL += " " + in;
                    else VN += " " + in;
                }
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        Word new_word = new Word(EL, VN);
        manage.dictionary.add(new_word);
    }
}