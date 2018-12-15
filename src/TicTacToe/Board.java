package TicTacToe;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

class Board {
    private String[][] board;
    private int cols;
    private int rows;

    Board() {
        cols = 3;
        rows = 3;
        initBoard();
    }

    /** Gets the string at position row, col*/
    String get(int row, int col) {
        return board[row][col];
    }
    
    /** Sets the string at position row, col to s*/
    void set(int row, int col, String s) {
        board[row][col] = s;
    }
    
    private void initBoard() {
        board = new String[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                board[r][c] = TOKEN_DEFAULT;
            }
        }
        print();
    }

    void print() {
        for(int c = 0; c < cols; c++) {
            if(c == 0) System.out.print("  ");
            System.out.print(c + " ");
        }
        System.out.println();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(j == 0) System.out.print(i + " ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    int getRows() {
        return rows;
    }
    int getCols() {
        return cols;
    }
}
