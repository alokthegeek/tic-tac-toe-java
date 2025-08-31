package ticTacToe;

public class Player {
    private String name;
    private char symbol;

    Player() {
        // default contructor
    }

    public Player(String name, char symbol) {
        // this.name = name;
        setName(name);
        // this.symbol = symbol;
        setSymbol(symbol);
    }

    public void setName(String name) { // used to set player's name outside this class
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setSymbol(char symbol) { // // used to set player's symbol outside this class
        if (symbol != '\0') {
            this.symbol = symbol;
        }
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    // public void print() {
    // System.out.println(this.name + " " + this.symbol);
    // }

}