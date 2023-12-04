package N_2022.April;

import java.util.List;
import java.util.Scanner;

public class boj_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int min = B + C;
        int h = 0;
        if (min >= 60) {
            h = min / 60;
            B = min % 60;
        } else {
            B = B + C;
        }
        int hour = A + h;
        if (hour >= 24) {
            hour = hour % 24;
        }
        System.out.println(hour + " " + B);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
