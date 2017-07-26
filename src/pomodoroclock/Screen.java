package pomodoroclock;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class Screen extends JFrame 
{
    public void inicialize(int width, int height, String title)
    {
        ImageIcon icon = new ImageIcon("src/images/Pomodoro.jpg");
        
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(title);
        this.getContentPane().setBackground(Color.WHITE);
        this.setIconImage(icon.getImage());
    }
}
