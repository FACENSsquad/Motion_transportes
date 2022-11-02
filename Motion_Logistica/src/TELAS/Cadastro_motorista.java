
package TELAS;

import BEANS.Motorista;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Cadastro_motorista extends javax.swing.JFrame {

       
       
    public Cadastro_motorista() {
        initComponents();
    }
    
       private Connection conn;
       private Conexao conexao;
       
       Motorista motorista = new Motorista(); //acessar os atributos da classe Motorista
       
    
    public void Cadastrar_Motorista(Motorista motorista){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        
        motorista.setNome(Caixa_nome.getText());
        motorista.setTelefone(Caixa_telefone.getText());
        
        String sql = "insert into motorista(nome, telefone) values "
                   + "(?, ?)";
        
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, motorista.getNome());
            pst.setString(2, motorista.getTelefone());
           
            pst.execute();
            
            
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar motorista" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar motorista");
            
        } finally {
            this.conexao.fecha_mt();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
    
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Caixa_nome = new javax.swing.JTextField();
        Caixa_telefone = new javax.swing.JTextField();
        cadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jbutton1 = new javax.swing.JButton();
        descrição = new javax.swing.JLabel();
        BD_qtdMOTO = new javax.swing.JLabel();
        dash = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 450));
        jPanel2.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 110, 40, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Telefone:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 110, 60, 16);

        Caixa_nome.setBackground(java.awt.Color.white);
        Caixa_nome.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_nome.setAutoscrolls(false);
        Caixa_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_nome.setFocusable(false);
        Caixa_nome.setPreferredSize(new java.awt.Dimension(10, 19));
        jPanel2.add(Caixa_nome);
        Caixa_nome.setBounds(90, 110, 150, 20);

        Caixa_telefone.setBackground(java.awt.Color.white);
        Caixa_telefone.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_telefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Caixa_telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_telefone.setFocusable(false);
        Caixa_telefone.setPreferredSize(new java.awt.Dimension(10, 19));
        Caixa_telefone.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jPanel2.add(Caixa_telefone);
        Caixa_telefone.setBounds(370, 110, 150, 20);

        cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botaosalvar.png"))); // NOI18N
        cadastrar.setBorder(null);
        cadastrar.setBorderPainted(false);
        cadastrar.setContentAreaFilled(false);
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(cadastrar);
        cadastrar.setBounds(580, 390, 97, 38);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(645, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cadastro Motorista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 10, 645, 30);

        jbutton1.setBackground(new java.awt.Color(255, 255, 255));
        jbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botao_fechar.png"))); // NOI18N
        jbutton1.setBorder(null);
        jbutton1.setBorderPainted(false);
        jbutton1.setContentAreaFilled(false);
        jbutton1.setFocusable(false);
        jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbutton1);
        jbutton1.setBounds(660, 10, 31, 26);

        descrição.setForeground(new java.awt.Color(0, 0, 0));
        descrição.setText("Quantidade de motoristas cadastrados:");
        jPanel2.add(descrição);
        descrição.setBounds(80, 230, 200, 16);

        BD_qtdMOTO.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BD_qtdMOTO.setForeground(new java.awt.Color(0, 0, 0));
        BD_qtdMOTO.setText("150");
        jPanel2.add(BD_qtdMOTO);
        BD_qtdMOTO.setBounds(110, 260, 40, 30);

        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/dash_p.png"))); // NOI18N
        jPanel2.add(dash);
        dash.setBounds(80, 250, 100, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(716, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Cadastrar_Motorista(motorista);
    }//GEN-LAST:event_cadastrarActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbutton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Cadastro_motorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_motorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_motorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_motorista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_motorista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BD_qtdMOTO;
    private javax.swing.JTextField Caixa_nome;
    private javax.swing.JTextField Caixa_telefone;
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel dash;
    private javax.swing.JLabel descrição;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbutton1;
    // End of variables declaration//GEN-END:variables
}
