package N_2022.March;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pro_sk_1 {

    public static int[] coin = {1, 5, 10, 50, 100, 500};
    public static List<Integer> answer;

    public static void main(String[] args) {
        solution(4578, new int[]{1,4,99,35,50,1000});
    }

    public static void solution(int money, int[] costs) {

        answer = new ArrayList<>();

        boolean[] visited = new boolean[costs.length];

        comb(money, costs, visited, costs.length-1, 0);

        Collections.sort(answer);

        System.out.println(answer.get(0));
    }

    private static void comb(int money, int[] costs, boolean[] visited, int depth, int result) {
        if (depth < 0) {
            if (money == 0) {
                answer.add(result);
            }
            return;
        }


        visited[depth] = true;
        comb(money%coin[depth], costs, visited, depth-1, result + (costs[depth] * (money/coin[depth])));

        visited[depth] = false;
        comb(money, costs, visited, depth-1, result);
    }
}
