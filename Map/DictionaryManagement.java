import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary manage = new Dictionary();

    public void dictionaryLookup(String find) {
        String VN = manage.dictionary.get(find);
        System.out.println(VN);
    }

    public void insertFromFile() throws FileNotFoundException {
        Scanner sc = null;
        String VN = null;
        String EL = null;
        int d = 0;
        try {
            sc = new Scanner(new BufferedReader(new FileReader("E:\\Dictionary\\src\\demo.txt")));
            while (sc.hasNext()) {
                String in = sc.next();
                if (in.charAt(0) == '@' && EL == null) {
                    EL = in.substring(1);
                }
                else if (in.charAt(0) == '@' && EL != null) {
                    //Word new_word = new Word(EL, VN);
                    manage.dictionary.put(EL,VN);
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
        //Word new_word = new Word(EL, VN);
        manage.dictionary.put(EL,VN);
    }
}