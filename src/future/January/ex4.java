package future.January;

import java.util.Scanner;

public class ex4 {
    static int H;
    static int W;
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static int maxx = 0;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < W; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                visited = new boolean[H][W];
                dfs(i,j,0,arr[i][j]);
            }
        }
        System.out.println(maxx);
    }

    private static void dfs(int a, int b, int depth, int result) {
        visited[a][b] = true;
        if (depth == N-1) {
            if (maxx < result) {
                maxx = result;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth+1, result+arr[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}

/*
4 5 4
03542
12211
41363
10917
*/

/*
3 4 2
7429
5708
1558
*/
