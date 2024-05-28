import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] c = str.toCharArray();
        int [] arr = new int[26];
        for(int i=0; i<c.length; i++){
            arr[c[i]-'a']++;
        }
        for(int a : arr){
            System.out.print(a+" ");
        }



    }
}
