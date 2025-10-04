import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class demo  implements ActionListener{

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JButton button= new JButton();

    demo(){
        buttonProperties();
        prepareGui();
    }

    public void prepareGui(){
        frame.setTitle("my window");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
  
    }
    
    public void buttonProperties(){
        button.setIcon(new ImageIcon("C:\\Users\\Leysh\\Second year\\Java\\java-assignment-1\\card_face_down.jpg"));
        button.setPreferredSize(new java.awt.Dimension(200,300));
        button.addActionListener(this);
        panel.add(button);


    }

    public void actionPerformed(ActionEvent e){
        frame.setBackground(Color.BLUE);

    }

}
