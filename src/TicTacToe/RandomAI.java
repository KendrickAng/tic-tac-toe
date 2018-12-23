package TicTacToe;

import static TicTacToe.TicTacToe.BOARD_SIZE;

public class RandomAI extends Player {

	RandomAI(Token token, Board board, Rules rules) {
		super(token, board, rules);
	}

	@Override
	Tile pickTile() {
		int row = (int) (Math.random() * BOARD_SIZE);
		int col = (int) (Math.random() * BOARD_SIZE);
		return getTile(row, col);
	}
}
