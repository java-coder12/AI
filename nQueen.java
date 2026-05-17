public class nQueen {

    static int N = 4;

    static int[] board = new int[N];

    // Check if queen can be placed
    static boolean isSafe(int row, int col) {

        for(int i = 0; i < row; i++) {

            int qCol = board[i];

            // Same column or diagonal
            if(qCol == col ||
               Math.abs(qCol - col) ==
               Math.abs(i - row)) {

                return false;
            }
        }

        return true;
    }

    // Backtracking
    static boolean solve(int row) {

        // All queens placed
        if(row == N) {
            return true;
        }

        for(int col = 0; col < N; col++) {

            System.out.println(
                "Trying Queen at Row " +
                row + " Col " + col
            );

            if(isSafe(row, col)) {

                board[row] = col;

                System.out.println(
                    "Placed Queen at Row " +
                    row + " Col " + col
                );

                if(solve(row + 1)) {
                    return true;
                }

                // Backtrack
                System.out.println(
                    "Backtracking from Row " +
                    row + " Col " + col
                );
            }
        }

        return false;
    }

    // Print Board
    static void printBoard() {

        System.out.println("\nSolution:");

        for(int i = 0; i < N; i++) {

            for(int j = 0; j < N; j++) {

                if(board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        if(solve(0))
            printBoard();
        else
            System.out.println("No Solution");
    }
}