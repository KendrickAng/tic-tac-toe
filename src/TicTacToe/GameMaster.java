package TicTacToe;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

class GameMaster {
    private static final int WIN_CONDITION = 3; // get 3 in a row/col/diag to win
    private Board board;

    GameMaster(Board board) {
    	this.board = board;
	}

	/** Sets the token at the input Tile to (token)*/
	void setTileToken(Tile tile, String token) {
        tile.setToken(token);
    }

    /** Checks the entire board for a winning row/column/diagonal w.r.t the input token string*/
    // TODO: allow the board to check for winner for any number of rows and columns
    boolean checkWin(String s) {
        boolean win = false;
        int max = board.getRows();
        // check rows and columns
        for(int i = 0; i < max; i++) { // We return true instead of returning false since the events are non-exhaustive (its possible for no winning condition to occur)
            for(int r = 0; r < max - (WIN_CONDITION - 1); r++) { // check each 3-row for win
                if(board.getToken(i, r).equals(s) && board.getToken(i, r + 1).equals(s) && board.getToken(i, r + 2).equals(s)) win = true;
            }
            for(int c = 0; c < max - (WIN_CONDITION - 1); c++) { // check each 3-col for win
                if(board.getToken(c, i).equals(s) && board.getToken(c + 1, i).equals(s) && board.getToken(c + 2, i).equals(s)) win = true;
            }
        }
        for(int d = 0; d < max - (WIN_CONDITION - 1); d++) { // check each 3-diag for win
            if(board.getToken(d, d).equals(s) && board.getToken(d + 1, d + 1).equals(s) && board.getToken(d + 2, d + 2).equals(s)) win = true;
        }
        for(int di = 0; di < max - (WIN_CONDITION - 1); di++) { // check each 3-inverse diag for win
            if(board.getToken(max-1, di).equals(s) && board.getToken(max-2, di + 1).equals(s) && board.getToken(max-3, di + 2).equals(s)) win = true;
        }
        return win;
    }

    /** Returns true if board is full, false otherwise*/
    boolean checkDraw() {
        boolean isBoardFull = true;
        int row = board.getRows();
        int col = board.getCols();
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) { // board has unfilled tokens -> game hasn't ended
                if(board.getToken(r, c).equals(TOKEN_DEFAULT)) isBoardFull = false;
            }
        }
        return isBoardFull;
    }

    boolean isTileValid(Tile tile) {
        if(isTileValidHelper(tile)) {
            return true;
        } else {
            System.out.println("Invalid input! Re-enter your coordinates.");
            return false;
        }
    }

    private boolean isTileValidHelper(Tile tile) {
        if(tile == null) {
            return false; // out of bounds
        } else {
            return tile.getToken().equals(TOKEN_DEFAULT); // true if board space is empty ("_")
        }
    }
}
