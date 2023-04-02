package numberguess;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
 public class Numberguess extends javax.swing.JFrame {
    static JFrame game;
    static JLabel title,subtitle,hint,number,score1,score2,rule;
    static JTextField input;
    static JButton check;
    static int i=0,z;
    static String c;
    static int r,q,p;
    static Integer k;
    public Numberguess(){
        Random randomNumber =new Random();
        r =randomNumber.nextInt(50);
        q =randomNumber.nextInt(50);
        p=r+q;
        game = new JFrame("NUMBER GUESSING GAME");
        game.setSize(2000,2000);
        game.setLayout(null);
        game.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        title = new JLabel("<html><font color='blue'>NUMBER GUESSING GAME</font></html>");
       title.setBounds(450,50,800,80);
        Font f =new Font("serif",Font.BOLD,60);
        title.setFont(f);
        game.add(title);
        
         score1 =new JLabel("");
         score1.setBounds(1100,175,500,80);
         Font fe =new Font("Serif",Font.BOLD,40);
         score1.setFont(fe);
         game.add(score1);
         
         score2 =new JLabel("");
         score2.setBounds(1100,225,300,80);
         score2.setFont(fe);
         game.add(score2);
         
         rule =new JLabel("<html><font color='brown'>No.of attempts left 10</font></html>");
         rule.setBounds(400,225,450,80);
        rule.setFont(fe);
         game.add(rule);
         
         number =new JLabel("<html><font color='brown'>Choose a Number :</font></html>");
         number.setBounds(350,350,400,80);
         Font f1 =new Font("Serif",Font.BOLD,40);
        number.setFont(f1);
         game.add(number);
         
         subtitle =new JLabel("<html><font color='brown'>(1-100)</font></html>");
         subtitle.setBounds(430,410,400,80);
         Font f2 =new Font("Serif",Font.BOLD,30);
        subtitle.setFont(f2);
         game.add(subtitle);
         
         hint =new JLabel("");
         hint.setBounds(500,600,800,70);
        hint.setForeground(Color.BLUE);
        Font f3 =new Font("Serif",Font.BOLD,40);
        hint.setFont(f3);
         game.add(hint);
         
         input =new JTextField();
         input.setBounds(750,350,300,100);
        input.setFont(f1);
         game.add(input);
         
         check =new JButton("<html><font color='brown'>Check</font></html>");
        check.setBounds(1200,370,150,80);
       check.setFont(f1);
         game.add(check);
         
          check.addActionListener(new ActionListener(){
   
              public void actionPerformed(ActionEvent e) {
                  c =input.getText();
                  if(c.isEmpty()){
                      JOptionPane.showMessageDialog(null,"please Enter the choice");
                  }
                  else{
                      if(check()==1){
                          hint();
                      }
                  }
              }
              
              //private int check() {
                  //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             // }
          });
     game.setVisible(true);
     game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void hint(){
        i++;
        if(i<10){
            String cc =input.getText();
            Integer k = Integer.valueOf(cc);
            if(k<p){
                rule.setText("No.of Attempts left :"+String.valueOf(10-i));
                hint.setText("Hint : Number Entered is  LOWER");
            }
            else if(k>p){
                rule.setText("No.of Attempts left :"+String.valueOf(10-i));
                hint.setText("Hint : Number Entered is  HIGHER");
                
            }
            else{
                hint.setText("CONGRATULATIONS YOU WON  !!!");
                rule.setText("No.of Attempts left :"+String.valueOf(10-i));
                score1.setText("No.of attempts  left :"+String.valueOf(10-i));
                score2.setText("SCORE :"+String.valueOf(10-i));
                try{
                    int response =JOptionPane.showConfirmDialog(game,"Do you want to play again??","Confirm",JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                    if(response == JOptionPane.YES_NO_OPTION){
                        i=0;
                        Numberguess g =new Numberguess();
                    }   
                }catch(Exception e1){
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
                }
                
            }
        }
                
        else{
            JOptionPane.showMessageDialog(null,"OUT OF CHANCES!!");
              game.dispose();
        }
                
    } 
    public static int check(){
        try{
            k=Integer.valueOf(c);
            if(k<101 && k>0){
                z =1;
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter a number between 1-100");
            }
            
                
            }catch(NumberFormatException E){
                JOptionPane.showMessageDialog(null,"Enter an integer");
                z=0;
        }
        return z;
                
                
    }      
        
    }
    
 class Main extends javax.swing.JFrame{
    public static void main(String[] args){
        Numberguess gg =new Numberguess();
    }
    
}