package TicTacToe;

//import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

public class Rules {

	private static final int WIN_CONDITION = 3; // get 3 in a row/col/diag to win

	boolean isWin(Board board, Token s) {
		boolean win = false;
		int max = board.getRows();
		// We return true instead of returning false since the events are non-exhaustive (its possible for no winning condition to occur)
		// check rows
		for(int r = 0; r < max; r++) { // check each 3-row for win
			for(int c = 0; c < max - (WIN_CONDITION - 1); c++) {
				boolean row_win = true;
				for(int rw = 0; rw < WIN_CONDITION; rw++) { // check individual 3-row
					if(!board.getToken(r, c + rw).equals(s)) row_win = false;
				}
				if(row_win) win = row_win; // only allow win = false -> win = true, not win = true -> win = false
			}
		}
		// check columns
		for(int r = 0; r < max - (WIN_CONDITION - 1); r++) {
			for(int c = 0; c < max; c++) { // check each 3-col for win
				boolean col_win = true;
				for(int cw = 0; cw < WIN_CONDITION; cw++) {
					if(!board.getToken(r + cw, c).equals(s)) col_win = false;
				}
				if(col_win) win = col_win; // only allow win = false -> win = true, not win = true -> win = false
			}
		}
		// check each 3-diag for win
		for(int r = 0; r < max - (WIN_CONDITION  - 1); r++) {
			for (int c = 0; c < max - (WIN_CONDITION - 1); c++) {
				boolean diag_win = true;
				for (int dw = 0; dw < WIN_CONDITION; dw++) {
					if (!board.getToken(r + dw, c + dw).equals(s)) diag_win = false;
				}
				if (diag_win) win = diag_win; // only allow win = false -> win = true, not win = true -> win = false
			}
		}
		// check each 3-inverse diag for win
		for(int r = 0; r < max - (WIN_CONDITION - 1); r++) {
			for(int c = 0; c < max - (WIN_CONDITION - 1); c++) {
				boolean diag_i_win = true;
				for(int diw = 0; diw < WIN_CONDITION; diw++) {
					if(!board.getToken((max - 1) - r - diw, c + diw).equals(s)) diag_i_win = false;
				}
				if(diag_i_win) win = diag_i_win; // only allow win = false -> win = true, not win = true -> win = false
			}
		}
		return win;
	}

	boolean isDraw(Board board) {
		boolean isBoardFull = true;
		int row = board.getRows();
		int col = board.getCols();
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) { // board has unfilled tokens -> game hasn't ended
				if(board.getToken(r, c).equals(Token._)) isBoardFull = false;
			}
		}
		return isBoardFull;
	}
}
