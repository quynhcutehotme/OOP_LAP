package OOP;

import javax.swing.*;
import java.awt.*;

public class Q6 extends JPanel{
    protected void paintComponent(Graphics g) {
        int arcsToDraw =12;
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        for (int i = 0; i < arcsToDraw; i++) {
            int radius =10+ i * 10;
            g.drawArc(centerX - radius, centerY - radius,
                    radius*2,  radius*2,
                    0, 360);
        }}


    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q6 panel = new Q6();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400,400);
        window.setVisible(true);
    }
}
