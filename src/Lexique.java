import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

/**
 * Created by ByTeK on 01/03/15.
 */
public abstract class Lexique {
    public static String removeAccent(String source) {
        return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
    }

    public static boolean inLexique(String word){
        long start = System.currentTimeMillis();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/ByTeK/Documents/ProjetL3/SECU/Etienne/lexique.txt"));
            while(br.ready())
                if(removeAccent(br.readLine().toLowerCase()).equals(word))return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return false;

    }

}
