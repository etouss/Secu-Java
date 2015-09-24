package securiteL3;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Created by ByTeK on 12/03/15.
 */
public class chiffre {

  static Crypto crypto;

  public static void main(String[] args) {
    //long time = System.currentTimeMillis();
    try{
      if(args.length != 3){
        System.err.println("3 arguments attendu");
        System.exit(1);
      }
      if(args[0].length() != 1){
        System.err.println("<c,p,v> attendu");
        System.exit(1);
      }
      switch(args[0].charAt(0)){
        case 'c':
          crypto = new Cesar(Integer.parseInt(args[1]));
          break;
        case 'v':
          crypto = new Vigenere(args[1]);
          //vignere
          break;
        case 'p':
          crypto = new Permutation(args[1]);
          //permutation
          break;
        default:
          System.err.println("Bad Format 2 !!");
          System.exit(1);
      }
      String code = new String(Files.readAllBytes(Paths.get(args[2])), StandardCharsets.UTF_8);
      crypto.chiffrer(code);
    } catch (Exception e) {
      System.err.println("Probleme d'ouverture de fichier");
      e.printStackTrace();
    }
    //System.err.println(System.currentTimeMillis()-time);

  }
}
