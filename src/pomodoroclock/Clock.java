package pomodoroclock;

import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Clock extends TimerTask
{
    private final Timer time = new Timer();
    private final PomodoroScreen screen;
    private final TrayIcon trayIcon;
    private int pomodoro;
    private int seconds;
    private int minutes;
    private final boolean stop;
    
    private void timeOut() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        time.cancel();
        screen.pomodoroBreakFinish();
        
        Clip alarm = AudioSystem.getClip();
        URL alarmURL = this.getClass().getResource("Alarm.wav");

        alarm.open(AudioSystem.getAudioInputStream(alarmURL));
        alarm.start();
        
        Thread.sleep(2500);
        
        trayIcon.displayMessage("Pomodoro Clock", "Time out!", TrayIcon.MessageType.INFO);
        trayIcon.setToolTip("Time out!");
        screen.maximize();
    }
    
    public Clock(PomodoroScreen screen, TrayIcon trayIcon, int pomodoro, int seconds, int minutes, boolean stop)
    {
        time.schedule(this, 1000, 1000);
        
        this.screen = screen;
        this.trayIcon = trayIcon;
        this.pomodoro = pomodoro;
        this.stop = stop;
        this.seconds = seconds;
        this.minutes = minutes;
    }
    
    @Override
    public void run() 
    {                    
        trayIcon.setToolTip("" + minutes + " minutes, " + seconds + " seconds.");
        
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
                    try 
                    {
                        this.timeOut();
                    } 

                    catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException ex) 
                    {
                        
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
                    try 
                    {
                        this.timeOut();
                    } 

                    catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException ex) 
                    {
                        
                    }
            }
        }
    }
}
