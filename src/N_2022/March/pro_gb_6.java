package N_2022.March;

import java.util.*;

public class pro_gb_6 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    public static List<Node> result;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 1, 1, 0, 1}, {1, 2, 0, 3, 0}, {0, 1, 5, 1, 2},
                {0, 0, 1, 3, 1}, {1, 2, 0, 1, 1}}, 2));
    }

    public static int solution(int[][] grid, int K) {
        result = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.println(i+" "+j);
                bfs(i,j,grid, K);
            }
        }

        Collections.sort(result, Collections.reverseOrder());


        int i = 1;

        while(true) {
            if ((result.get(0).x + K) > result.get(i).x || (result.get(0).x - K) < result.get(i).x &&
                    (result.get(0).y + K) > result.get(i).y || result.get(0).y - K < result.get(i).y) {
                return result.get(0).count + result.get(i).count;
            }
        }
    }

    public static void bfs(int x, int y, int[][] grid, int K) {

        int count = 0;

        count = calculate(x, y, grid, K, count);
        result.add(new Node(x,y,count));
    }

    private static int calculate(int x, int y, int[][] grid, int K, int count) {
        for (int i = x; i < x + K; i++) {
            for (int j = y; j < y + K; j++) {
                if (i >= 0 && j >= 0 && i < grid.length && j < grid.length) {
                    count += grid[i][j];
                }else {
                    return 0;
                }
            }
        }
        return count;
    }
}
