package TicTacToe;

abstract class Player {
    private String token;

    Player(String token) {
        this.token = token;
    }

    String getToken() {
        return token;
    }
    abstract int[] makeMove();
}
