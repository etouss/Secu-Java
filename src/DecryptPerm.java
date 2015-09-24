/**
 * Created by ByTeK on 09/03/15.
 */
import java.util.HashSet;

public class DecryptPerm implements Decrypto{

    private String code;
    private HashSet<Character>[] hashChar;
    private char[] perm;
    //static int test = 0;
    private int nb = 0;
    private int nbPrev = 0;
    private HashSet<Character> unmap;
    //private long time;


    public DecryptPerm(){
        //this.time = System.currentTimeMillis();
        //this.code = code.replace("\n"," ");
        perm = new char[26];
        hashChar = new HashSet[26];
        unmap = new HashSet<Character>();
        for(int i = 0; i<26;i++){
            unmap.add((char)(i+97));
            perm[i] = '?';
            hashChar[i] = new HashSet<Character>();
            for (int j = 0; j < 26; j++)
                hashChar[i].add((char) (j + 97));

        }

    }

    public String decryptString(){
        Dawg dawg = null;
        try {
            dawg = new Dawg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //le e pour bosser
        char e = getE();
        hashChar[e-97] = new HashSet<>();
        hashChar[e-97].add('e');
        do {
            nbPrev = nb;
            boolean redo = true;
            while (redo) {
                redo = false;
                //verifions si il y en a set : des tableau a 1 element.
                for (int i = 0; i < 26; i++) {
                    //il y en a un ?.
                    if (hashChar[i] != null && hashChar[i].size() == 1) {
                        redo = true;
                        nb++;
                        //Set la perm
                        for (char c : hashChar[i]) {
                            perm[i] = c;
                        }
                        hashChar[i] = null;
                        unmap.remove(perm[i]);
                        //remove de tout les autre hashset.
                        for (HashSet<Character> h : hashChar)
                            if (h != null) h.remove(perm[i]);
                    }
                }
            }
            try{
                for (String word1 : code.split("\n")) {
                    for(String word : word1.split(" "))
                        updateSet(word,dawg,false);
                }
                for (String word1 : code.split("\n")) {
                    for(String word : word1.split(" "))
                        updateSet(word,dawg,true);
                }
            }
            catch (DecryptExecption ex){
                    //ex.printStackTrace();
                   //≤System.out.println(nb);
            }
        }while(nb != nbPrev);
        String key = new String();
        for(char c : perm) {
            if(c == '?'){
                for(char u : unmap){
                    key += u;
                    unmap.remove(u);
                    break;
                }
            }
            else key += c;
        }
        return key;
        //System.out.println(key);
        //new Permutation(key).chiffrer(code);
        //System.out.println("TIME ==== "+(System.currentTimeMillis()-time));

    }

    public void updateSet(String word,Dawg dawg,boolean bool) throws DecryptExecption{
        // Patern
        //if(word.equals(""))return;
        String pattern = new String();
        int nb = 0;
        for(int i = 0; i<word.length();i++){
            if(perm[(int) word.charAt(i) -97] != '?')nb ++;
            pattern += perm[(int) word.charAt(i) -97];
        }
        if(nb > 2 || bool) {
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '?') {
                    HashSet<Character> h = new HashSet<Character>();
                    for (String st : dawg.searchForPatternB(pattern)) {
                        h.add(st.charAt(i));
                    }
                    hashChar[word.charAt(i) - 97].retainAll(h);
                    if (hashChar[word.charAt(i) - 97].size() == 1) throw new DecryptExecption(word);
                }
            }
        }
    }


    public char getE(){
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
        return e;
    }

    @Override
    public void decrypt(String code) throws DecryptExecption{
        this.code = code;
        //System.out.println(decryptString());
        new Permutation(decryptString()).chiffrer(code);
    }
}
