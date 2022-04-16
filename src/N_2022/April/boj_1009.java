package N_2022.April;

import java.util.Scanner;

public class boj_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int result = 1;
            for (int j = 0; j < b; j++) {
                result = (a * result) % 10;
            }

            if (result == 0){
                result = 10;
            }
            System.out.println(result);
        }

    }
}
