import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * Thanks to emmby at http://stackoverflow.com/questions/785973/what-is-the-most-appropriate-way-to-store-user-settings-in-android-application/6393502#6393502
 * <p/>
 * Documentation: http://right-handed-monkey.blogspot.com/2014/04/obscured-shared-preferences-for-android.html
 * This class has the following additions over the original:
 * additional logic for handling the case for when the preferences were not originally encrypted, but now are.
 * The secret key is no longer hard coded, but defined at runtime based on the individual device.
 * The benefit is that if one device is compromised, it now only affects that device.
 * <p/>
 * Simply replace your own SharedPreferences object in this one, and any data you read/write will be automatically encrypted and decrypted.
 * <p/>
 * Updated usage:
 * ObscuredSharedPreferences prefs = ObscuredSharedPreferences.getPrefs(this, MY_APP_NAME, Context.MODE_PRIVATE);
 * //to get data
 * prefs.getString("foo", null);
 * //to store data
 * prefs.edit().putString("foo","bar").commit();
 */
public class ObscuredSharedPreferences{
    protected static final String UTF8 = "UTF-8";
    private static final String TAG = ObscuredSharedPreferences.class.getName();
    //this key is defined at runtime based on ANDROID_ID which is supposed to last the life of the device
    private static char[] SEKRIT = "WVE4Ykm3oZzJLfLO".toCharArray();
    private static byte[] SALT = null;

    private static char[] backup_secret = null;
    private static byte[] backup_salt = null;

    

    //Set to true if a decryption error was detected
    //in the case of float, int, and long we can tell if there was a parse error
    //this does not detect an error in strings or boolean - that requires more sophisticated checks
    public static boolean decryptionErrorFlag = false;
    private static String KEY = "PBEWithMD5AndDES";
    
    public static void main(String[] args) {
		System.out.println("TeubtlzU5TM=");
		System.out.println(decrypt("TeubtlzU5TM="));
	}

   /* private String encrypt(String value) {
        if (value != null) {
            try {
                Cipher pbeCipher = Cipher.getInstance(KEY);
                pbeCipher.init(Cipher.ENCRYPT_MODE, SecretKeyFactory.getInstance(KEY).generateSecret(new PBEKeySpec(SEKRIT)), new PBEParameterSpec(SALT, 20));
                return new String(Base64Support.encode(pbeCipher.doFinal(value.getBytes(UTF8)), Base64Support.NO_WRAP), UTF8);
            } catch (Exception e) {
                Crashlytics.log(Log.DEBUG, TAG, "encrypt values : " + value);
                Crashlytics.logException(e);
                e.printStackTrace();
            }
        }
        return value;
    }*/

    private static String decrypt(String value) {
        System.out.println(value+"");
        if (value != null) {
            try {
                Cipher pbeCipher = Cipher.getInstance(KEY);
                pbeCipher.init(Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance(KEY).generateSecret(new PBEKeySpec(SEKRIT)), new PBEParameterSpec(SALT, 20));
                return new String(pbeCipher.doFinal(java.util.Base64.getDecoder().decode(value)), UTF8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}