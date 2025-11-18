package OOP;
import javax.swing.JOptionPane;

public class jOption
{
        public static void main(String[] args) {
            String name = JOptionPane.showInputDialog(null,
                    "What is your name?",
                    "Input",
                    JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(null,
                    "Welcome, " + name + ", to Java Programming!",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

