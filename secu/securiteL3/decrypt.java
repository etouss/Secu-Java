package securiteL3;

/* import java.nio.charset.StandardCharsets; */
/* import java.nio.file.Files; */
/* import java.nio.file.Paths; */
import java.io.*;

/**
 * Created by ByTeK on 17/03/15.
 */
public class decrypt {

    private static Decrypto decrypto;

    public static void main(String[] args) {
        //long time = System.currentTimeMillis();
        try {
            if(args.length < 2){
                System.err.println("Mauvais format de commande");
                System.exit(1);
            }
            if(args[0].length() != 1){
                System.err.println("<c,p,v> attendu");
                System.exit(1);
            }
            switch(args[0].charAt(0)){
                case 'c':
                    switch(Integer.parseInt(args[2])){
                        case 1:
                            decrypto = new DecryptCesar(args[3]);
                            break;
                        case 2:
                            decrypto = new DecryptCesar("#");
                            break;
                        case 3:
                            decrypto = new DecryptCesar("?");
                            break;
                        default:
                            System.err.println("c <1,2,3> attendu");
                            System.exit(1);
                    }
                    break;
                case 'v':
                    decrypto = new DecryptVigenere(Integer.parseInt(args[2]));
                    break;
                case 'p':
                    decrypto = new DecryptPerm();
                    //crypto = new Permutation(args[1]);
                    //permutation
                    break;
                case 'f':
                    decrypto = new Full();
                    break;
                default:
                    System.err.println("<c,p,v> attendu");
                    System.exit(1);
            }
            long startTime = System.currentTimeMillis();
            /* String code = Files.readLines(new File(args[1]), Charsets.UTF_8); */
            /* String code = new String(Files.readAllBytes(Paths.get(args[1])), StandardCharsets.UTF_8);  */
            /* String code = new String(Files.readAllBytes( FileSystems.getDefault().getPath(".", args[1]))); */
            StringBuilder code = new StringBuilder();
            int read,N=1024*8;
            char [] buffer = new char[N];
            FileReader fr = new FileReader(args[1]);
            BufferedReader br = new BufferedReader(fr);
            while(true){
              read = br.read(buffer,0,N);
              code.append(buffer,0,read);
              if(read<N)break;
            }
            br.close();
            decrypto.decrypt(code.toString());
            long endTime = System.currentTimeMillis();
            System.err.println("Temps de "+decrypto.name+" :" + (endTime-startTime) + "ms");
        } catch (DecryptExecption e) {
            //System.err.println("Probleme d'ouverture de fichier");
            System.err.print(e.error);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        //System.err.println(System.currentTimeMillis()-time);

    }
}
