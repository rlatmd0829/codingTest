package N_2022.February;

import java.util.Scanner;

public class boj_2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();

        for (int i = 0; i < charA.length; i++) {
            if (charA[i] == '6') {
                charA[i] = '5';
            }
        }

        for (int i = 0; i < charB.length; i++) {
            if (charB[i] == '6') {
                charB[i] = '5';
            }
        }

        String tempA = String.valueOf(charA);
        String tempB = String.valueOf(charB);

        Integer inta = Integer.parseInt(tempA);
        Integer intb = Integer.parseInt(tempB);

        Integer minn = inta + intb;

        charA = A.toCharArray();
        charB = B.toCharArray();

        for (int i = 0; i < charA.length; i++) {
            if (charA[i] == '5') {
                charA[i] = '6';
            }
        }

        for (int i = 0; i < charB.length; i++) {
            if (charB[i] == '5') {
                charB[i] = '6';
            }
        }

        tempA = String.valueOf(charA);
        tempB = String.valueOf(charB);

        inta = Integer.parseInt(tempA);
        intb = Integer.parseInt(tempB);

        Integer maxx = inta + intb;

        System.out.println(minn+ " "+ maxx);

    }
}
