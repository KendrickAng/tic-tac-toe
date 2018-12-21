package TicTacToe;

import java.util.ArrayList;
import java.util.HashMap;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

public class MinimaxAI extends Player {

    MinimaxAI(String token, Board board) {
        super(token, board);
    }

	@Override
	Tile pickTile() {
		// get the copied board
		Board boardCopy = super.getBoard();
		String token = super.getToken();
		Tile maxTile;
		Board maxBoard;
		int maxScore = -1;
		// iterate through the board
		for(int r = 0; r < boardCopy.getRows(); r++) {
			for(int c = 0; c < boardCopy.getCols(); c++) {
				// make a new board w/ token at the empty spt
				if(boardCopy.getToken(r, c).equals(TOKEN_DEFAULT)) {
					Board boardCopyCopy = boardCopy.getCopy();
					boardCopyCopy.setToken(r, c, token);

					// int score = getBoardScore(boardCopyCopy); // get score and store
					int score = 0;
					if (score > maxScore) {
						maxBoard = boardCopyCopy;
						maxScore = score;
						maxTile = getTile(r, c);
					}
				}
			}
		}

		return null;
	}

//	public int getBoardScore(boolean turn, Board board) {
//    	if (turn) {
//
//		}
//	}
}

	/*
	scores.put(score, )

	if(score == 0) {
		pickTile()????
	}
	*/