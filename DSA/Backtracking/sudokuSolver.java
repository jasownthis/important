package Backtracking;

public class sudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(solver(board)){
            display(board);
        }
        else{
            System.out.println("Cannot solve this sudoku");
        }
    }
    static boolean isSafe(int[][] board, int row, int col, int num){

        // same row , all columns
        for(int i =0 ; i < board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        // same column, all rows
        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        // inside the cubic box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - (row % sqrt);
        int colStart = col - (col % sqrt);
        for(int r = rowStart ; r < rowStart + sqrt ; r++){
            for(int c = colStart; c < colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }

        return true;
    }
    static boolean solver(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean empty = true;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if(!empty){
                break;
            }
        }
        if(empty){
            return true;
        }

        for(int i = 1; i <= n; i++){
            if(isSafe(board, row, col, i)){
                board[row][col]  = i;
                if(solver(board)){
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void display(int[][] board){
        for(int[] nums : board){
            for(int element : nums){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
