package TicTacToe;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

class GameMaster {
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
        int max = board.getRows();
        // check rows and columns
        for(int i = 0; i < max; i++) { // We return true instead of returning false since the events are non-exhaustive (its possible for no winning condition to occur)
            if((board.getToken(i, 0).equals(s) && board.getToken(i, 1).equals(s) && board.getToken(i, 2).equals(s)) || // check rows
                    board.getToken(0, i).equals(s) && board.getToken(1, i).equals(s) && board.getToken(2, i).equals(s)) return true; // check columns

        }
        if(board.getToken(0, 0).equals(s) && board.getToken(1, 1).equals(s) && board.getToken(2, 2).equals(s)) return true; // check descending diagonals
        if(board.getToken(2, 0).equals(s) && board.getToken(1, 1).equals(s) && board.getToken(0, 2).equals(s)) return true; // check ascending diagonals
        return false;
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
