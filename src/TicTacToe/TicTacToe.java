package TicTacToe;

class TicTacToe {

    final static int BOARD_SIZE = 3;
//    final static String TOKEN_DEFAULT = "_";
//    final static String TOKEN_1 = "X";
//    final static String TOKEN_2 = "O";

    private static Board board;
    private static Rules rules;
    private static GameMaster gameMaster;
    private static Human p1;
    private static MinimaxAI p2;
    private static Token currentPlayer;
    private static boolean gameOver;

    public static void main(String[] args) {
        board = new Board(BOARD_SIZE);
        rules = new Rules();
        gameMaster = new GameMaster();
        /*
        Lols, you can change Human to MinimaxAI to see 2 AIs fighting each other.

        Though 4x4 is really slow and the moves are quite "stupid". (Limitation of Minimax)
        Probably need an AI which can give a score based on the PROBABILITY of winning.
         */
        p1 = new Human(Token.X, board, rules);
        p2 = new MinimaxAI(Token.O, board, rules);
        currentPlayer = Token.X; // X starts first
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
            if(rules.isWin(board, currentPlayer)) {
                gameOver = true;
                System.out.println(currentPlayer + " WINS!");
            }
            else if(rules.isDraw(board)) {
                gameOver = true;
                System.out.println("MATCH OVER! NOBODY WINS - DRAW");
            }
            // switch player next
            currentPlayer = currentPlayer.equals(Token.X) ? Token.O : Token.X;
        } while(!gameOver);
    }
}
