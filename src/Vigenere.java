
/**
 * Created by ByTeK on 01/03/15.
 */
public class Vigenere extends Crypto {
    String key;
    int indice = 0;

    public Vigenere(String key){
        for(int i = 0; i<key.length();i++) {
            if(key.charAt(i) == ' '){
                System.err.println("Les espace ne sont pas autorisé dans la clé");
                System.exit(1);
            }
            check(key.charAt(i));
        }
        this.key=key;
    }

    public void razIndice(){
        indice = 0;
    }

    private void incrementeIndice(){
        indice ++;
        if(indice == key.length()) indice = 0;
    }

    @Override
    protected char chiffrer(char c) {
        check(c);
        if(c == ' ' || c == '\n')
            return c;
        Character res = Character.toChars((c - 97 + (key.charAt(indice)- 97))% 26 + 97)[0];
        incrementeIndice();
        return res;
    }

    @Override
    protected char dechiffrer(char c) {
        check(c);
        if(c == ' ' || c == '\n')
            return c;
        Character res = Character.toChars((c - 97 - (key.charAt(indice)- 97)+26)%26 + 97)[0];
        incrementeIndice();
        return res;
    }
}
