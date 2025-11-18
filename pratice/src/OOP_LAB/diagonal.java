package OOP;

import javax.swing.*;
import java.awt.*;

public class diagonal extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
        g.drawLine(0, height/2, width, height/2);
        g.drawLine(width/2, 0, width/2, height);


        }


    public static void main(String[] args) {
        JFrame window = new JFrame();
        diagonal panel = new diagonal();
        window.add(panel);
        window.setResizable(true);
        window.setSize(400,400);
        window.setVisible(true);
    }}

