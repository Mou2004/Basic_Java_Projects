package GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
 //Skills Covered: Random number generation, loops, conditionals.
    //
    //Description:
    //
    //Create a game where the computer randomly generates a number between 1 and 100, and the user has to guess it.
    //After each guess, the program will tell the user if the guess is too high or too low until the user guesses correctly.
    //Steps:
    //
    //Generate a random number using Math.random() or Random class.
    //Prompt the user to guess the number and provide feedback if the guess is too high, too low, or correct.
    //Keep track of the number of guesses and display a message once the user guesses correctly.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: "+"you can press -1 to exit");
        Random random = new Random();
        int number = random.nextInt(1,101);
        System.out.println("heres the pc generated number:"+ number);
        while(true){
            try{
                int userInt = scanner.nextInt();
                if (userInt==-1){
                    System.out.println("Exiting game....The number was..."+ number);
                    break;
                }
                if (userInt==number){
                    break;
                }

                if (number!=userInt){
                    if(checkHigher(userInt, number)){
                        System.out.println("number is higher than required, enter again");
                    }
                    else {
                        System.out.println("number is lower than required, enter again");
                    }
                }




            } catch (Exception e) {
                System.out.println("invalid input!please input an integer");
                scanner.nextLine();

            }

        }
        System.out.println("congrats, that was the number");



    }

    public static boolean checkHigher(int number, int compare){
        if(number<compare){
            return false;
        }
        return true;
    }
}
