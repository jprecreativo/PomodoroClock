package pomodoroclock;

import java.awt.AWTException;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.NORMAL;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner.DefaultEditor;

public class PomodoroScreen extends Screen
{
    private Clock clock;
    private int secondsRemaining;
    private int minutes;
    private boolean makeBreak;
    private SystemTray tray;
    private final TrayIcon trayIcon;
    
    public PomodoroScreen() throws IOException 
    {
        initComponents();
        super.inicialize(420, 320, "Pomodoro Clock");
        
        // Load images:
        
        URL imgURL = this.getClass().getResource("Clock.png");
        JLabel picPomodoro = new JLabel(new ImageIcon(imgURL));
        
        picPomodoro.setBounds(0, 0, jp_image.getWidth(), jp_image.getHeight());
        jp_image.add(picPomodoro);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        imgURL = this.getClass().getResource("Pomodoro.jpg");
        trayIcon = new TrayIcon(tk.getImage(imgURL));
        
        // Put as "non-editable" the spinners:
        
        JFormattedTextField spinner = ((DefaultEditor) js_pomodoro.getEditor()).getTextField();
        spinner.setEditable(false);
        
        spinner = ((DefaultEditor) js_break.getEditor()).getTextField();
        spinner.setEditable(false);
    }
    
    /**
     * This method update seconds and minutes in GUI.
     * @param seconds Current seconds.
     * @param minutes Current minutes.
     */
    public void updateTime(int seconds, int minutes)
    {
        jl_seconds.setText(Integer.toString(seconds));
        jl_minutes.setText(Integer.toString(minutes));
    }
    
    /**
     * This method will be call when current Pomodoro or break had finished.
     */
    public void pomodoroBreakFinish()
    {
        jb_stop.setEnabled(false);
        jb_start.setEnabled(true);
        
        makeBreak = !makeBreak;
    }
    
    public void maximize()
    {
        this.setVisible(true);                                               
        this.toFront();
        tray.remove(trayIcon);
    }
    
