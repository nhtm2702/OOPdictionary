package String;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        Scanner sc = new Scanner(new BufferedReader(new FileReader("E:\\Dictionary\\src\\dictionary109K.txt")));
        String in = sc.nextLine();
        String EL , VN;
        int d = in.indexOf("/");
        if (d > 1){
            EL = in.substring(1,d-1);
            VN = in.substring(d,in.length());
        }
        else {
            EL = in.substring(1);
            VN = "";
        }
        while (sc.hasNext()) {
            in = sc.nextLine();
            if (in.length() >= 1) {
                if (in.charAt(0) == '@') {
                    Word word = new Word(EL, VN);
                    manage.dictionary.add(word);
                    d = in.indexOf("/");
                    if (d > 1){
                        EL = in.substring(1,d-1);
                        VN = in.substring(d,in.length());
                    }
                    else {
                        EL = in.substring(1);
                        VN = "";
                    }
                } else if (VN.equals("")) VN += in;
                else if (!VN.equals("")) VN += '\n' + in;
            }
        }
        Word word = new Word(EL, VN);
        manage.dictionary.add(word);
    }
}