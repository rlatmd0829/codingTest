package N_2022.March;

import java.util.*;

public class pro_car_1 {

    static int[][] arr;
    static Set<Integer> answer;
    static boolean[] visited;
    public static void main(String[] args) {
        solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}});
    }

    private static void solution(int n, int k, int[][] roads) {
        arr = new int[n][n];
        visited = new boolean[n];
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        answer = new LinkedHashSet<>();
//        visited = new boolean[n];
        for (int[] road : roads) {
            arr[road[0]][road[1]] = road[2];
            arr[road[1]][road[0]] = road[2];
        }

//        dfs(0, k, 0, answer, visited);
        bfs(k);
        ArrayList list = new ArrayList(answer);
        Collections.sort(list);

        if (list.size() == 0) {
            list.add(-1);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int result = 0;

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int i = 0; i < arr.length; i++) {
                if (arr[now][i] != 0) {
                    result += arr[now][i];
                    queue.add(i);
                }
                if (result > k) {
                    return;
                } else if (result == k) {
                    answer.add(now);
                    return;
                }
            }
        }
    }

    private static void dfs(int result, int k, int now, Set<Integer> answer, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (result > k) {
                return;
            } else if (result == k) {
                if (!answer.contains(now)) {
                } else {
                    answer.add(now);
                }
                return;
            } else if (arr[now][i] != 0) {
                visited[i] = true;
                dfs(result + arr[now][i], k, i, answer, visited);
                visited[i] = false;
            }
        }
    }
}
