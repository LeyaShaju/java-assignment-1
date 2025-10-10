import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;


public class Game implements ActionListener{

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JButton[] buttons =new JButton[16];
    int numButtons = 16;
    String[] Fruits = {"Banana", "Orange", "Strawberry","Kiwi","Raspberry", "Apple", "Dragon fruit", "Mango"};
    Random random = new Random();
    String[] randomised_fruits = new String[16];

    Game(){
        assignPairs();
        buttonProperties();
        prepareGui();
    }

    private void assignPairs(){
        List<String> fruits_pairs = new ArrayList<>();
        for(String fruit : Fruits){
            fruits_pairs.add(fruit);
            fruits_pairs.add(fruit);
        }
        Collections.shuffle(fruits_pairs, random);
        for (int i = 0; i < numButtons; i++) {
            randomised_fruits[i] = fruits_pairs.get(i);
            
        }

    }

    public void prepareGui(){
        frame.setTitle("memory game");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,4,8,8));
        
        frame.add(panel);
        frame.setVisible(true);
  
    }
    
    public void buttonProperties(){
        for (int i = 0; i < numButtons; i++) {
            buttons[i] = new JButton("Button" +(i +1));
            buttons[i].setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\card_back.jpg"));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        
        panel.revalidate();
        panel.repaint();

        }


    }

    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton) e.getSource();

        for (int i = 0; i < numButtons; i++) {
            if (buttons[i] == clickedButton){
                String assigned_pair = randomised_fruits[i];
                System.out.println("button"+ (i+1) + "has been clicked" + "assigned fruit is " + assigned_pair);
                if(assigned_pair == "Banana"){
                    buttons[i].setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\banana_icon.png"));
                }
                else{
                buttons[i].setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\venice.jpeg"));
                }
            }
            
        }
    
        

    }

}
