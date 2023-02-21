/**
 * leetcode 79题 单词搜索
 */
public class Subject79Demo {

    public static void main(String[] args) {
        char[][] chars = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(chars, "SEE"));
    }


    public static boolean exist(char[][] board, String word) {
        int b = board.length;
        int c = board[0].length;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int b, int p, String word, int k) {

        if (k == word.length()) {
            return true;
        }

        if (b < 0 || b >= board.length || p < 0 || p >= board[0].length) {
            return false;
        }

        char c = word.charAt(k);
        if (board[b][p] != c) {
            return false;
        }
        board[b][p] = '0';
        boolean res = (dfs(board, b, p - 1, word, k + 1) || dfs(board, b - 1, p, word, k + 1)
            || dfs(board, b, p + 1, word, k + 1) || dfs(board, b + 1, p, word, k + 1));
        board[b][p] = c;
        return res;

    }
}