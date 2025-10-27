import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import jdk.jfr.Enabled;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Game implements ActionListener{

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JButton[] buttons =new JButton[16];
    int numButtons = 16;
    String[] Fruits = {"Banana", "Orange", "Blueberry","Kiwi","Raspberry", "Apple", "Dragon fruit", "Mango"};
    Random random = new Random();
    String[] randomised_fruits = new String[16];
    private  JButton FirstCard = null;
    private JButton SecondCard = null;
    private int CardsFlipped = 0;
    private Timer cardFlipTimer;
    private int pairs = 0;



    Game(){
        assignPairs();
        setupTimer();
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
        if (!clickedButton.isEnabled() || (FirstCard != null && SecondCard != null)) {
        return;
        }   
        
        int ButtonIndex = getIndex(clickedButton);
        if (ButtonIndex == -1) return;

        String assigned_pair = randomised_fruits[ButtonIndex];
        System.out.println("Button " + (ButtonIndex + 1) + " has been clicked. Assigned fruit is " + assigned_pair);    

            FlipCard(clickedButton, assigned_pair);
            CardsFlipped ++;

            if (FirstCard == null){
                FirstCard = clickedButton;
            }

            else{
                SecondCard = clickedButton;
            }

            String fruit1 = randomised_fruits[getIndex(FirstCard)];
            String fruit2 = randomised_fruits[getIndex(SecondCard)];

            if (fruit1 == fruit2){
                pairs ++;
                System.out.println("Its a Match" + fruit1);
                FirstCard.setEnabled(false);
                SecondCard.setEnabled(false);
                CheckWin();

                FirstCard = null;
                SecondCard = null;
            }

            else{
                System.out.println("Its Not a match");
                cardFlipTimer.start();
            }

        }         

    
    // so that they can longer be clicked once matched
    private void ButtonsEnabled(boolean Enabled){
        for (JButton button : buttons){
            if(button.isEnabled() || Enabled){
                button.setEnabled(Enabled);
            }
        }
    }

    private int getIndex(JButton button){
        for (int i = 0; i < numButtons;i++){
            if(buttons[i]== button){
                return i;
            }
            
        }
        return -1;
    }

    private void CheckWin(){
        if (pairs == 8){
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                    JOptionPane.showMessageDialog(null, "YOU WON WELL DONE" + CardsFlipped + " Moves were made");
                }
            });
        }    
    }
    /**
 * Sets the icon of a button based on the assigned fruit.
 */
private void FlipCard(JButton button, String fruitName) {
        // You should use .equals() here too!
        switch (fruitName) {
            case "Banana" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\banana_icon.png"));
            case "Blueberry" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Blueberry_icon.jpeg"));
            case "Kiwi" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Kiwi_icon.png"));
            case "Raspberry" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Raspberry_icon - Copy.png"));
            case "Dragon fruit" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\DragonFruit_icon.png"));
            case "Mango" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Mango_icon.jpeg"));
            case "Orange" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Orange_icon.png"));
            case "Apple" -> button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\Apple_icon.jpeg"));
            default -> {
            }
        }
    // Also remove the temporary "ButtonX" text when showing the icon
    button.setText(""); 
}

private final String CARD_BACK_PATH = "C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\card_back.jpg";
private void setupTimer() {
    // A timer that waits 1000 milliseconds (1 second) before performing an action
    cardFlipTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // This code runs when the timer finishes
            
            // 1. Flip the non-matching cards back over (show the card back icon)
            if (FirstCard != null) {
                FirstCard.setIcon(new ImageIcon(CARD_BACK_PATH));
                FirstCard.setEnabled(true); // Re-enable the button for a future turn
            }
            if (SecondCard != null) {
                SecondCard.setIcon(new ImageIcon(CARD_BACK_PATH));
            }
            
            // 2. Reset the tracking variables
            FirstCard = null;
            SecondCard = null;
            
            // 3. Stop the timer until the next mismatch
            cardFlipTimer.stop();
        }
    });
    // Set to only run once per start
    cardFlipTimer.setRepeats(false); 
}

    




}
