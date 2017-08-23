package pomodoroclock;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class Screen extends JFrame 
{
    public void inicialize(int width, int height, String title)
    {
        URL imgURL = this.getClass().getResource("Pomodoro.jpg");
        ImageIcon icon = new ImageIcon(imgURL);
        
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(title);
        this.getContentPane().setBackground(Color.WHITE);
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }
}
