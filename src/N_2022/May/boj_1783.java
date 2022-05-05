// 문제풀이 생각안나서 답지봄
// 이걸 어캐 생각하지

package N_2022.May;

import java.util.Scanner;

public class boj_1783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;

        if (N == 1) {
            count = 1;
        } else if (N == 2) {
            count = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                count = Math.min(4, M);
            } else {
                count = M - 2;
            }
        }
        System.out.println(count);
    }
}
