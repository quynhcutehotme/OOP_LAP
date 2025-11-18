package OOP;

import javax.swing.*;
import java.awt.*;

public class Q3 extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int j = height;
        g.setColor(Color.decode("#B37BB3"));
        for (int i = 0; i<=width; i+=15){
            g.drawLine(0, 0, i, j);
            j-=15;}
        j = height;
        for (int i = 0; i<=width; i+=15){
            g.drawLine(width, height, i, j);
            j-=15;}
        j = height;
        for (int i = width; i>=0; i-=15){
            g.drawLine(0, height,i, j);
            j-=15;}
        j = height;
        for (int i = width; i>=0; i-=15){
            g.drawLine(width, 0,i, j);
            j-=15;}


    }


    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q3 panel = new Q3();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400,400);
        window.setVisible(true);
    }}

