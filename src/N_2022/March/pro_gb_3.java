package N_2022.March;

import java.util.ArrayList;
import java.util.List;

public class pro_gb_3 {

    private static int count;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        solution(new int[]{1,1,2,2}, 2, 3);
        System.out.println(list.size());
    }

    private static int solution(int[] arr, int k, int t) {
        int answer = 0;

        boolean[] visited = new boolean[arr.length];

        comb(arr, visited, "", 0, 0, 0, k, t);

        return answer;
    }

    private static void comb(int[] arr, boolean[] visited, String temp, int depth, int n, int cnt, int k, int t) {
        if (cnt >= k) {
            if (n <= t) {
                print(arr, visited);
                if (!list.contains(temp)) {
                    list.add(temp);
                }
                count++;
            }
        }
        if (depth == arr.length) {
            return;
        }
        visited[depth] = true;
        comb(arr, visited, temp + arr[depth]+ depth, depth+1, n + arr[depth], cnt + 1, k, t);

        visited[depth] = false;
        comb(arr, visited, temp, depth+1, n, cnt, k, t);

    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
