package TicTacToe;

class TicTacToe {
    final static String TOKEN_DEFAULT = "_";
    private final static String TOKEN_1 = "X";
    private final static String TOKEN_2 = "O";

    private static Board board;
    private static GameMaster gameMaster;
    private static Human p1;
    private static Human p2;
    private static String currentPlayer;
    private static boolean gameOver;

    public static void main(String[] args) {
        board = new Board();
        gameMaster = new GameMaster(board);
        p1 = new Human(TOKEN_1, board);
        p2 = new Human(TOKEN_2, board);
        currentPlayer = TOKEN_1; // player 1 starts first
        gameOver = false;

		/**
		Game Start
		 */
		board.print();
        do {
            Tile tile;
            System.out.println(currentPlayer + " moves this turn.");
            // check move\
            if(p1.getToken().equals(currentPlayer)) {
                // player 1 (X) picks a tile to own
                do {
                    tile = p1.pickTile();
                }
                while(!gameMaster.isTileValid(tile));
                gameMaster.setTileToken(tile, p1.getToken());
            } else {
                // player 2 (O) picks a tile to own
                do {
                    tile = p2.pickTile();
                }
                while(!gameMaster.isTileValid(tile));
                gameMaster.setTileToken(tile, p2.getToken());
            }
            // print the board
            board.print();
            // check win condition
            if(gameMaster.checkWin(currentPlayer)) {
                gameOver = true;
                System.out.println(currentPlayer + " WINS!");
            }
            // TODO: Check Draw condition
            if(gameMaster.checkDraw()) {
                gameOver = true;
                System.out.println("MATCH OVER! NOBODY WINS - DRAW");
            }
            // switch player next
            currentPlayer = currentPlayer.equals(TOKEN_1) ? TOKEN_2 : TOKEN_1;
        } while(!gameOver);
    }
}
