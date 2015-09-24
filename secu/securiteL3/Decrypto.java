package securiteL3;

/**
 * Created by ByTeK on 20/03/15.
 */
public abstract class Decrypto {
    public String name;
    public abstract void decrypt(String code) throws DecryptExecption;
}
