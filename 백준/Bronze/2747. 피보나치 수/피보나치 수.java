import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        System.out.println(fi(n));


    }
    public static int fi(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else if(arr[n] != 0){
            return arr[n];
        }
        else{
            arr[n] = fi(n-1) + fi(n-2);
            return arr[n];
        }
    }
}
