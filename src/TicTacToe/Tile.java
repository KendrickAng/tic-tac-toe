package TicTacToe;

import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

public class Tile {
    private int row;
    private int col;
    private String token;

    Tile(int row, int col) {
        this.row = row;
        this.col = col;
        token = TOKEN_DEFAULT;
    }

    Tile(Tile tile) {
        this.row = tile.getRow();
        this.col = tile.getCol();
        token = tile.getToken();
    }

    Tile getCopy() {
        return new Tile(this);
    }

	int getRow() {
		return row;
	}

	int getCol() {
		return col;
	}

    String getToken() {
        return token;
    }

    void setToken(String s) {
        token = s;
    }
}
