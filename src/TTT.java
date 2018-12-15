public class TTT {
    private static Board b;
    private static Human p1;
    private static Human p2;
    private static String currentPlayer;
    private static boolean gameOver;

    public static void main(String[] args) {
        b = new Board();
        b.print();
        p1 = new Human("X");
        p2 = new Human("O");
        currentPlayer = "X"; // player 1 starts first
        gameOver = false;
        do {
            int[] move;
            System.out.println(currentPlayer + " moves this turn.");
            // check move
            if(p1.getToken().equals(currentPlayer)) {
                // player 1 (X) moves
                do {
                    move = p1.makeMove();
                }
                while(!isMoveValid(move));
                b.set(move[0], move[1], p1.getToken());
            } else {
                // player 2 (O) moves
                do {
                    move = p2.makeMove();
                }
                while(!isMoveValid(move));
                b.set(move[0], move[1], p2.getToken());
            }
            // print the board
            b.print();
            // check win condition
            if(checkWin(currentPlayer)) {
                gameOver = true;
                System.out.println(currentPlayer + " WINS!");
            }
            // switch player next
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        } while(!gameOver);
    }

    private static boolean checkWin(String s) {
        int max = b.getRows();
        // check rows and columns
        for(int i = 0; i < max; i++) {
            if((b.get(i, 0).equals(s) && b.get(i, 1).equals(s) && b.get(i, 2).equals(s)) || // check rows
                    b.get(0, i).equals(s) && b.get(1, i).equals(s) && b.get(2, i).equals(s)) return true; // check columns

        }
        if(b.get(0, 0).equals(s) && b.get(1, 1).equals(s) && b.get(2, 2).equals(s)) return true; // check descending diagonals
        if(b.get(2, 0).equals(s) && b.get(1, 1).equals(s) && b.get(0, 2).equals(s)) return true; // check ascending diagonals
        return false;
    }

    private static boolean isMoveValid(int[] move) {
        int height = b.getRows();
        int width = b.getCols();
        int x = move[0]; int y = move[1];
        if(x < 0 || x > width - 1 || y < 0 || y > height - 1) {
            return false; // ensure valid input
        } else {
            return true;
        }
    }
}
