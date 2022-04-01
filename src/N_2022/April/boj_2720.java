package N_2022.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2720 {

    static int[] coin = new int[]{25, 10, 5, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            for (int j = 0; j < 4; j++) {
                if (a >= coin[j]) {
                    result.add(a / coin[j]);
                    a %= coin[j];
                } else {
                    result.add(0);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (i % 4 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(result.get(i) + " ");


        }
    }
}
