package TicTacToe;

import static TicTacToe.TicTacToe.BOARD_SIZE;

public class RandomAI extends Player {

	RandomAI(String token, Board board) {
		super(token, board);
	}

	@Override
	Tile pickTile() {
		int row = (int) (Math.random() * BOARD_SIZE);
		int col = (int) (Math.random() * BOARD_SIZE);
		return getTile(row, col);
	}
}
