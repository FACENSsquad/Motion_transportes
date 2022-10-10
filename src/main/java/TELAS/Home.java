
package TELAS;

/**
 *
 * @author Vinic
 */
public class Home extends javax.swing.JFrame {

    
    public void Contador(String placa, int tempo){
    
        String n_placa = placa;
        Informacao_placa.setName(n_placa);
        
        
        int tempo_v = tempo;
        
        
        
        while (tempo_v == 0) {            
            Informacao_placa.setVisible(false);
        }
            
            
           
        
    
    }
    
    
    public Home() {
        initComponents();
        Informacao_placa.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Status_transito = new javax.swing.JButton();
        Status_coletando = new javax.swing.JButton();
        Status_destino = new javax.swing.JButton();
        Status_descarga1 = new javax.swing.JButton();
        Status_descarga2 = new javax.swing.JButton();
        Status_descarga3 = new javax.swing.JButton();
        Status_descarga = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        veiculos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Informacao_placa = new javax.swing.JLabel();
        transito = new javax.swing.JPanel();
        coletando = new javax.swing.JPanel();
        destino = new javax.swing.JPanel();
        descarga = new javax.swing.JPanel();
        finalizado = new javax.swing.JPanel();
        alerta = new javax.swing.JPanel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 44));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Usuario:");

        usuario.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        usuario.setForeground(new java.awt.Color(51, 51, 51));
        usuario.setText("teste");

        logo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 0, 0));
        logo.setText("MotiON");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Botao_menu.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(logo)
                .addGap(516, 516, 516)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1280, 44);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 55));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 55));

        Status_transito.setBackground(new java.awt.Color(255, 255, 255));
        Status_transito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_veiculos.png"))); // NOI18N
        Status_transito.setBorderPainted(false);
        Status_transito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_transitoActionPerformed(evt);
            }
        });

        Status_coletando.setBackground(new java.awt.Color(255, 255, 255));
        Status_coletando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_coletando.png"))); // NOI18N
        Status_coletando.setBorderPainted(false);

        Status_destino.setBackground(new java.awt.Color(255, 255, 255));
        Status_destino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_coletando.png"))); // NOI18N
        Status_destino.setBorderPainted(false);

        Status_descarga1.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_destino.png"))); // NOI18N
        Status_descarga1.setBorderPainted(false);

        Status_descarga2.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_descarga.png"))); // NOI18N
        Status_descarga2.setBorderPainted(false);
        Status_descarga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_descarga2ActionPerformed(evt);
            }
        });

        Status_descarga3.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_finalizado.png"))); // NOI18N
        Status_descarga3.setBorderPainted(false);

        Status_descarga.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Status_alerta.png"))); // NOI18N
        Status_descarga.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Status_transito, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Status_coletando, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Status_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Status_descarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(Status_descarga2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Status_descarga3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Status_descarga, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Status_descarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_coletando, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status_destino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_transito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 54, 1280, 55);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1280, 55));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 695));
        jPanel3.setLayout(null);

        veiculos.setBackground(new java.awt.Color(255, 255, 255));
        veiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Botao_addPlaca.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusCycleRoot(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Informacao_placa.setText("PLACA");

        javax.swing.GroupLayout veiculosLayout = new javax.swing.GroupLayout(veiculos);
        veiculos.setLayout(veiculosLayout);
        veiculosLayout.setHorizontalGroup(
            veiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(veiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Informacao_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        veiculosLayout.setVerticalGroup(
            veiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(veiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(veiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Informacao_placa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(641, Short.MAX_VALUE))
        );

        jPanel3.add(veiculos);
        veiculos.setBounds(0, 0, 216, 680);

        transito.setBackground(new java.awt.Color(255, 255, 255));
        transito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout transitoLayout = new javax.swing.GroupLayout(transito);
        transito.setLayout(transitoLayout);
        transitoLayout.setHorizontalGroup(
            transitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        transitoLayout.setVerticalGroup(
            transitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(transito);
        transito.setBounds(216, 0, 175, 680);

        coletando.setBackground(new java.awt.Color(255, 255, 255));
        coletando.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout coletandoLayout = new javax.swing.GroupLayout(coletando);
        coletando.setLayout(coletandoLayout);
        coletandoLayout.setHorizontalGroup(
            coletandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        coletandoLayout.setVerticalGroup(
            coletandoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(coletando);
        coletando.setBounds(391, 0, 175, 680);

        destino.setBackground(new java.awt.Color(255, 255, 255));
        destino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout destinoLayout = new javax.swing.GroupLayout(destino);
        destino.setLayout(destinoLayout);
        destinoLayout.setHorizontalGroup(
            destinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        destinoLayout.setVerticalGroup(
            destinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(destino);
        destino.setBounds(566, 0, 175, 680);

        descarga.setBackground(new java.awt.Color(255, 255, 255));
        descarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout descargaLayout = new javax.swing.GroupLayout(descarga);
        descarga.setLayout(descargaLayout);
        descargaLayout.setHorizontalGroup(
            descargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        descargaLayout.setVerticalGroup(
            descargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(descarga);
        descarga.setBounds(741, 0, 175, 680);

        finalizado.setBackground(new java.awt.Color(255, 255, 255));
        finalizado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout finalizadoLayout = new javax.swing.GroupLayout(finalizado);
        finalizado.setLayout(finalizadoLayout);
        finalizadoLayout.setHorizontalGroup(
            finalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        finalizadoLayout.setVerticalGroup(
            finalizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(finalizado);
        finalizado.setBounds(916, 0, 175, 680);

        alerta.setBackground(new java.awt.Color(255, 255, 255));
        alerta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(189, 189, 189)));

        javax.swing.GroupLayout alertaLayout = new javax.swing.GroupLayout(alerta);
        alerta.setLayout(alertaLayout);
        alertaLayout.setHorizontalGroup(
            alertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        alertaLayout.setVerticalGroup(
            alertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );

        jPanel3.add(alerta);
        alerta.setBounds(1090, 0, 190, 680);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 1280, 685);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Status_transitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_transitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_transitoActionPerformed

    private void Status_descarga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_descarga2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_descarga2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Informacao_placa;
    private javax.swing.JButton Status_coletando;
    private javax.swing.JButton Status_descarga;
    private javax.swing.JButton Status_descarga1;
    private javax.swing.JButton Status_descarga2;
    private javax.swing.JButton Status_descarga3;
    private javax.swing.JButton Status_destino;
    private javax.swing.JButton Status_transito;
    private javax.swing.JPanel alerta;
    private javax.swing.JPanel coletando;
    private javax.swing.JPanel descarga;
    private javax.swing.JPanel destino;
    private javax.swing.JPanel finalizado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel transito;
    private javax.swing.JLabel usuario;
    private javax.swing.JPanel veiculos;
    // End of variables declaration//GEN-END:variables
}
