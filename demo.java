import javax.swing.*;


public class demo {
    
    JFrame frame=new JFrame();

    demo(){
        prepareGui();
    }

    public void prepareGui(){
        frame.setTitle("my window");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(200,200,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
