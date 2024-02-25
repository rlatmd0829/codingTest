import java.util.*;

public class Main {
    static int arr[][];
    static boolean check[][];
    static int m,n;
    static ArrayList<Integer> resultList;
    static int[][] pos = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 우, 좌, 상, 하
    static int cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int c=0; c<T; c++){
            m = sc.nextInt(); // 가로길이
            n = sc.nextInt(); // 세로길이

            arr = new int[m][n];
            check = new boolean[m][n];

            int k = sc.nextInt();
            for(int i=0; i<k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            //resultList = new ArrayList<>();
            cnt=0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j] == 1 && check[i][j] ==false){
                        cnt++;
                        dfs(i,j);
                        //resultList.add(cnt);
                    }
                }
            }
            System.out.println(cnt);
        }

//        for(Integer integer : resultList) {
//            System.out.println(integer);
//        }
    }

    public static void dfs(int x, int y){
       // cnt++; // 1개의 단지마다 몇 가구가 있는지 카운트
        check[x][y] = true;
        for (int i=0; i<pos.length; i++){
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            // 1. 배열의 조건을 만족하는지
            // 2. 단지가 연결이 되있는지
            // 3. 방문을 하지않은 곳이였을때

            if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny]==1 && check[nx][ny] == false){
                dfs(nx, ny);
            }
        }
    }
}
