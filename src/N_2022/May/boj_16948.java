package N_2022.May;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_16948 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        distance = new int[N][N];
        bfs();
        if (distance[r2][c2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(distance[r2][c2]);
        }
    }
    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r1, c1));
        visited[r1][c1] = true;

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && 0 <= ny && nx < N && ny < N) {
                    if (!visited[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        distance[nx][ny] = distance[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
