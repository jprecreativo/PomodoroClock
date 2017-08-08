package pomodoroclock;

public class PomodoroScreen extends Screen
{
    private Clock clock;
    
    public PomodoroScreen() 
    {
        initComponents();
        super.inicialize(400, 300, "Pomodoro Clock");
        
        clock = new Clock(this, 3);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_minutes = new javax.swing.JLabel();
        jl_seconds = new javax.swing.JLabel();
        jl_upperPoint = new javax.swing.JLabel();
        jl_lowerPoint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_minutes.setBackground(new java.awt.Color(0, 255, 255));
        jl_minutes.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_minutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_minutes.setOpaque(true);

        jl_seconds.setBackground(new java.awt.Color(0, 255, 255));
        jl_seconds.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_seconds.setOpaque(true);

        jl_upperPoint.setBackground(new java.awt.Color(0, 0, 0));
        jl_upperPoint.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_upperPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_upperPoint.setOpaque(true);

        jl_lowerPoint.setBackground(new java.awt.Color(0, 0, 0));
        jl_lowerPoint.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jl_lowerPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_lowerPoint.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jl_minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_upperPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_lowerPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jl_seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jl_upperPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_lowerPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new PomodoroScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_lowerPoint;
    private javax.swing.JLabel jl_minutes;
    private javax.swing.JLabel jl_seconds;
    private javax.swing.JLabel jl_upperPoint;
    // End of variables declaration//GEN-END:variables
}
