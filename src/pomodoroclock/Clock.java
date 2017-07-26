package pomodoroclock;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Clock extends TimerTask
{
    private final Timer time = new Timer();
    private final PomodoroScreen screen;
    private final int pomodoro;
    private int minutes;
    
    public Clock(PomodoroScreen screen, int pomodoro)
    {
        time.schedule(this, 60000, 60000);
        
        this.screen = screen;
        this.pomodoro = pomodoro;
        minutes = 0;
    }
    
    @Override
    public void run() 
    {
        if(++minutes == pomodoro)
        {
            time.cancel();
        }
    }
}
