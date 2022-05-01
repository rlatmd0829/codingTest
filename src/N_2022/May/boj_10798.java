package N_2022.May;


import java.util.Scanner;

public class boj_10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] result = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length; j++) {
                result[i][j] = c[j];
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (result[j][i] == '\0') {
                    continue;
                }
                System.out.print(result[j][i]);
            }
        }

    }
}
