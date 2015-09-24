
/**
 * Created by ByTeK on 01/03/15.
 */
public class Cesar extends Crypto {

    int distance;

    public Cesar(int distance){
        if(distance > 25 || distance < 0){
            System.err.println("La valeur de decalage est incorrect");
            System.exit(1);
        }
        this.distance = distance;
    }

    @Override
    protected char chiffrer(char c) {
        check(c);
        if(c == ' ' || c == '\n')
            return c;
        return (char)(((c - 97 + distance)%26) + 97);
    }

    @Override
    protected char dechiffrer(char c) {
        check(c);
        if(c == ' ' || c == '\n')
            return c;
        return (char)(((c - 97 - distance + 26)%26) + 97);
    }
}
