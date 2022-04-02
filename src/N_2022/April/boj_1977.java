package N_2022.April;

import java.util.Scanner;

public class boj_1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int result = 0;
        int first = 0;


        for (int i = 1; i < 1000; i++) {
            if (M <= i * i && N >= i * i) {
                if (first == 0) {
                    first = i * i;
                }
                result += i * i;
            } else if (N < i * i){
                break;
            }
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            System.out.println(first);
        }

    }
}
