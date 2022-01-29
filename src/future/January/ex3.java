package future.January;

import java.util.*;

public class ex3 {
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static boolean[][] visited;
    static int[][] distance;
    static List<Node> per;
    static int fx;
    static int fy;
    // 0 : 열려있음
    // 1 : 닫혀있음
    // 2 : 금화
    static class Node{
        int x;
        int y;

        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        per = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    per.add(new Node())
                }
            }
        }
        fx = sc.nextInt();
        fy = sc.nextInt();


    }
    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && arr[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx,ny));

                    }
                }
            }
        }
    }
}
