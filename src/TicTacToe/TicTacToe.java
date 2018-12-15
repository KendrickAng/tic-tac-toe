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
        p1 = new Human(TOKEN_1);
        p2 = new Human(TOKEN_2);
        currentPlayer = TOKEN_1; // player 1 starts first
        gameOver = false;

		/**
		Game Start
		 */
		board.print();
        do {
            int[] move;
            System.out.println(currentPlayer + " moves this turn.");
            // check move\
            if(p1.getToken().equals(currentPlayer)) {
                // player 1 (X) moves
                do {
                    move = p1.makeMove();
                }
                while(!gameMaster.isMoveValid(move));
                board.set(move[0], move[1], p1.getToken());
            } else {
                // player 2 (O) moves
                do {
                    move = p2.makeMove();
                }
                while(!gameMaster.isMoveValid(move));
                board.set(move[0], move[1], p2.getToken());
            }
            // print the board
            board.print();
            // check win condition
            if(gameMaster.checkWin(currentPlayer)) {
                gameOver = true;
                System.out.println(currentPlayer + " WINS!");
            }
            // switch player next
            currentPlayer = currentPlayer.equals(TOKEN_1) ? TOKEN_2 : TOKEN_1;
        } while(!gameOver);
    }
}
