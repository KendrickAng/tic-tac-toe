package TicTacToe;

abstract class Player {
    private String token;
    private Board board;

    Player(String token, Board board) {
        this.token = token;
        this.board = board;
    }

    String getToken() {
        return token;
    }
    Board getBoard() { return board; }
    abstract Tile pickTile();
}
