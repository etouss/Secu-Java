package securiteL3;

/**
 * Created by ByTeK on 01/03/15.
 */
public class DecryptCesar extends Decrypto {

    //int distance;
    String code;
    String methode;


    public DecryptCesar(String methode){
        this.methode = methode;
    }

    public int decryptWithWord(String word) throws DecryptExecption {
        Dawg dawg = null;
        try {
            dawg = new Dawg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // PEUT être un probleme
        for(String w2 : code.split("\n")){
            for(String w : w2.split(" ")){
            if(w.length() != word.length())continue;
                //System.err.println(w);
                String w1 = new Cesar((w.charAt(0)-word.charAt(0)+26)%26).dechiffrerString(w);
                if(dawg.searchForStringB(w1)) return (w.charAt(0)-word.charAt(0)+26)%26;
            }
        }
        throw new DecryptExecption("Word not Find !");
    }

    public int decryptBruteForce() throws DecryptExecption {
        //long time = System.currentTimeMillis();
        //System.out.println(dwg.searchForString("maison"));
        //On autorise 5% d'erreur !!!
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
                    int nb_erreur = 0;    
                    String [] words = w1.split(" ");
                    for (String w : words) {
                        String decode = ces.dechiffrerString(w);
                        //System.out.println("||||" + decode + "|||");
                        if (!dwg.searchForStringB(decode)){
                          nb_erreur ++;
                          if(nb_erreur > words.length/20)
                            throw new DecryptExecption(decode);
                        }
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
        for(char c : code.toCharArray()){
            if(c == ' ' || c == '\n')continue;
            freqCode[c-97]++;
        }
        int max = 0;
        int e = 0;
        for(int i = 0;i<26;i++){
            if(freqCode[i]>max){
                max = freqCode[i];
                e = i;
            }
        }
        return ((e-4)+26)%26;
    }

    @Override
    public void decrypt(String code) throws DecryptExecption {
        this.code = code;
        switch(methode.charAt(0)){
            case '#':
                this.name = "Decrypt Cesar Frequence";
                new Cesar(decryptFrequence()).dechiffrer(code);
                break;
            case '?':
                 this.name = "Decrypt Cesar Brute Force";
                new Cesar(decryptBruteForce()).dechiffrer(code);
                break;
            default:
                this.name = "Decrypt Cesar With Word";
                new Cesar(decryptWithWord(methode)).dechiffrer(code);
                break;

        }
    }

    public void setCode(String code){
        this.code = code;
    }
}
