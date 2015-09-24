/**
 * Created by ByTeK on 01/03/15.
 */
public abstract class  Crypto {

    protected abstract char chiffrer(char c);

    public String chiffrerString(String s) {
        String chiffrer = new String();
        for(int i = 0; i<s.length();i++){
            chiffrer += chiffrer(s.charAt(i));
        }
        return chiffrer;
    }
    public void chiffrer(String s) {
        for(int i = 0; i<s.length();i++){
            System.out.print(chiffrer(s.charAt(i)));
        }
    }
    protected abstract char dechiffrer(char c);
    public String dechiffrerString(String s) {
        String dechiffrer = new String();
        for(int i = 0; i<s.length(); i++) {
            dechiffrer += dechiffrer(s.charAt(i));
        }
        return dechiffrer;
    }
    public void dechiffrer(String s) {
        for(int i = 0; i<s.length(); i++) {
            System.out.print(dechiffrer(s.charAt(i)));
        }
    }

    /*public void dechiffrerCheck(String s,Dawg dawg) throws Exception{
        String word = new String();
        for(int i = 0; i<s.length(); i++) {
            char c = dechiffrer(s.charAt(i));
            if(c == ' '){
                if(word.length()>0 && !dawg.searchForStringB(word))
                    throw new Exception();
                System.out.print(word+c);
                word = "";
            }
            else
                word += c;
        }
    }*/
    /*
    public void chiffrerCheck(String s,Dawg dawg) throws Exception{
        String word = new String();
        for(int i = 0; i<s.length(); i++) {
            char c = chiffrer(s.charAt(i));
            if(c == ' '){
                if(word.length()>0 && !dawg.searchForStringB(word)){
                    System.out.println(word);
                    throw new Exception();
                }

                System.out.print(word+c);
                word = "";
            }
            else
                word += c;
        }
    }*/

    public void check(char c){
        if(c == ' ' || c == '\n')
            return ;
        //System.out.println(val);
        if(c < 96 || c > 123){
            System.err.println("Seul les minuscules sont autorisé");
            System.exit(1);
        }
        assert c > 96 : "lettre "+c+" de [a-z]";
        assert c < 123 : "lettre "+c+" de [a-z]";
    }

}
