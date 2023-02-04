
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Integer[][] arrA = new Integer[N][M];
        Integer[][] arrB = new Integer[N][M];
        Integer[][] arrC = new Integer[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrC[i][j] = arrA[i][j] + arrB[i][j];
                System.out.print(arrC[i][j] + " ");
            }
            System.out.println();
        }


    }
}
