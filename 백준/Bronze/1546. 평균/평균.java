


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        float arr[] = new float[cnt];
        float max = 0;
        float sum = 0;
        for(int i=0; i<cnt; i++){
            arr[i] = sc.nextInt();
            if(arr[i]>max){
                max = arr[i];
            }

        }
        for(int i=0; i<cnt; i++){
            arr[i]=((arr[i]/max)*100);
            sum += arr[i];
        }
        System.out.println(sum/cnt);





    }

}

