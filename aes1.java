import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.util.Scanner;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
public class aes1{
    public static void main(String[] args) throws Exception {
               Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plain Text : ");
        String plainText = sc.nextLine();
        SecretKey secKey = getSecretEncryptionKey();
        byte[] cipherText = encryptText(plainText, secKey);
        String decryptedText = decryptText(cipherText, secKey);
                 System.out.println("Original Text:" + plainText);
        System.out.println("AES Key (Hex Form):"+bytesToHex(secKey.getEncoded()));
        System.out.println("Encrypted Text (Hex Form):"+bytesToHex(cipherText));
        System.out.println("Decrypted Text:"+decryptedText);
             }
     public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }
     public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }
      public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
        private static String  bytesToHex(byte[] hash) {
         return DatatypeConverter.printHexBinary(hash);
    }
}
