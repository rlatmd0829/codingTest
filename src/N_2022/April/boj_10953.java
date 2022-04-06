package N_2022.April;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String s = sc.next();
            String[] arr = s.split(",");
            int sum = 0;
            for (String value : arr) {
                sum += Integer.parseInt(value);
            }
            result.add(sum);
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
