package bankingapp.crypto;

import java.io.*;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class DesEncrypter {

    Cipher ecipher;
    Cipher dcipher;

    // 8-byte Salt
    byte[] salt = {
        (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
        (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
    };

    // Iteration count
    int iterationCount = 19;

    public DesEncrypter() {
        try {
            // Create the key
            String passPhrase = "Hello  World Javaa";
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance(
                    "PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // Prepare the parameter to the ciphers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            // Create the ciphers
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (java.security.InvalidAlgorithmParameterException e) {
        } catch (java.security.spec.InvalidKeySpecException e) {
        } catch (javax.crypto.NoSuchPaddingException e) {
        } catch (java.security.NoSuchAlgorithmException e) {
        } catch (java.security.InvalidKeyException e) {
        }
    }

    public void encrypt(String ipPath, String opPath) {
        try {
            // Encode the string into bytes using utf-8


            // Encrypt
            FileInputStream fis;
            FileOutputStream fos;
            CipherOutputStream cos;

            fis = new FileInputStream(ipPath);
            fos = new FileOutputStream(opPath);
            cos = new CipherOutputStream(fos, ecipher);
            byte[] b = new byte[8];
            int i = fis.read(b);
            while (i != -1) {
                cos.write(b, 0, i);
                i = fis.read(b);
            }
            cos.flush();
            cos.close();
            fis.close();
            fos.close();
        //byte[] enc = ecipher.doFinal(utf8);

        // Encode bytes to base64 to get a string
        //return new sun.misc.BASE64Encoder().encode(enc);
        //return "p";

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    //return null;
    }

    public String decrypt(String ipPath, String opPath) {
        try {
            // Decode base64 to get bytes
            FileInputStream fis;
            FileOutputStream fos;
            CipherInputStream cos;

            fis = new FileInputStream(ipPath);
            fos = new FileOutputStream(opPath);
            cos = new CipherInputStream(fis, dcipher);
            byte[] b = new byte[8];
            int i = cos.read(b);
            while (i != -1) {
                fos.write(b, 0, i);
                i = cos.read(b);
            }
            fos.flush();
            fos.close();
            fis.close();
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        }
        return null;
    }

    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (javax.crypto.BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);

            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (javax.crypto.BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        }
        return null;
    }

    public static void main(String args[]) {
        // Here is an example that uses the class
        try {
            // Create encrypter/decrypter class
            DesEncrypter encrypter = new DesEncrypter();
            System.out.println(encrypter.decrypt("K/nWqWVuVLhPtI4uEwr5fg=="));
            // Encrypt
            //encrypter.encrypt("C:/Users/s/Desktop/pp/1282893020012.bak", "C:/Users/s/Desktop/pp/1282893020012.bake");

            // Decrypt
            //encrypter.decrypt("b.txt", "a.txt");
        } catch (Exception e) {
        }

    }
}
