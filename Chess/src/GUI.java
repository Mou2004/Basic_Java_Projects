import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GUI {
    //basic JFrame window to display the board
    JFrame frame;
    JPanel panel;
    int[][] grid = new int[8][8];
    ImageIcon whitePawn = new ImageIcon(getClass().getResource("white-pawn.png"));
    ImageIcon blackPawn = new ImageIcon(getClass().getResource("black-pawn.png"));
    ImageIcon whiteBishop = new ImageIcon(getClass().getResource("white-bishop.png"));
    ImageIcon blackBishop = new ImageIcon(getClass().getResource("black-bishop.png"));
    ImageIcon whiteKing = new ImageIcon(getClass().getResource("white-king.png"));
    ImageIcon blackKing = new ImageIcon(getClass().getResource("black-king.png"));
    ImageIcon whiteRook = new ImageIcon(getClass().getResource("white-rook.png"));
    ImageIcon blackRook = new ImageIcon(getClass().getResource("black-rook.png"));
    ImageIcon whiteKnight = new ImageIcon(getClass().getResource("white-knight.png"));
    ImageIcon blackKnight = new ImageIcon(getClass().getResource("black-knight.png" ));
    ImageIcon blackQueen = new ImageIcon(getClass().getResource("black-queen.png"));
    ImageIcon whiteQueen = new ImageIcon(getClass().getResource("white-queen.png"));
    ImageIcon selectedPiece=null;
    int selectedRow=-1;
    int selectedCol=-1;
    boolean iswhite =true;//to keep track of turns
    JButton buttons[][] = new JButton[8][8];
    public GUI(){
        this.frame = new JFrame();
        frame.setSize(800,800);
        panel = new JPanel();
        panel.setSize(800,800);
        panel.setLayout(new GridLayout(8,8,2,2));
        //iterating through each square of the board array to asign each square colors and pieces
        for (int i=0;i<grid.length;i++){

            for(int j=0;j<grid[i].length;j++){
                JButton button = new JButton(String.valueOf(i)+" , "+String.valueOf(j));

                panel.add(button);
                buttons[i][j]=button;
                setBoard(i,j, button);
                setPieces(i,j,button);
                final int row = i;
                final int col =j;
                button.addActionListener(e ->handleClick(row,col) );

            }
        }
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    void handleClick(int row, int col){
        JButton clickedButton = buttons[row][col];
        // If no piece is selected, select one
        if (selectedPiece == null && clickedButton.getIcon() != null) {
            selectedPiece = (ImageIcon) clickedButton.getIcon();
            selectedRow = row;
            selectedCol = col;
            clickedButton.setBackground(Color.YELLOW); // Highlight selection
        }
        // If a piece is selected, move it
        else if (selectedPiece != null) {
            movePiece(row, col);
        }
    }


    private void movePiece(int row, int col) {
        // Ensure the destination is empty
        if (buttons[row][col].getIcon() == null) {
            // Move the piece
            buttons[row][col].setIcon(selectedPiece);
            buttons[selectedRow][selectedCol].setIcon(null);
        }

        // Reset selection
        buttons[selectedRow][selectedCol].setBackground((selectedRow + selectedCol) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
        selectedPiece = null;
        selectedRow = -1;
        selectedCol = -1;
    }

    public void setBoard(int i, int j, JButton button) {
        //setting up the colours of the board in alternate squares
        if ((i + j) % 2 == 0) {
            button.setBackground(Color.LIGHT_GRAY);
        }
        if ((i + j) % 2 != 0) {
            button.setBackground(Color.DARK_GRAY);
        }


    }
    public void setPieces(int i, int j, JButton button){
        //seting piece icons in first row
        if (i == 0) {
            switch (j) {
                case 0:
                    button.setIcon(blackRook);
                    break;
                case 1:
                    button.setIcon(blackKnight);
                    break;
                case 2:
                    button.setIcon(blackBishop);
                    break;
                case 3:
                    button.setIcon(blackQueen);
                    break;
                case 4:
                    button.setIcon(blackKing);
                    break;
                case 5:
                    button.setIcon(blackBishop);
                    break;
                case 6:
                    button.setIcon(blackKnight);
                    break;
                case 7:
                    button.setIcon(blackRook);
                    break;
            }
        }

        if(i == 1) {
            button.setIcon(blackPawn);
        }
        if (i == 6) {
            button.setIcon(whitePawn);
        }
        //setting up piece icons in the last row

        if (i == 7) {
            switch (j) {
                case 0:
                    button.setIcon(whiteRook);
                    break;
                case 1:
                    button.setIcon(whiteKnight);
                    break;
                case 2:
                    button.setIcon(whiteBishop);
                    break;
                case 3:
                    button.setIcon(whiteQueen);
                    break;
                case 4:
                    button.setIcon(whiteKing);
                    break;
                case 5:
                    button.setIcon(whiteBishop);
                    break;
                case 6:
                    button.setIcon(whiteKnight);
                    break;
                case 7:
                    button.setIcon(whiteRook);
                    break;
            }

        }



    }

    public void setIndex(int i, int j, JButton button){
        List<String> alphabets = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");//for identifying chess-board index
        List<Integer> numbers = Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1);//for identifying chess-board index
        if (i==7){
            button.setText(alphabets.get(j));


        }
        if (j==0){
            button.setText(String.valueOf(numbers.get(i)));

        }

    }


}
