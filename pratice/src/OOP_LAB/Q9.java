package OOP;

import javax.swing.*;
import java.awt.*;

public class Q9 extends JPanel {

    public Q9(){this.setBackground(Color.white);}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int maxRadius = Math.min(centerX, centerY) - 20;

        Color[] colors = {Color.decode("#FFD8E8"), Color.decode("#FEEAF4"), Color.decode("#FFD8E8"), Color.decode("#FEEAF4"), Color.decode("#FFD8E8")};

        for (int i = 0; i < 5; i++) {
            int radius = maxRadius - (i * (maxRadius / 5));
            int diameter = radius * 2;
            g.setColor(colors[i]);
            g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
        }

        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.BOLD, 69));
        g.drawString("❤", centerX-34, centerY + 30);

        g.setColor(Color.decode("#FFD8E8"));
        g.setFont(new Font("SansSerif", Font.BOLD, 50));
        g.drawString("❤", centerX - 25, centerY + 23);

        g.setColor(Color.decode("#E66A8A"));
        g.setFont(new Font("SansSerif", Font.BOLD, 35));
        g.drawString("❤", centerX - 17, centerY + 18);


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


