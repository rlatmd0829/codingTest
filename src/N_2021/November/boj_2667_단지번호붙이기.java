package N_2021.November;

import java.util.*;

public class boj_2667_단지번호붙이기 {
    public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] arr;
    public static int[][] distance;
    public static boolean[][] visited;
    public static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int count = 0;
        List<Integer> result = new LinkedList<>();
        arr = new int[N][N];
        visited = new boolean[N][N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1){
                    result.add(bfs(i, j));
                    count += 1;
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        int bfs_cnt = 1;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int q[] = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny] || arr[nx][ny] == 0){
                    continue;
                }

                queue.add(new int[] {nx, ny});
                bfs_cnt++;
                visited[nx][ny] = true;
            }
        }
        return bfs_cnt;
    }
}
