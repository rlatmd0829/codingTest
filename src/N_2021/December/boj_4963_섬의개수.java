package N_2021.December;

import java.util.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj_4963_섬의개수 {
    public static int[] dx = {-1,1,0,0,-1,-1,1,1};
    public static int[] dy = {0,0,-1,1,-1,1,1,-1};
    public static int w;
    public static int h;
    public static int[][] arr;
    public static boolean[][] visited;
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            result.add(count);

        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int qx = node.x;
            int qy = node.y;

            for (int i = 0; i < 8; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
