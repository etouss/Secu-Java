package securiteL3;

/**
 * Created by ByTeK on 02/03/15.
 */
public class DecryptVigenere extends Decrypto {

    private String code;
    private int size;

    public DecryptVigenere(int size){
        this.size = size;
    }
    
    public String decryptFrequenceNo(){
      Dawg dwg = null;
      try {
          dwg = new Dawg();
      } catch (Exception e) {
            e.printStackTrace();
      }
      do{
        this.size ++;
        String key = decryptFrequence();
        try {
                Vigenere vig = new Vigenere(key);
                int i = 0;
                for(String w1 : code.split("\n")) {
                    for (String w : w1.split(" ")) {
                        String decode = vig.dechiffrerString(w);
                        if (!dwg.searchForStringB(decode)) throw new DecryptExecption(decode);
                        else i+=decode.length()+1;
                        if(i >= code.length()/15) return key;
                    }
                }
            }catch (DecryptExecption e){
            }
 
      }while(this.size < code.length()/10);
      System.err.println("Decrypt Vignere impossible Key trop grande !");
      return "a";
    }

    public String decryptFrequence(){
        int i = 0;
        int[][] subCode = new int[size][];
        for(int i1 = 0;i1<size;i1++)
            subCode[i1] = new int[26];
        for(char c : code.toCharArray()){
            if(c == ' ' || c == '\n')continue;
            subCode[i%size][c-97]++;
            i++;
        }
        StringBuilder res = new StringBuilder();
        for(int i1 = 0;i1<size;i1++)
            res.append(getMax(subCode[i1]));
        return res.toString();
    }

    public char getMax(int[] f){
        int max = 0;
        int e = 0;
        for(int i = 0; i<26;i++){
            if(f[i]>max){
                max = f[i];
                e = i;
            }
        }
        return (char) ((((e-4)+26)%26)+97);
    }

    @Override
    public void decrypt(String code) throws DecryptExecption {
        this.code = code;
        if(size != 0){
          this.name = "Decrypt Vignere Known Size";
          new Vigenere(decryptFrequence()).dechiffrer(code);
        }
        else{
          this.name = "Decrypt Vignere Unknown Size";
          new Vigenere(decryptFrequenceNo()).dechiffrer(code);
        }
    }
}
