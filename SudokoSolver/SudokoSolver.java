public class SudokoSolver {
    //defining the size of the grid separately
    private static final int Grid_Size = 9;

    public static void main(String[] args) {

        //to print the board we are going use a 2D array
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Solution found");
        }
        else {
            System.out.println("No solution found");
        }
        printBoard(board);

    }

    //defining a method to check if that number already exists in the row
    private static boolean isNumberInRow(int[][] board, int numberToCheck, int row) {
        for (int i = 0; i < Grid_Size; i++) {
            if (board[row][i] == numberToCheck) {
                return true;
            }


        }
        return false;
    }

    private static boolean isNumberInCol(int[][] board, int numberToCheck, int col) {
        for (int i = 0; i < Grid_Size; i++) {
            if (board[i][col] == numberToCheck) {
                return true;
            }
        }
        return false;
    }

    //checking numbers within the small 3*3 grid
    private static boolean isNumberInSmallBox(int[][] board, int numberToCheck, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;
        //looping through each small square within the 3*3 board
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (board[i][j] == numberToCheck) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean isValidPlacement(int[][] board, int numberToCheck, int row, int col) {
        //if all the above methods return false, then it means the cell is a valid placement
        return !isNumberInRow(board, numberToCheck, row) &&
                !isNumberInCol(board, numberToCheck, col) &&
                !isNumberInSmallBox(board, numberToCheck, row, col);

    }

    //main method to solve the game that is going to use backtracking, recursion etc.
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < Grid_Size; row++) {
            for (int col = 0; col < Grid_Size; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry < Grid_Size; numberToTry++) {

                        if (isValidPlacement(board, numberToTry, row, col)) {
                            board[row][col] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    //method to print the board if solved

    private static void printBoard(int[][] board) {
        for (int row = 0; row < Grid_Size; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
                for (int col = 0; col < Grid_Size; col++) {
                    if (col % 3 == 0 && col != 0) {
                        System.out.print("|");
                    }
                    System.out.print(board[row][col]);
                }

            }
            System.out.println();
        }
    }
}