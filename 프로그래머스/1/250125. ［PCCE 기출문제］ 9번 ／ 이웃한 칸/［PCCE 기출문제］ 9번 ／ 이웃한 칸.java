class Solution {
    public int solution(String[][] board, int h, int w) {
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