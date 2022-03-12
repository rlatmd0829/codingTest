package N_2022.March;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pro_sk_2 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] result;

    public static void main(String[] args) {
        solution(9, false);
    }

    public static void solution(int n, boolean clockwise) {
        result = new int[n][n];

        for (int i = 0; i < 4; i++) {
            if (clockwise) {
                bfs(0,0, n, 1, clockwise, result);
                bfs(0,n-1, n, 2, clockwise, result);
                bfs(n-1,0, n, 0, clockwise, result);
                bfs(n-1,n-1, n, 3, clockwise, result);
            } else {
                bfs(0,0, n, 2, clockwise, result);
                bfs(0,n-1, n, 3, clockwise, result);
                bfs(n-1,0, n, 1, clockwise, result);
                bfs(n-1,n-1, n, 0, clockwise, result);
            }

        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    // n이 홀수일 경우 한군데로 모이고
    // 짝수일 경우 안모임

    public static void bfs(int a, int b, int n, int dir, boolean clockwise, int[][] result) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a,b));
        int count = 1;
        result[a][b] = count;
        int temp = n;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;

            int tx = 0;
            int ty = 0;

            for (int i = 0; i < n-2; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < temp && ny < temp) {
                    count++;
                    result[nx][ny] = count;
                    System.out.println(nx+" "+ny+" "+count);
                    x = nx;
                    y = ny;
                    tx = nx;
                    ty = ny;
                }

                if (temp % 2 == 0) {
                    if ((nx == temp/2 && ny == temp/2) || (nx == temp/2-1 && ny == temp/2) || (nx == temp/2 && ny == temp/2-1) || (nx == temp/2-1 && ny == temp/2-1)) {
                        return;
                    }
                } else {
                    if (nx == temp/2 && ny == temp/2) {
                        return;
                    }
                }
            }

            queue.add(new Node(tx, ty));

            if (cnt > 0) {
                n -= 2;
            } else {
                n -= 1;
            }

            if (clockwise) {
                dir += 1;
                if (dir == 4) {
                    dir = 0;
                }
            } else {
                dir -= 1;
                if (dir == -1) {
                    dir = 3;
                }
            }
            cnt++;
        }
    }
}
