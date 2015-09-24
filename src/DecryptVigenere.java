
import java.util.ArrayList;

/**
 * Created by ByTeK on 02/03/15.
 */
public class DecryptVigenere implements Decrypto{

    private String code;
    private int size;

    public DecryptVigenere(int size){
        this.size = size;
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
        String res = new String();
        for(int i1 = 0;i1<size;i1++)
            res+= getMax(subCode[i1]);
        //System.err.println(res);
        return res;
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
    public void decrypt(String code) throws DecryptExecption{
        this.code = code;
        new Vigenere(decryptFrequence()).dechiffrer(code);
    }
}
