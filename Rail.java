import java.util.*;
public class Rail {
    int numRails;
    public Rail(int numRails) {
        this.numRails = numRails;
    }
    String gtDecryptData(String data) {
        char[] Decrypt = new char[data.length()];
        int n = 0;
        for(int k = 0 ; k < numRails; k ++) {
            int index = k;
            boolean down = true;
            while(index < data.length() ) {
                Decrypt[index] = data.charAt(n++);
                if(k == 0 || k == numRails - 1) {
                    index = index + 2 * (numRails - 1);
                }
                else if(down) {
                    index = index +  2 * (numRails - k - 1);
                    down = !down;
                }
                else {
                    index = index + 2 * k;
                    down = !down;
                }
            }
        }
        return new String(Decrypt);
    }
    String gtEncryptdata(String data) {
        char[] encrypt = new char[data.length()];
        int n = 0;
        for(int k = 0 ; k < numRails; k ++) {
            int index = k;
            boolean down = true;
            while(index < data.length() ) {
                encrypt[n++] = data.charAt(index);
                if(k == 0 || k == numRails - 1) {
                    index = index + 2 * (numRails - 1);
                }
                else if(down) {
                    index = index +  2 * (numRails - k - 1);
                    down = !down;
                }
                else {
                    index = index + 2 * k;
                    down = !down;
                }
            }
        }
        return new String(encrypt);
    }
    String gtEncryptdata2(String data) {
        int len = data.length();
        StringBuffer[] sb = new StringBuffer[numRails];
        for (int i = 0; i < numRails; i++) {
            sb[i] = new StringBuffer();
        }
        int index = 0;
        int direction = 1;
        for (int i = 0; i < data.length(); i++) {
            sb[index].append(data.charAt(i));
            index = index + direction;
            if (index == 0) {
                direction = 1;
            } else if (index == numRails) {
                if(index == 2) {
                    index = 0;
                }else {
                    direction = -1;
                    index = numRails -2;                    
                }}        }
        for (int i = 1; i < numRails; i++) {
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();
    }
    public static void main(String[] args) {
        System.out.println("Enter Plain Text:");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        Rail railFenceCipher = new Rail(5);
        String encrypt =railFenceCipher.gtEncryptdata(data);
        System.out.println("Encrypted Text:");
        System.out.println(encrypt);
        System.out.println("Decrypted Text:");
        String Decrypt = railFenceCipher.gtDecryptData(encrypt);
        System.out.println(Decrypt);
    }}
