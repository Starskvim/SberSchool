package Task9.Cryptor;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;

public class XorCryptor {

    public static String xor_encrypt(String message, String key) {

        try {
            if (message == null || key == null) return null;
            char[] newmsg = new char[message.length()];
            for (int i = 0; i < message.length(); i++) {
                newmsg[i] = (char) (message.charAt(i) ^ key.charAt(i % key.length()));
            }
            Base64 base64 = new Base64();
            byte[] bytes = base64.encode(new String(newmsg).getBytes());
            return new String(bytes);
        } catch (Exception e) {
            return null;
        }
    }


    public static String xor_decrypt(String message, String key){

        try {

            if (message==null || key==null ) return null;

            Base64 decoder = new Base64();

//            BASE64Decoder decoder = new BASE64Decoder();

            message = new String(decoder.decode(message));
            char[] newmsg=new char[message.length()];

            for (int i=0; i<message.length(); i++){
                newmsg[i]=(char)(message.charAt(i)^key.charAt(i%key.length()));
            }

            return new String(newmsg);
        }
        catch (Exception e ) {
            return null;
        }
    }
}
