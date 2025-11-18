package OOP;

import javax.swing.*;
import java.awt.*;

public class Q9 extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.decode("#FF6DAA"));
        g.fillOval(getWidth()/2-30,getHeight()/2-30,100,100);

        g.setColor(Color.decode("#2B06FF"));
        g.fillOval(getWidth()/2-30,getHeight()/2-30,130,130);

        g.setColor(Color.decode("#FF6DAA"));
        g.fillOval(getWidth()/2-30,getHeight()/2-30,100,100);

        g.setColor(Color.decode("#FF6DAA"));
        g.fillOval(getWidth()/2-30,getHeight()/2-30,100,100);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q9 panel = new Q9();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400,400);
        window.setVisible(true);
    }
}
