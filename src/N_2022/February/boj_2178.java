package N_2022.February;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178 {

    static int[][] arr;
    static int[][] distance;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Node {
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
        arr = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length; j++) {
                arr[i][j] = c[j] - '0';
            }
        }
        bfs();
        System.out.println(distance[N-1][M-1]);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && 0 <= ny && nx < N && ny < M) {
                    if (1 == arr[nx][ny] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.add(new Node(nx,ny));
                    }
                }
            }

        }
    }
}
