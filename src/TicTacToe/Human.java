package TicTacToe;

import java.util.Scanner;

class Human extends Player{

    Human(String token) {
        super(token);
    }

    /** Returns an array of coordinates where the move is to be made*/
    @Override
    public int[] makeMove() {
        int[] move = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row coordinate of move: ");
        int x = sc.nextInt(); move[0] = x;
        System.out.print("Enter column coordinate of move: ");
        int y = sc.nextInt(); move[1] = y;
        return move;
    }
}
