package OOP;

import javax.swing.*;
import java.awt.*;

public class Q4 extends JPanel {
    public void paintComponent(Graphics g){
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            int steps = 15;

            int xDelta = width / steps;
            int yDelta = height / steps;
            int i = 0;

            g.setColor(Color.decode("#B37BB3"));

            while (i <= steps) {
                int yLeft = i * yDelta;
                int xBottom = (i + 1) * xDelta;
                g.drawLine(0, yLeft, xBottom, height);
                g.drawLine(width, height - yLeft, width - xBottom, 0);
                g.drawLine(0, height - yLeft, xBottom, 0);
                g.drawLine(width, yLeft, width - xBottom, height);
                i++;
            }


    }


    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q4 panel = new Q4();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400,400);
        window.setVisible(true);
    }
}