    private MouseListener createTrayIconMouseListener()
    {
        MouseListener mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {

            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {

            }

            @Override
            public void mouseExited(MouseEvent e) 
            {

            }

            @Override
            public void mousePressed(MouseEvent e) 
            {

            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                if (e.isPopupTrigger()) 
                {
                    popupContextual.setLocation(e.getX(), e.getY());
                    popupContextual.setInvoker(popupContextual);
                    popupContextual.setVisible(true);
                }
            }
        };
        
        return mouseListener;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupContextual = new javax.swing.JPopupMenu();
        menuItemRestore = new javax.swing.JMenuItem();
        separator = new javax.swing.JSeparator();
        menuItemSalir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jl_minutes = new javax.swing.JLabel();
        jl_upperPoint = new javax.swing.JLabel();
        jl_lowerPoint = new javax.swing.JLabel();
        jl_seconds = new javax.swing.JLabel();
        jp_image = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jb_start = new javax.swing.JButton();
        jb_stop = new javax.swing.JButton();
        jb_reset = new javax.swing.JButton();
        jb_continue = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        js_pomodoro = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        js_break = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        menuItemRestore.setText("Restaurar");
        menuItemRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRestoreActionPerformed(evt);
            }
        });
        popupContextual.add(menuItemRestore);
        popupContextual.add(separator);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        popupContextual.add(menuItemSalir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                EstadoCambiado(evt);
            }
        });

        jl_minutes.setBackground(new java.awt.Color(0, 255, 255));
        jl_minutes.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_minutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_minutes.setText("0");
        jl_minutes.setOpaque(true);

        jl_upperPoint.setBackground(new java.awt.Color(0, 0, 0));
        jl_upperPoint.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_upperPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_upperPoint.setOpaque(true);

        jl_lowerPoint.setBackground(new java.awt.Color(0, 0, 0));
        jl_lowerPoint.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_lowerPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_lowerPoint.setOpaque(true);

        jl_seconds.setBackground(new java.awt.Color(0, 255, 255));
        jl_seconds.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_seconds.setText("0");
        jl_seconds.setOpaque(true);

        jp_image.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jp_imageLayout = new javax.swing.GroupLayout(jp_image);
        jp_image.setLayout(jp_imageLayout);
        jp_imageLayout.setHorizontalGroup(
            jp_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        jp_imageLayout.setVerticalGroup(
            jp_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jp_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_upperPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_lowerPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jl_seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jl_upperPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_lowerPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jp_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jb_start.setText("Start");
        jb_start.setFocusable(false);
        jb_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_startActionPerformed(evt);
            }
        });

        jb_stop.setText("Stop");
        jb_stop.setEnabled(false);
        jb_stop.setFocusable(false);
        jb_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_stopActionPerformed(evt);
            }
        });

        jb_reset.setText("Reset");
        jb_reset.setEnabled(false);
        jb_reset.setFocusable(false);
        jb_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_resetActionPerformed(evt);
            }
        });

        jb_continue.setText("Continue");
        jb_continue.setEnabled(false);
        jb_continue.setFocusable(false);
        jb_continue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_continueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_continue)
                .addGap(18, 18, 18)
                .addComponent(jb_start)
                .addGap(18, 18, 18)
                .addComponent(jb_stop)
                .addGap(18, 18, 18)
                .addComponent(jb_reset)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_start)
                    .addComponent(jb_stop)
                    .addComponent(jb_reset)
                    .addComponent(jb_continue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Duration of Pomodoro:");

        js_pomodoro.setModel(new javax.swing.SpinnerNumberModel(25, 10, 30, 1));
        js_pomodoro.setEditor(new javax.swing.JSpinner.NumberEditor(js_pomodoro, ""));
        js_pomodoro.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("minutes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Duration of break:");

        js_break.setModel(new javax.swing.SpinnerNumberModel(5, 5, 30, 1));
        js_break.setEditor(new javax.swing.JSpinner.NumberEditor(js_break, ""));
        js_break.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("minutes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(js_break)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(js_pomodoro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(js_pomodoro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(js_break, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_startActionPerformed
        
        jl_minutes.setText("0");
        jl_seconds.setText("0");
        
        if(!makeBreak)
            minutes = (int) js_pomodoro.getValue();
        
        else
            minutes = (int) js_break.getValue();
        
        clock = new Clock(this, trayIcon, minutes, 0, 0, false);
        
        jb_start.setEnabled(false);
        jb_stop.setEnabled(true);
    }//GEN-LAST:event_jb_startActionPerformed

    private void jb_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_stopActionPerformed
        
        clock.cancel();
        
        int currentMinutes = Integer.parseInt(jl_minutes.getText());
        int currentSeconds = Integer.parseInt(jl_seconds.getText());
        
        secondsRemaining = (minutes * 60) - (currentMinutes * 60) - currentSeconds;
        
        jb_stop.setEnabled(false);
        jb_continue.setEnabled(true);
        jb_reset.setEnabled(true);
    }//GEN-LAST:event_jb_stopActionPerformed

    private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_resetActionPerformed
        
        clock.cancel();
        
        jl_minutes.setText("0");
        jl_seconds.setText("0");
        
        jb_continue.setEnabled(false);
        jb_start.setEnabled(true);
        jb_stop.setEnabled(false);
        jb_reset.setEnabled(false);
    }//GEN-LAST:event_jb_resetActionPerformed

    private void jb_continueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_continueActionPerformed
       
        int currentMinutes = Integer.parseInt(jl_minutes.getText());
        int currentSeconds = Integer.parseInt(jl_seconds.getText());
        
        clock =  new Clock(this, trayIcon, secondsRemaining, currentSeconds, currentMinutes, true);

        jb_continue.setEnabled(false);
        jb_reset.setEnabled(false);
        jb_stop.setEnabled(true);
    }//GEN-LAST:event_jb_continueActionPerformed

    private void menuItemRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRestoreActionPerformed

        this.maximize();
    }//GEN-LAST:event_menuItemRestoreActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void EstadoCambiado(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_EstadoCambiado
        
        if (evt.getNewState() == ICONIFIED) 
        {
            this.setState(NORMAL);
            this.setVisible(false);

            if(SystemTray.isSupported()) 
            {
                tray = SystemTray.getSystemTray();
                trayIcon.setImageAutoSize(true);
                trayIcon.addMouseListener(this.createTrayIconMouseListener());
                trayIcon.addActionListener((ActionEvent e) -> {
                    menuItemRestoreActionPerformed(e);
                });

                try 
                {
                    tray.add(trayIcon);
                } 
                
                catch(AWTException e) 
                {
                    this.setVisible(true);
                } 
            } 
        }
    }//GEN-LAST:event_EstadoCambiado

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PomodoroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PomodoroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PomodoroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PomodoroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try 
                {
                    new PomodoroScreen().setVisible(true);
                } 
                
                catch (IOException ex) 
                {
                    
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jb_continue;
    private javax.swing.JButton jb_reset;
    private javax.swing.JButton jb_start;
    private javax.swing.JButton jb_stop;
    private javax.swing.JLabel jl_lowerPoint;
    private javax.swing.JLabel jl_minutes;
    private javax.swing.JLabel jl_seconds;
    private javax.swing.JLabel jl_upperPoint;
    private javax.swing.JPanel jp_image;
    private javax.swing.JSpinner js_break;
    private javax.swing.JSpinner js_pomodoro;
    private javax.swing.JMenuItem menuItemRestore;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JPopupMenu popupContextual;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
}
