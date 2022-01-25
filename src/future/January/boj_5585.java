package future.January;

import java.util.Scanner;

public class boj_5585 {
    public static void main(String[] args) {
        int[] candidate = {500, 100, 50, 10, 5, 1};
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int answer = 1000 - a;

        int count = 0;

        for (int i = 0; i < candidate.length; i++) {
            if (answer - candidate[i] >= 0) {
                int temp = answer / candidate[i];
                answer -= candidate[i] * temp;
                count += temp;
            }
        }

        System.out.println(count);
    }



}
