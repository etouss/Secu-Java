package securiteL3;

/**
 * Created by ByTeK on 20/03/15.
 */
public class DecryptExecption extends Exception {
    public String error;
    public DecryptExecption(String error){
        super();
        this.error = error;
    }
}
