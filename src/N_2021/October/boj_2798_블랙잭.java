package N_2021.October;
import java.util.Scanner;

public class boj_2798_블랙잭 {
    public static int N;
    public static int M;
    public static int[] nums = new int[100];
    public static int curMax = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        recursive(0, 0, 0);
        System.out.println(curMax);
    }

    public static void recursive(int i, int curCount, int curSum){
        if(N <= i){
            if(curCount != 3)
                return;

            if(curSum <= M){
                curMax = Math.max(curSum, curMax);
            }
            return;
        }

        if(curCount >= 3){
            recursive(i+1, curCount, curSum);
            return;
        }

        recursive(i+1, curCount+1, curSum+nums[i]);
        recursive(i+1, curCount, curSum);
    }
}