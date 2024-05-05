package N_2024.may;

public class 이웃한_칸 {
    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        int result = solution(board, h, w);
        System.out.println(result);
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[h][w].equals(board[x][y])) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
