package securiteL3;

/**
 * Created by ByTeK on 01/03/15.
 */
public abstract class  Crypto {

    protected abstract char chiffrer(char c);

    public String chiffrerString(String s) {
        StringBuilder chif = new StringBuilder();
        for(char c : s.toCharArray()){
           chif.append(chiffrer(c));
        }
        return chif.toString();
    }
    public void chiffrer(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
           res.append(chiffrer(c));
        }
        System.out.print(res);
    }
    protected abstract char dechiffrer(char c);
    public String dechiffrerString(String s) {
      StringBuilder dech = new StringBuilder();
        for(char c : s.toCharArray()) {
          dech.append(dechiffrer(c));
        }
        return dech.toString();
    }
    public void dechiffrer(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()) {
          res.append(dechiffrer(c));
        }

        System.out.print(res);
    }

    /* public void dechiffrerCheck(String s) throws Exception{ */
    /*   Dawg dawg = null; */
    /*   try{ */
    /*   dawg = new Dawg(); */
    /*   } */
    /*   catch(Exception e){} */
    /*     String word = new String(); */
    /*     for(int i = 0; i<s.length(); i++) { */
    /*         char c = dechiffrer(s.charAt(i)); */
    /*         if(c == ' '||c == '\n'){ */
    /*             if(word.length()>0 && !dawg.searchForStringB(word)){ */
    /*               System.err.println("|||"+word+"|||||"); */
    /*                 throw new Exception(); */
    /*             } */
    /*             System.out.print(word+c); */
    /*             word = ""; */
    /*         } */
    /*         else */
    /*             word += c; */
    /*     } */
    /* } */
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
            System.err.println("Seul les minuscules sont autorisé "+c+" !");
            System.exit(1);
        }
    }

}
