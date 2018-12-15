package TicTacToe;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

class GameMaster {
    private Board board;

    GameMaster(Board board) {
    	this.board = board;
	}

    boolean checkWin(String s) {
        int max = board.getRows();
        // check rows and columns
        for(int i = 0; i < max; i++) {
            if((board.get(i, 0).equals(s) && board.get(i, 1).equals(s) && board.get(i, 2).equals(s)) || // check rows
                    board.get(0, i).equals(s) && board.get(1, i).equals(s) && board.get(2, i).equals(s)) return true; // check columns

        }
        if(board.get(0, 0).equals(s) && board.get(1, 1).equals(s) && board.get(2, 2).equals(s)) return true; // check descending diagonals
        if(board.get(2, 0).equals(s) && board.get(1, 1).equals(s) && board.get(0, 2).equals(s)) return true; // check ascending diagonals
        return false;
    }

    boolean isMoveValid(int[] move) {
        if(isMoveValidHelper(move)) {
            return true;
        } else {
            System.out.println("Invalid input! Re-enter your coordinates.");
            return false;
        }
    }

    private boolean isMoveValidHelper(int[] move) {
        int height = board.getRows();
        int width = board.getCols();
        int row = move[0]; int col = move[1];
        if(row < 0 || row > width - 1 || col < 0 || col > height - 1) {
            return false; // out of bounds
        } else {
            return board.get(row, col).equals(TOKEN_DEFAULT); // true if board space is empty ("_")
        }
    }
}
