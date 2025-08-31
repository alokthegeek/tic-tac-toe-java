# tic-tac-toe-java
# 🎮 Tic Tac Toe (Java Console Game)

A simple **2-player Tic Tac Toe** game built in **Java** for the console.

## ✨ Features
- Two players can enter their **names** and choose unique **symbols**.
- **Input validation** ensures:
  - Players can’t pick the same symbol.
  - Moves outside the board or on already filled cells are denied.
- **Win detection**:
  - Checks rows, columns, and diagonals after each move.
- **Draw detection** if the board is full with no winner.
- Clean board printing after each move.

## 🚀 How to Run
1. Clone or download the repo.
2. Compile the Java files:
   ```bash
   javac ticTacToe/*.java

Run the game:
java ticTacToe.Manager

📂 Project Structure
	•	Player.java → Handles player details (name, symbol).
	•	Board.java → Manages the grid, moves, and win/draw checks.
	•	Manager.java → Runs the game loop and player turns.

Made with ❤️ in Java.
