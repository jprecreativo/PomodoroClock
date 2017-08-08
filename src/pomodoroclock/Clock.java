package pomodoroclock;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class Clock extends TimerTask
{
    private final Timer time = new Timer();
    private final PomodoroScreen screen;
    private final int pomodoro;
    private int seconds;
    private int minutes;
    
    public Clock(PomodoroScreen screen, int pomodoro)
    {
        time.schedule(this, 0, 1000);
        
        this.screen = screen;
        this.pomodoro = pomodoro;
        
        seconds = 0;
        minutes = 0;
    }
    
    @Override
    public void run() 
    {
        seconds++;
        
        if(seconds < 60)
            screen.updateTime(seconds, minutes);
        
        else
        {
            seconds = 0;
            minutes++;
            
            screen.updateTime(seconds, minutes);
            
            if(minutes == pomodoro)
            {
                time.cancel();
                
                
            }
        }
    }
}
