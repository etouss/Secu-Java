
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ByTeK on 01/03/15.
 */
public class DecryptCesar implements Decrypto{

    //int distance;
    String code;
    String methode;


    public DecryptCesar(String methode){
        this.methode = methode;
    }

    public int decryptWithWord(String word) throws DecryptExecption{
        Dawg dawg = null;
        try {
            dawg = new Dawg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // PEUT être un probleme
        for(String w : code.split(" ")){
            if(w.length() != word.length())continue;
                //System.err.println(w);
                String w1 = new Cesar((w.charAt(0)-word.charAt(0)+26)%26).dechiffrerString(w);
                if(dawg.searchForStringB(w1)) return (w.charAt(0)-word.charAt(0)+26)%26;
        }
        throw new DecryptExecption("Word not Find !");
    }

    public int decryptBruteForce() throws DecryptExecption{
        //long time = System.currentTimeMillis();
        //System.out.println(dwg.searchForString("maison"));
        Dawg dwg = null;
        try {
            dwg = new Dawg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0;i<26;i++){
            Cesar ces = new Cesar(i);
            try {
                for(String w1 : code.split("\n")) {
                    for (String w : w1.split(" ")) {
                        String decode = ces.dechiffrerString(w);
                        //System.out.println("||||" + decode + "|||");
                        if (!dwg.searchForStringB(decode)) throw new DecryptExecption(decode);
                    }
                }
                //System.out.println(System.currentTimeMillis()-time);
                return i;
            }catch (DecryptExecption e){
                //System.out.println(i+":::"+e.error);
                //System.out.println(System.currentTimeMillis()-time);
            }
        }
        throw new DecryptExecption("BruteForce Echec");
    }


    public int decryptFrequence() {
        int freqCode[] = new int[26];
        for(int i = 0; i<26; i++)
            freqCode[i]=0;
        for(int i=0;i<code.length();i++){
            char courant = code.charAt(i);
            if(courant == ' ' || courant == '\n')continue;
            freqCode[courant-97] += 1;
        }
        int max = 0;
        char e = 0;
        for(int i = 0;i<26;i++){
            if(freqCode[i]>max){
                max = freqCode[i];
                e = (char)(97+i);
            }
        }
        int dec = (e-101)%26;
        if(dec<0) dec += 26;
        return dec;
    }

    @Override
    public void decrypt(String code) throws DecryptExecption{
        this.code = code;
        switch(methode){
            case "#":
                new Cesar(decryptFrequence()).dechiffrer(code);
                break;
            case "?":
                new Cesar(decryptBruteForce()).dechiffrer(code);
                break;
            default:
                new Cesar(decryptWithWord(methode)).dechiffrer(code);
                break;

        }
    }

    public void setCode(String code){
        this.code = code;
    }
}
