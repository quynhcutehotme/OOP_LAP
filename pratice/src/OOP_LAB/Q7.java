package OOP;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Q7 extends  JPanel{
    public Random rand = new Random();
    public final int shapeCount = 10;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i =0; i<=shapeCount;i++){
           boolean isRectangle = rand.nextBoolean();
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            g.setColor(color);

            int width = rand.nextInt(getWidth() / 2) + 1;
            int height = rand.nextInt(getHeight() / 2) + 1;
            int x = rand.nextInt(getWidth() - width);
            int y = rand.nextInt(getHeight()-height);

            if (isRectangle){
                g.fillRect(x,y,width,height);
            }
            else {g.fillOval(x,y,width,height);}
        }




    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q7 panel = new Q7();
        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(400, 400);
        window.setVisible(true);
    }
}
