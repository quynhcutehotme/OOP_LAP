package OOP;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Q8 extends JPanel{
    int[] numbers = new int[5];
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int y=30;
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            g.setColor(color);
            g.fillRect(0,y,numbers[i]*10,20);
            y+=30;

        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        Q8 panel = new Q8();

        for (int i = 0; i < 5; i++) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "Enter the length of bar " + (i + 1) + ":",
                    "Input",
                    JOptionPane.QUESTION_MESSAGE
            );
            panel.numbers[i] = Integer.parseInt(input);}

        window.add(panel);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(200,240);
        window.setVisible(true);


    }
}

