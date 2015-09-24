package securiteL3;
/**
 * Created by ByTeK on 09/03/15.
 */
import java.util.HashSet;

public class DecryptPerm extends Decrypto {

  private String code;
  private MyHash[] hashChar;
  private char[] perm;
  //static int test = 0;
  private int nb = 0;
  private int nbPrev = 0;
  private HashSet<Character> unmap;
  //private long time;


  public DecryptPerm(){
    this.name = "Decrypt Permutation";
    //this.time = System.currentTimeMillis();
    //this.code = code.replace("\n"," ");
    perm = new char[26];
    hashChar = new MyHash[26];
    unmap = new HashSet<Character>();
    for(int i = 0; i<26;i++){
      unmap.add((char)(i+97));
      perm[i] = '?';
      hashChar[i] = new MyHash();
      for (int j = 0; j < 26; j++)
        hashChar[i].add((char) (j + 97));

    }

  }

  public String decryptString(boolean bool) throws DecryptExecption{
    Dawg dawg = null;
    try {
      dawg = new Dawg();
    } catch (Exception e) {
      e.printStackTrace();
    }
    //le e pour bosser
    char e = getE();
    hashChar[e-97] = new MyHash();
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
        for (int i = 3;i>=0  ;i--){
          for (String word1 : code.split("\n")) {
            for(String word : word1.split(" "))
              updateSet(word,dawg,i);
          }
        }
      }
      catch (DecryptExecption ex){
        if(ex.error.equals("Over"))
          throw new DecryptExecption("Decrypt Frequence Incomplet !");
      }
    }while(nb != nbPrev);
    //if(nb != 26 && bool) throw new DecryptExecption("Decrypt Frequence Incomplet !");
    StringBuilder key = new StringBuilder();
    for(char c : perm) {
      if(c == '?'){
        for(char u : unmap){
          key.append(u);
          unmap.remove(u);
          break;
        }
      }
      else key.append(c);
    }
    System.err.println(key.toString());
    return key.toString();
    //System.out.println(key);
    //new Permutation(key).chiffrer(code);
    //System.out.println("TIME ==== "+(System.currentTimeMillis()-time));

  }
 public String createPattern(String word){
   for(int i = 0; i<word.length();i++){
     for(int j = i+1;j<word.length();j++){
     }
   }
   return null;
 }

//NEW FONCTION NON PRESENTE AVANT
  public boolean isPossible(String word, String get){
    for(int i = 0; i<word.length();i++){
      for(int j = i+1;j<word.length();j++){
        if(word.charAt(i) == word.charAt(j) && get.charAt(i) != get.charAt(j))return false;
      }
    }
    return true;
  }

  public void updateSet(String word,Dawg dawg,int bool) throws DecryptExecption{
    // Patern
    //if(word.equals(""))return;
    StringBuilder pattern = new StringBuilder();
    int nb = 0;
    for(int i = 0; i<word.length();i++){
      if(perm[(int) word.charAt(i) -97] != '?')nb ++;
      pattern.append(perm[(int) word.charAt(i) -97]);
    }
    if((nb >= bool || word.length() == 1) && nb != word.length() ) {
      String[] tab =  dawg.searchForPatternB(pattern.toString());
      for (int i = 0; i < pattern.length(); i++) {
        if (pattern.charAt(i) == '?') {
          HashSet<Character> h = new HashSet<Character>();
          for (String st : tab) {
            if(st.equals("")) throw new DecryptExecption("Over");
            if(isPossible(word,st))h.add(st.charAt(i));
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
  public void decrypt(String code) throws DecryptExecption {
    this.code = code;
    //System.out.println(decryptString());
    new Permutation(decryptString(false)).chiffrer(code);
  }
  public void decrypt2(String code) throws DecryptExecption {
    this.code = code;
    //System.out.println(decryptString());
    new Permutation(decryptString(true)).chiffrer(code);
  }


}
