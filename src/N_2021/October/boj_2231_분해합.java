package N_2021.October;

import java.util.Scanner;

public class boj_2231_분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if(re(i) == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);


    }
    public static int re(int i){
        int sum = i;
        while (i > 0){
            sum += i % 10;
            i = i / 10;
        }
        return sum;

    }
}
