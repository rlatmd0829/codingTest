package N_2022.May;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178 {
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    static int[][] distance;
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        distance = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String s = sc.next();
            String[] str = s.split("");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        bfs();
        System.out.println(distance[N][M]);

    }
    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1));
        visited[1][1] = true;
        distance[1][1] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 < nx && 0 < ny && nx <= N && ny <= M) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                    }
                }
            }
        }
    }
}
