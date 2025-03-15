package calculator;

import java.util.Scanner;

public class calculatorTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //defining the variables
        while (true){
            try {
                System.out.println("Enter two numbers and an operator (+, -, *, /) or type 'exit' to quit.");
                if (scanner.nextLine().equalsIgnoreCase("exit")){
                    System.out.println("okay....Exiting calculator....");
                    break;
                }
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                String operator = scanner.next();
                switch (operator){
                    case "+":
                        System.out.println(add(a,b)); break;

                    case "-":
                        System.out.println(subtract(a,b)); break;

                    case "*":
                        System.out.println(multiply(a,b)); break;

                    case "/":
                        System.out.println(divide(a,b));
                        if (b == 0) {
                            System.out.println("Error: Division by zero is not allowed!");break;
                        } else {
                            System.out.println("Result: " + divide(a, b)); break;
                        }

                    default:
                        System.out.println("Invalid operator! Please try again.");
                }


            }
            catch (NumberFormatException e) {
                System.out.println("Error: Invalid number input! Please enter valid numbers...");
                scanner.nextLine(); // Clear invalid input
            }
            catch (Exception e){
                System.out.println("Error: something went wrong. Please try again...");

            }

        }

    }
    public static double  add(double a, double b){
        return a+b;
    }
    public static double  subtract(double a, double b){
        return a-b;
    }
    public static double  multiply(double a, double b){
        return a*b;
    }
    public static double  divide(double a, double b){

        return a/b;
    }
}
