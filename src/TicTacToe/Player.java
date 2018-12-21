package TicTacToe;

abstract class Player {

    private String token;
    private Board board;
    private Rules rules;

    Player(String token, Board board, Rules rules) {
        this.token = token;
        this.board = board;
        this.rules = rules;
    }

    String getToken() {
        return token;
    }

    Board getBoard() {
        return board.getCopy();
    }

    Rules getRules() {
    	return rules;
	}

    Tile getTile(int row, int col) {
    	return board.getTile(row, col);
    }

    abstract Tile pickTile();
}
