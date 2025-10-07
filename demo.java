import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class demo implements ActionListener{

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JButton[] buttons =new JButton[16];
    int numButtons = 16;

    demo(){
        buttonProperties();
        prepareGui();
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

        for(int i = 0; i < numButtons; i++){
            if(buttons[i] == clickedButton){
                System.out.println("button" + (i+1) + "has been clicked");
            }
        }

    }

}
