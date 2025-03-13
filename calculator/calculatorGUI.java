package calculator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatorGUI {
    private JFrame frame;
    private JTextField textfield;
    private String currentInput ="";
    private double firstNum = 0;
    private String operator ="";
    public calculatorGUI(){
        frame = new JFrame("Calculator");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //display panel
        textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(800,200));
        textfield.setFont(new Font("Arial", Font.PLAIN, 30));
        textfield.setEditable(false);
        frame.add(textfield, BorderLayout.NORTH);

        //button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,10,10));

        //store buttons in a list so that its easier to create the individual buttons later on

        String[] buttons ={
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };
        for (String buttonName: buttons){
            JButton button = new JButton(buttonName);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);

        }
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new calculatorGUI();
    }
    public class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equalsIgnoreCase("c")){
                //clear the display
                currentInput ="";
                textfield.setText("currentInput");
                firstNum =0;
                operator="";

            }
            else if (command.equals("=")){
                //calculating the result
                double secondNum = Double.parseDouble(currentInput);
                switch (operator){
                    case "+":
                        firstNum+=secondNum;
                        break;
                    case "-":
                    firstNum -= secondNum;
                    break;
                    case "*":
                        firstNum *= secondNum;
                        break;
                    case "/":
                        if (secondNum != 0) {
                            firstNum /= secondNum;
                        } else {
                            textfield.setText("Error");
                            return;
                        }
                        break;
                    default:
                        break;
                }
                currentInput = String.valueOf(firstNum);
                textfield.setText(currentInput);
                operator="";

            }
            else if(command.equalsIgnoreCase("+") || command.equals("-") || command.equals("*") || command.equals("/")){
                // Store the first number and operator
                firstNum = Double.parseDouble(currentInput);
                operator = command;
                currentInput = "";
            }
           else{
               //append current number
                currentInput+= command;
                textfield.setText(currentInput);
            }
        }
    }


}
