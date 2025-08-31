package ticTacToe;

public class Board extends Player {
    private char boardArr[][];
    private int boardSize = 3;
    // private char p1Symbol, p2Symbol;

    // count of number of cells that are filled.
    private int count = 0;

    private static final char EMPTY = ' ';

    public Board() { // default modified constructor
        boardArr = new char[boardSize][boardSize];

        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr[0].length; j++) {
                boardArr[i][j] = EMPTY;
            }
        }
    }

    public Board(char p1Symbol, char p2Symbol) { // parametrised constructor
        this();

        // this.p1Symbol = p1Symbol;
        // this.p2Symbol = p2Symbol;
    }

    public boolean setChar(char playerSymbol, int a, int b) {
        if ((a < boardSize) && (b < boardSize) && (b >= 0) && (a >= 0) && this.boardArr[a][b] == EMPTY) {
            this.boardArr[a][b] = playerSymbol;
            count++;
            return true;
        } else {
            System.out.println("!!! INVALID MOVE DETECTED !!!");
            return false;
        }
    }

    public boolean winningCondCheck(int a, int b) {
        // ROW
        if (boardArr[a][0] != EMPTY &&
                boardArr[a][0] == boardArr[a][1] &&
                boardArr[a][0] == boardArr[a][2]) {
            return true;
        }

        // COL
        if (boardArr[0][b] != EMPTY &&
                boardArr[0][b] == boardArr[1][b] &&
                boardArr[0][b] == boardArr[2][b]) {
            return true;
        }

        // DIAGS
        if (boardArr[0][0] != EMPTY &&
                boardArr[0][0] == boardArr[1][1] &&
                boardArr[0][0] == boardArr[2][2]) {
            return true;
        }

        if (boardArr[0][2] != EMPTY &&
                boardArr[0][2] == boardArr[1][1] &&
                boardArr[0][2] == boardArr[2][0]) {
            return true;
        }

        return false;
    }

    public void print() {

        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr[0].length; j++) {
                System.out.print("|" + boardArr[i][j] + "|");
            }
            System.out.println();
        }

    }

    public int getCount() {
        return this.count;
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void incrementCount() {
        this.count++;
    }
}