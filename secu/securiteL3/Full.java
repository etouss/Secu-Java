
package securiteL3; /**
 * Created by ByTeK on 09/03/15.
 */
import java.util.HashSet;

public class Full extends Decrypto {

    public Full(){
    }
 
    @Override
    public void decrypt(String code) throws DecryptExecption {
        this.name = "Decrypt full unknown";
        try{
        new DecryptPerm().decrypt2(code);
        }
        catch(DecryptExecption e){
          System.err.println(e.error);
          new DecryptVigenere(0).decrypt(code);
        }
    }
}
