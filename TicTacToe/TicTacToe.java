package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        /*
         -1-  -2-  -3-
         -4-  -5-  -6-
         -7-  -8-  -9-

         each element of the board[] array represents a spot on the board
         */

        char[] board ={'1','2','3','4','5','6','7','8','9'};


        var numberOfSquaresPlayed = 0;
        var whoseTurnItIs ='x';


        while(numberOfSquaresPlayed<= 9){
            printTheBoard(board);
            System.out.printf("choose a square player %s", whoseTurnItIs, ": ");
            Scanner scanner = new Scanner(System.in);
            var input = scanner.nextInt();
            board[input-1] = whoseTurnItIs;
            if(
                                (board[0]+board[1]+board[2])==(whoseTurnItIs*3)
                            || (board[3] + board[4] + board[5] == (whoseTurnItIs * 3)) // second row
                            || (board[6] + board[7] + board[8] == (whoseTurnItIs * 3)) // third row
                            || (board[0] + board[3] + board[6] == (whoseTurnItIs * 3)) // first column
                            || (board[1] + board[4] + board[7] == (whoseTurnItIs * 3)) // second column
                            || (board[2] + board[5] + board[8] == (whoseTurnItIs * 3)) // third column
                            || (board[0] + board[4] + board[8] == (whoseTurnItIs * 3)) // first diagonal
                            || (board[2] + board[4] + board[6] == (whoseTurnItIs * 3)) // second diagonal

            )
            {    printTheBoard(board);
                System.out.printf("you won!! congratulations %s", whoseTurnItIs);
                break;
            }

            if (whoseTurnItIs=='x'){
                    whoseTurnItIs ='o';
                }
            else {
                    whoseTurnItIs ='x';
                }


        }



    }
    private static void printTheBoard(char[] board){
        System.out.println(board[0] + " - "+board[1]+ " - "+board[2]);
        //System.out.println( " -  -  - " );
        System.out.println( board[3] + " - " +  board[4] + " - " + board[5]);
        //System.out.println( " -  -  - " );
        System.out.println( board[6] + " - " +  board[7] + " - " + board[8]);
    }
}
