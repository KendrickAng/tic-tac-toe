package TicTacToe;

//import static TicTacToe.TicTacToe.TOKEN_DEFAULT;

public class Tile {
    private int row;
    private int col;
    private Token token;

    Tile(int row, int col) {
        this.row = row;
        this.col = col;
        token = Token._;
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

    Token getToken() {
        return token;
    }

    void setToken(Token token) {
        this.token = token;
    }
}
