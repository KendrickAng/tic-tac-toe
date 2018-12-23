package TicTacToe;

class Board {
	private int rows;
    private int cols;
	private Tile[][] board;

    Board(int size) {
        cols = rows = size;
        board = new Tile[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                board[r][c] = new Tile(r, c);
            }
        }
    }

    Board(Board oldBoard) {
        rows = oldBoard.getRows();
        cols = oldBoard.getCols();
    	board = new Tile[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                board[r][c] = oldBoard.getTile(r, c).getCopy();
            }
        }
    }

    Board getCopy() {
        return new Board(this);
    }

    /** Gets the string at position row, col*/
    Token getToken(int row, int col) {
        return getTile(row, col).getToken();
    }

    /** Gets the tile at position row, col, returns null if out of bounds*/
    Tile getTile(int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return null;
        return board[row][col];
    }
    
    /** Sets the string at position row, col to s*/
    void setToken(int row, int col, Token token) {
        getTile(row, col).setToken(token);
    }

    void print() {
        for(int c = 0; c < cols; c++) {
            if(c == 0) System.out.print("  ");
            System.out.print(c + " ");
        }
        System.out.println();
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if(c == 0) System.out.print(r + " ");
                System.out.print(board[r][c].getToken() + " ");
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
