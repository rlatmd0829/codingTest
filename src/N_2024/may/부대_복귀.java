package N_2024.may;

import java.util.LinkedList;
import java.util.Queue;

// 실패
public class 부대_복귀 {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;
        int[] result = solution(n, roads, sources, destination);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};

        int[][] arr = new int[n+1][n+1];

        for (int i = 0; i < roads.length; i++) {
            arr[roads[i][0]][roads[i][1]] = 1;
            arr[roads[i][1]][roads[i][0]] = 1;
        }

        answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            int[] visit = new int[n+1];
            int cnt = 1;
            boolean flag = false;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            while (!queue.isEmpty()) {
                int point = queue.poll();
                visit[point] = 1;
                for (int j = 1; j <= n; j++) {
                    if (visit[j] == 1) {
                        continue;
                    }
                    if (arr[point][j] == 1) {
                        if (j == destination) {
                            cnt++;
                            flag = true;
                            break;
                        }
                        visit[j] = 1;
                        queue.offer(j);
                        cnt++;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag) {
                answer[i] = cnt;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
