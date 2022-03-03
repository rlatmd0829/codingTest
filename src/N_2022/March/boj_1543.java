package N_2022.March;

import java.util.Scanner;

public class boj_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int maxx = 0;

        for (int i = 0; i < s2.length(); i++) {
            int count = 0;
            for (int j = i; j < s1.length(); j++) {
                if (j + s2.length() > s1.length()) {
                    break;
                }
                if (s1.substring(j, j+s2.length()).equals(s2)) {
                    count++;
                    j+=s2.length()-1;
                }
            }
            if (maxx < count) {
                maxx = count;
            }
        }
        System.out.println(maxx);
    }
}
