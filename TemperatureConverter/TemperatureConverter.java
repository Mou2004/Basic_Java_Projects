package TemperatureConverter;

import java.util.Scanner;

public class TemperatureConverter {
    //Temperature Converter
    //Skills Covered: User input handling, basic math operations, optional GUI.
    //Description:
    //
    //Create an application that converts between Fahrenheit and Celsius.
    //For the console version, prompt the user to input a temperature value and the conversion direction.
    //For the GUI version, use JTextField for input and JLabel for the result.

    public static void main(String[] args) {
        System.out.println("Starting temperature converter");
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("press 1 to convert from C to F\n" +
                    "press 2 to convert from F to C\n" +
                    "press 3 to exit");

            if (!scanner.hasNextInt()){
                System.out.println("Please enter one of the integers");
                scanner.next(); //cancel invalid input
                continue;
            }
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                    case 1:
                        System.out.println("Enter temp in C");
                        float userC = scanner.nextFloat();

                        float result = (float) ((float) (userC*(9.0)/5.0) + 32.0);
                        System.out.println("Temp " +
                                userC +"'C in F is: "+ result);
                        continue;
                    case 2:
                        System.out.println("Enter temp in F");
                        float userF = scanner.nextFloat();
                        float resultinC = (float) ((float) ((userF-32)*(5.0)/9.0) );
                        
                        System.out.println("Temp " +
                                userF +"F in C is: "+ resultinC);
                        continue;
                    case 3:
                        System.out.println("Exiting..");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }




        }
    }
}
