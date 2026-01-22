class Solution {
    private boolean finalBoolean = false;

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    backtrack(i, j, 1, board, word, m, n, visited);
                    if(finalBoolean) return true;
                }
            }
        }

        return finalBoolean;
    }

    private void backtrack(int i, int j, int iterator, char[][] board, String word, int m, int n, boolean[][] visited){
        if(iterator == word.length()){
            finalBoolean = true;
            return;
        }
        if(i < 0 || i >= n || j < 0 || j >= m){
            return;
        }

        //up
        if(i != 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(iterator)){
            visited[i-1][j] = true;
            backtrack(i-1, j, iterator+1, board, word, m, n, visited);
            visited[i-1][j] = false;
        }

        //left
        if(j != 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(iterator)){
            visited[i][j-1] = true;
            backtrack(i, j-1, iterator+1, board, word, m, n, visited);
            visited[i][j-1] = false;
        }

        //right
        if(j != m-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(iterator)){
            visited[i][j+1] = true;
            backtrack(i, j+1, iterator+1, board, word, m, n, visited);
            visited[i][j+1] = false;
        }

        //bottom
        if(i != n-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(iterator)){
            visited[i+1][j] = true;
            backtrack(i+1, j, iterator+1, board, word, m, n, visited);
            visited[i+1][j] = false;
        }
    }
}