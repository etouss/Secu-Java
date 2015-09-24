package securiteL3;

import java.util.HashSet;

/**
 * Created by ByTeK on 01/03/15.
 */
public class Permutation extends Crypto {

    char[] permutationChiffrer;
    char[] permutationDeChiffrer;

    public Permutation(String perm){
        if(perm.length() != 26){
            System.err.println("La clé doit être bijective");
            System.exit(1);
        }
        HashSet <Character> check1 = new HashSet<Character>();
        permutationChiffrer = new char[26];
        permutationDeChiffrer = new char[26];
        for(int i = 0;i<perm.length();i+=1){
            if(perm.charAt(i) == ' '){
                System.err.println("La clé doit être bijective");
                System.exit(1);
            }
            check(perm.charAt(i));
            if(check1.contains(perm.charAt(i))){
                System.err.println("La clé doit être bijective");
                System.exit(1);
            }
            check1.add(perm.charAt(i));
            permutationChiffrer[i] = perm.charAt(i);
            permutationDeChiffrer[perm.charAt(i)-97] = (char)(97+i);
        }
    }

    @Override
    protected char chiffrer(char c) {
        check(c);
        if(c==' ' || c=='\n')return c;
        return permutationChiffrer[c-97];
    }


    @Override
    protected char dechiffrer(char c) {
        check(c);
        if(c==' ' || c=='\n')return c;
        return permutationDeChiffrer[c-97];
    }

}
