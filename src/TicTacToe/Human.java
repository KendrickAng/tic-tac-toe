package TicTacToe;

import java.util.Scanner;

class Human extends Player{

    Human(String token, Board board, Rules rules) {
        super(token, board, rules);
    }

    /** Returns the Tile from the board where the move is to be made*/
    @Override
    public Tile pickTile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row coordinate of move: ");
        int row = sc.nextInt();
        System.out.print("Enter column coordinate of move: ");
        int col = sc.nextInt();
        return getTile(row, col);
    }
}
