package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q5 extends JPanel {
    private int linesToDraw = 0;

    private Timer timer;

    public Q5() {

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linesToDraw++;
                if (linesToDraw > 20) {
                    timer.stop();
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int x = centerX;
        int y = centerY;

        int step = 20;
        int length = step;
        int direction = 0;

        for (int i = 0; i < linesToDraw; i++) {
            int newX = x;
            int newY = y;

            switch (direction) {
                case 0: newY += length; break;
                case 1: newX -= length; break;
                case 2: newY -= length; break;
                case 3: newX += length; break;
            }

            g.drawLine(x, y, newX, newY);

            x = newX;
            y = newY;

            direction = (direction + 1) % 4;

            if (i % 2 == 1) {
                length += step;
            }
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q5 panel = new Q5();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400, 400);
        window.setVisible(true);
    }

}
