import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        char [][] board = {{' ',' ',' '},
                           {' ',' ',' '},
                           {' ',' ',' '},};
        printBoard(board);
        while(true) {
            playerMove(board);
            printBoard(board);
            if(IsGameEnd(board)) break;
            computerMove(board);
            printBoard(board);
            if(IsGameEnd(board)) break;
        }
    }

    // Checks if game is end or not and who won!
    private static boolean IsGameEnd(char[][] board) {

        if (hasConstantWon(board,'x')){
            System.out.println("Player wins!");
            return true;
        }
        if (hasConstantWon(board, '0')) {
            System.out.println("Computer wins!");
            return true;
        }

        for(int i=0;i<3;i++){
            for(int j=i;j<3;j++){
             if (board[i][j]==' ') return false;
            }
        }
        System.out.println("The game ended ub a tie!");
        return true;
    }

    // Winning conditions
    private static boolean hasConstantWon(char[][] board, char symbol) {
        if((board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol) ||
           (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol) ||
           (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol) ||

           (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol) ||
           (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol) ||
           (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol) ||

           (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol) ||
           (board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol)){
            return true;
        }
        return false;
    }

    // Takes User Input
    private static void playerMove(char[][] board) {
        Scanner sr = new Scanner(System.in);
        String userInput;
        while(true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = sr.nextLine();
            if (IsValidMove(board, Integer.parseInt(userInput))) break;
            else System.out.println(userInput+" is not a valid move");
        }
        placeMove(board, userInput,'x');
    }

    // Generate random number for computer
    private static void computerMove(char[][] board) {
        Random rd =new Random();
        int computerMove;
        while(true){
            computerMove=rd.nextInt(9)+1;
            if(IsValidMove(board,computerMove)) break;
        }
        System.out.println("Computer chose "+ computerMove);
        placeMove(board,Integer.toString(computerMove),'0');
    }

    // Checks the valid move and empty spaces
    private static boolean IsValidMove(char[][] board,int position){
        switch(position){
            case 1 : return (board[0][0]==' ');
            case 2 : return (board[0][1]==' ');
            case 3 : return (board[0][2]==' ');
            case 4 : return (board[1][0]==' ');
            case 5 : return (board[1][1]==' ');
            case 6 : return (board[1][2]==' ');
            case 7 : return (board[2][0]==' ');
            case 8 : return (board[2][1]==' ');
            case 9 : return (board[2][2]==' ');
            default : return false;
        }
    }

    // Marks Places with X or O
    private static void placeMove(char[][] board, String position,char symbol) {
        switch(position){
            case "1" -> board[0][0]=symbol;
            case "2" -> board[0][1]=symbol;
            case "3" -> board[0][2]=symbol;
            case "4" -> board[1][0]=symbol;
            case "5" -> board[1][1]=symbol;
            case "6" -> board[1][2]=symbol;
            case "7" -> board[2][0]=symbol;
            case "8" -> board[2][1]=symbol;
            case "9" -> board[2][2]=symbol;
            default -> System.out.println("sad");
        }
    }

    // Use to Print Board
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+ "|" + board[0][1]+ "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+ "|" + board[1][1]+ "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+ "|" + board[2][1]+ "|" + board[2][2]);
    }
}
