import java.util.Scanner;

public class Tic_tac_toe_game {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            // Print board
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
                if (i < 2) System.out.println("--+---+--");
            }

            // Ask move
            System.out.println("Player " + currentPlayer + " enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
            } else {
                System.out.println("Spot taken, try again!");
                continue;
            }

            // Check win
            if ((board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) ||
                (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) ||
                (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) ||
                (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else {
                // Check draw
                boolean full = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == ' ') full = false;
                    }
                }
                if (full) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
        sc.close();
    }
}
