import java.util.Scanner;
public class Caesar{
    public static final String lt = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt (String pt,int sk){
        pt=pt.toLowerCase();
        String ct="";
        for(int i=0;i<pt.length();i++){
            int map_set=lt.indexOf(pt.charAt(i));
            int encrypting_value=(sk+map_set)%26;
            char evalue=lt.charAt(encrypting_value);
            ct=ct+evalue;
        }
        return ct;
    }
    public static String decrypt (String ct,int sk){
        ct=ct.toLowerCase();
        String pt="";
        for(int i=0;i<ct.length();i++){
            int map_set=lt.indexOf(ct.charAt(i));
            int decrypting_value=(map_set-sk)%26;
            if(decrypting_value < 0){
                decrypting_value = lt.length()+decrypting_value;
            }
            char dvalue=lt.charAt(decrypting_value);
            pt=pt+dvalue;
         }
        return pt;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String message = new String();
        message=scan.next();
        System.out.println(encrypt(message,3));
        System.out.println(decrypt(encrypt(message,3),3));
        scan.close();
    }
   }
