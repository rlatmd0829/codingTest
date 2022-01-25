package past.November;

import java.util.LinkedList;
import java.util.Queue;

public class pro_2020카카오인턴십_경주로건설 {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int cost = Integer.MAX_VALUE;
    public static int solution(int[][] board){
        map = board;
        int answer = 0;
        n = board.length;
        visited = new boolean[n][n];

        bfs(0,0,-1,0);
        answer = cost;
        return answer;
    }

    public static void bfs(int x, int y, int dir, int price){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y, dir, price});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDir = now[2];
            int nowPrice = now[3];

            if (nowX == n-1 && nowY == n-1){
                cost = Math.min(cost, nowPrice);
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextDir = i;
                int nextPrice = nowPrice;

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || map[nextX][nextY] == 1)
                    continue;

                if (nowDir == -1){ // 처음엔 직선
                    nextPrice += 100;
                } else if (nowDir == nextDir){
                    // 방향 같을때
                    nextPrice += 100;
                } else {
                    // 방향 다를때
                    nextPrice += 600;
                }

                if (!visited[nextX][nextY] || map[nextX][nextY] >= nextPrice){
                    q.add(new int[] {nextX, nextY, nextDir, nextPrice});
                    map[nextX][nextY] = nextPrice;
                    visited[nextX][nextY] = true;
                }


            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,0,0}, {0,0,0}};
        System.out.println(solution(arr));
    }
}
