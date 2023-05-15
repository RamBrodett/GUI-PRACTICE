// Still under development.
// First time using java. Will poslish GUI and add more feature once i'm familiar with Java.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToeGame implements ActionListener{
    ImageIcon GameIcon = new ImageIcon("C:\\Users\\rmbro\\Documents\\JAVA PRACTICE\\TICTACTOE\\TicTacToe Game\\icons\\tIcon.png");
    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reset_button = new JButton("Reset");
    boolean Player1_Turn;

    TicTacToeGame(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setIconImage(GameIcon.getImage());

        text_field.setBackground(Color.black);
        text_field.setForeground(Color.WHITE);
        text_field.setFont(new Font("Arial", Font.BOLD,50));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,50,800,100);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.GRAY);
        reset_button.setFont(new Font("Arial",Font.PLAIN,40));
        reset_button.setFocusPainted(false);
        reset_button.addActionListener(e -> resetGame());

        for(int i =0; i<9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setForeground(Color.white);
            buttons[i].setBorderPainted(true);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
        }
        title_panel.add(text_field);
        title_panel.add(reset_button,BorderLayout.EAST);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);


        TurnFirst();
        for(int i =0; i<9; i++)
            buttons[i].setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(Player1_Turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.cyan);
                        buttons[i].setText("X");
                        Player1_Turn = false;
                        text_field.setText("O turn");
                        GameOver();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.MAGENTA);
                        buttons[i].setText("O");
                        Player1_Turn = true;
                        text_field.setText("X turn");
                        GameOver();
                    }
                }
            }
        }


    }

    public void TurnFirst(){
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        text_field.setText("Choosing who's first...");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            Player1_Turn=true;
            text_field.setText("X first!");
            text_field.setForeground(Color.GREEN);
        }
        else{
            Player1_Turn=false;
            text_field.setText("O first!");
            text_field.setForeground(Color.GREEN);
        }
    }
    public void GameOver(){

        if((buttons[0].getText().equals("X"))&&  //TOP ROW
            (buttons[1].getText().equals("X"))&&
            (buttons[2].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(0,1,2);

        }
        else if((buttons[3].getText().equals("X"))&& //MID ROW
            (buttons[4].getText().equals("X"))&&
            (buttons[5].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(3,4,5);

        }
        else if((buttons[6].getText().equals("X"))&& //BOT ROW
            (buttons[7].getText().equals("X"))&&
            (buttons[8].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(6,7,8);

        }
        else if((buttons[0].getText().equals("X"))&& //LEFT COL
            (buttons[3].getText().equals("X"))&&
            (buttons[6].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(0,3,6);

        }
        else if((buttons[1].getText().equals("X"))&& //MID COL
            (buttons[4].getText().equals("X"))&&
            (buttons[7].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(1,4,7);

        }
        else if((buttons[2].getText().equals("X"))&& //RIGHT COL
            (buttons[5].getText().equals("X"))&&
            (buttons[8].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(2,5,8);

        }
        else if((buttons[0].getText().equals("X"))&& //L-R DIAGONAL
            (buttons[4].getText().equals("X"))&&
            (buttons[8].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(0,4,8);

        }
        else if((buttons[2].getText().equals("X"))&& //R-L DIAGONAL
            (buttons[4].getText().equals("X"))&&
            (buttons[6].getText().equals("X"))){

            text_field.setText("X WINS!");
            GameWinnerA(2,4,6);

        }
        else if((buttons[0].getText().equals("O"))&&  //TOP ROW
            (buttons[1].getText().equals("O"))&&
            (buttons[2].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(0,1,2);

        }
        else if((buttons[3].getText().equals("O"))&& //MID ROW
            (buttons[4].getText().equals("O"))&&
            (buttons[5].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(3,4,5);

        }
        else if((buttons[6].getText().equals("O"))&& //BOT ROW
            (buttons[7].getText().equals("O"))&&
            (buttons[8].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(6,7,8);

        }
        else if((buttons[0].getText().equals("O"))&& //LEFT COL
            (buttons[3].getText().equals("O"))&&
            (buttons[6].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(0,3,6);

        }
        else if((buttons[1].getText().equals("O"))&& //MID COL
            (buttons[4].getText().equals("O"))&&
            (buttons[7].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(1,4,7);

        }
        else if((buttons[2].getText().equals("O"))&& //RIGHT COL
            (buttons[5].getText().equals("O"))&&
            (buttons[8].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(2,5,8);

        }
        else if((buttons[0].getText().equals("O"))&& //L-R DIAGONAL
            (buttons[4].getText().equals("O"))&&
            (buttons[8].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(0,4,8);

        }
        else if((buttons[2].getText().equals("O"))&& //R-L DIAGONAL
            (buttons[4].getText().equals("O"))&&
            (buttons[6].getText().equals("O"))){

            text_field.setText("O WINS!");
            GameWinnerB(2,4,6);

        }
        else{
            for(int i=0;i<9;i++){
                if(buttons[i].getText().equals(""))
                    i=10;
                else if(i==8){
                    text_field.setText("TIE");
                    for(int x=0;x<9;x++)
                        buttons[x].setEnabled(false);
                }
            }
        }
    }
    public void GameWinnerA(int x,int y,int z){
        for(int i=0;i<9;i++){
            if(i==x||i==y||i==z)
                buttons[i].setForeground(Color.green);
            else
                buttons[i].setEnabled(false);
        }
    }
    public void GameWinnerB(int x,int y,int z){
        for(int i=0;i<9;i++){
            if(i==x||i==y||i==z)
                buttons[i].setForeground(Color.green);
            else
                buttons[i].setEnabled(false);
        }
    }
    public void resetGame(){
        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
            buttons[i].setText("");
        }
        TurnFirst();
        for(int i =0; i<9; i++)
            buttons[i].setEnabled(true);
    }
}
