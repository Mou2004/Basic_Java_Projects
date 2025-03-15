package TemperatureConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverterGUI {
    //For the GUI version, use JTextField for input and JLabel for the result.
    //remaining-- implement logic to handle invalid user input in textfield- try catch in action perfomed when defining temp float
        private JFrame frame;
        private JTextField textField;
        private JLabel label;
        public TempConverterGUI(){
            this.frame = new JFrame();
            frame.setLayout(new GridBagLayout());
            frame.setSize(600,600);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.setVisible(true);

            //create gridBag constraints
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10,10,10,10);//adding padding between components

            //create label and add it to the top
            this.label = new JLabel("Enter temperature...");
            gbc.gridx =0; //Column 0
            gbc.gridy=0; //row 0
            gbc.gridwidth=2;//span two columns
            frame.add(label, gbc);

            this.textField = new JTextField(20);//20 columns wide
            gbc.gridx =0; //Column 0
            gbc.gridy=1; //row 0
            gbc.gridwidth=2;//span two columns
            textField.setText("Hello World");
            frame.add(textField, gbc);

            JButton CtoFButton = new JButton("Convert C to F");
            gbc.gridx =0; //Column 0
            gbc.gridy=3; //row 0
            gbc.gridwidth=1;//span one column
            CtoFButton.addActionListener(new ButtonClickListener());
            CtoFButton.setActionCommand("CtoF");
            frame.add(CtoFButton, gbc);

            JButton FtoCButton = new JButton("Convert F to C");
            gbc.gridx =2; //Column 0
            gbc.gridy=3; //row 0
            gbc.gridwidth=1;//span one column

            FtoCButton.addActionListener(new ButtonClickListener());
            FtoCButton.setActionCommand("FtoC");
            frame.add(FtoCButton, gbc);


        }

    public static void main(String[] args) {
        new TempConverterGUI();
    }

    public class ButtonClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            Float temperature = Float.parseFloat(textField.getText());
            if (command.equals("CtoF")){
                float resultinF = (float) ((float) (temperature*(9.0)/5.0) + 32.0);
                textField.setText(String.valueOf(resultinF));
            } else if (command.equals("FtoC")) {
                float resultinC = (float) ((float) ((temperature-32)*(5.0)/9.0) );
                textField.setText(String.valueOf(resultinC));
            }
        }
    }
}
