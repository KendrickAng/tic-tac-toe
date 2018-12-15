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

    String getToken() {
        return token;
    }
    void setToken(String s) {
        token = s;
    }
}
