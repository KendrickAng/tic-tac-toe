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
        int height = board.getRows();
        int width = board.getCols();
        int x = move[0]; int y = move[1];
        if(x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return false; // ensure valid input
        } else {
            return true;
        }
    }
}
