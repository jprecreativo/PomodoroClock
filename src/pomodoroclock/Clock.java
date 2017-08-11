package pomodoroclock;

import java.util.Timer;
import java.util.TimerTask;

public class Clock extends TimerTask
{
    private final Timer time = new Timer();
    private final PomodoroScreen screen;
    private int pomodoro;
    private int seconds;
    private int minutes;
    private final boolean stop;
    
    public Clock(PomodoroScreen screen, int pomodoro, int seconds, int minutes, boolean stop)
    {
        time.schedule(this, 1000, 1000);
        
        this.screen = screen;
        this.pomodoro = pomodoro;
        this.stop = stop;
        this.seconds = seconds;
        this.minutes = minutes;
    }
    
    @Override
    public void run() 
    {
        if(!stop)
        {
            /* In this case, user never stops the clock. Field 'Pomodoro' indicates Pomodoro duration or break time
               in minutes.*/
            
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
                    screen.pomodoroBreakFinish();

                    // Aquí se mostraría un mensaje en la bandeja del sistema.
                }
            }
        }
        
        else
        {
            // In this case, field 'Pomodoro' indicates seconds remaining.
            
            pomodoro--;
            seconds++;
            
            if(seconds < 60)
                screen.updateTime(seconds, minutes);

            else
            {
                seconds = 0;
                minutes++;

                screen.updateTime(seconds, minutes);

                if(0 == pomodoro)
                {
                    time.cancel();
                    screen.pomodoroBreakFinish();

                    // Aquí se mostraría un mensaje en la bandeja del sistema.
                }
            }
        }
    }
}
