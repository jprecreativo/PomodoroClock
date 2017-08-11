package pomodoroclock;

import java.io.IOException;

public class PomodoroClock 
{
    public static void main(String[] args) throws IOException 
    {
        PomodoroScreen pomodoroScreen = new PomodoroScreen();
        
        pomodoroScreen.setVisible(true);
    }  
}
