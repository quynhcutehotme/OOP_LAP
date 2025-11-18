package OOP;

import javax.swing.*;
import java.awt.*;

public class Q5b extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int step = 10;
        int arcs = 15;

        for (int i = 0; i < arcs; i++) {
            int radius = (i + 1) * step;
            if (i % 2 == 0) {
                g.drawArc(centerX - radius, centerY - radius,
                        2 * radius, 2 * radius, 0, 180);
            } else {
                int shiftX = centerX - step;
                g.drawArc(shiftX - radius, centerY - radius,
                        2 * radius, 2 * radius, 180, 180);
            }
        }
    }

        public static void main(String[] args) {
        JFrame window = new JFrame();
        Q5b panel = new Q5b();
        window.setSize(400,400);
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }}


