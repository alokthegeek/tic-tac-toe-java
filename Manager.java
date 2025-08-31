package ticTacToe;

import java.util.*;

public class Manager { // FIX THE DEFAULT CONSTRUCTOR PROBLEM (!!!FIXED!!!)
    private Player player1, player2;
    private Board board;
    private int numPlayers = 0; // initially
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.startGame();
    }

    public void startGame() {
        // Scanner s = new Scanner(System.in);

        // creating objects
        player1 = takePlayerInput(++numPlayers); // takePlayerInput is defined below (line 80).
        player2 = takePlayerInput(++numPlayers); // taking player2 inputs.

        // ensuring both the players have different symbol
        while (player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Symbol is already taken, please enter a different Symbol");
            char newSymbol = s.next().charAt(0);
            player2.setSymbol(newSymbol);
        }

        // creating the board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        board.print();

        // play the game
        int num = 1; // initially player1 will play

        while (board.getCount() < board.getBoardSize() * board.getBoardSize()) {

            // DRAW CONDITION CHECK
            if (board.getCount() == board.getBoardSize() * board.getBoardSize()) {
                System.out.println("DRAW");
                board.print();
                return;
            }

            switch (num) {
                case 1: { // for player 1
                    System.out.println("Enter Player 1 Move (row col in 0..2)");
                    boolean val1 = false; // this checks for invalid moves by player1
                    while (val1 != true) {

                        // taking input coordinates for a move
                        int a1 = s.nextInt();
                        int b1 = s.nextInt();

                        val1 = board.setChar(player1.getSymbol(), a1, b1); // setChar is a bool function

                        // WINNING condition check
                        if (val1) {
                            boolean value = board.winningCondCheck(a1, b1);
                            if (value == true) {
                                System.out.println("PLAYER 1 " + player1.getName() + " WON");
                                board.print();
                                return; // <-- stop the game
                            }
                        }
                    }
                    board.print();
                    num = 0; // helps in switching to the other player
                    break;
                }
                case 0: { // for player 2
                    System.out.println("Enter Player 2 Move (row col in 0..2)");
                    boolean val2 = false; // this checks for invalid moves by player2
                    while (val2 != true) {
                        // taking input coordinates for a move

                        int a2 = s.nextInt();
                        int b2 = s.nextInt();
                        val2 = board.setChar(player2.getSymbol(), a2, b2); // setChar is a bool function

                        // WINNING condition check
                        if (val2) {
                            boolean value = board.winningCondCheck(a2, b2);
                            if (value == true) {
                                System.out.println("PLAYER 2 " + player2.getName() + " WON");
                                board.print();
                                return; // <-- stop the game
                            }
                        }
                    }
                    board.print();
                    num = 1; // helps in switching to the other player
                    break;
                }

                default:
                    break;
            }
        }
        // ... end of while loop
        System.out.println("DRAW");
        board.print();
    }

    private Player takePlayerInput(int num) {
        // scanner object to take input
        // Scanner s = new Scanner(System.in);

        // taking name inputs
        System.out.println("Enter player " + num + " name: ");
        String name = s.next();

        // taking symbol inputs
        System.out.println("Enter player " + num + " Symbol: ");
        char symbol = s.next().charAt(0);

        // CHECKING FOR INVALID SYMBOL
        while (Character.isWhitespace(symbol) || symbol == '|') {
            System.out.println("Pick a visible symbol (not space/|).");
            symbol = s.next().charAt(0);
        }

        Player p = new Player(name, symbol);
        return p;
    }
}