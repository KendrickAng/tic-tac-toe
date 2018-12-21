package TicTacToe;

import java.util.ArrayList;

import static TicTacToe.TicTacToe.TOKEN_1;
import static TicTacToe.TicTacToe.TOKEN_2;
import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

public class MinimaxAI extends Player {

	private final static int WIN_SCORE = 1;
	private final static int DRAW_SCORE = 0;
	private final static int LOSE_SCORE = -1;

    MinimaxAI(String token, Board board, Rules rules) {
        super(token, board, rules);
    }

	@Override
	Tile pickTile() {
		// get the copied board
		Board board = super.getBoard();
		String token = super.getToken();

		Tile maxTile = null;
		int maxScore = Integer.MIN_VALUE;
		for(int r = 0; r < board.getRows(); r++) {
			for(int c = 0; c < board.getCols(); c++) {
				// make a new board w/ token at the empty spt
				if(board.getToken(r, c).equals(TOKEN_DEFAULT)) {
					Tile tile = board.getTile(r, c);
					Board b = board.getCopy();
					b.setToken(r, c, token);

					int score = getBoardScore(false, b);
					if (score > maxScore) {
						maxTile = tile;
						maxScore = score;
					}
				}
			}
		}

		return getTile(maxTile.getRow(), maxTile.getCol());
	}

	private int getBoardScore(boolean isMyTurn, Board board) {
		String myToken = TOKEN_2;
		String notMyToken = TOKEN_1;
		if (super.getRules().isWin(board, myToken)) {
    		return WIN_SCORE;
		} else if (super.getRules().isWin(board, notMyToken)) {
			return LOSE_SCORE;
		} else if (super.getRules().isDraw(board)) {
			return DRAW_SCORE;
		}
		// There is at least one empty cell on the board, so have to do recursion

		String token;
		if (isMyTurn) {
			token = myToken;
		} else {
			token = notMyToken;
		}

    	ArrayList<Board> boards = new ArrayList<>();
		for(int r = 0; r < board.getRows(); r++) {
			for(int c = 0; c < board.getCols(); c++) {
				// make a new board w/ token at the empty spt
				if(board.getToken(r, c).equals(TOKEN_DEFAULT)) {
					Board b = board.getCopy();
					b.setToken(r, c, token);
					boards.add(b);
				}
			}
		}

    	if (isMyTurn) {
    		// It's my turn, so try to maximise the score
			int maxScore = Integer.MIN_VALUE;
			for (Board b : boards) {
				int score = getBoardScore(false, b);
				if (score > maxScore) {
					maxScore = score;
				}
			}
			return maxScore;
		} else {
    		// It's not my turn, so minimize the score
    		int minScore = Integer.MAX_VALUE;
    		for (Board b : boards) {
    			int score = getBoardScore(true, b);
    			if (score < minScore) {
    				minScore = score;
				}
			}
			return minScore;
		}
	}
}


	/*
	OLD CODE

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
	*/