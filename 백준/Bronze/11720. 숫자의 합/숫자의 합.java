


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        int T = sc.nextInt();
        String str = sc.next();
        for(int i=0; i<T; i++){
            int x = str.charAt(i)-'0';
            sum += x;
        }
        System.out.println(sum);

    }
}

