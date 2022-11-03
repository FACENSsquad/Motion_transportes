/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import BEANS.Destinatario;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinic
 */
public class Cadastro_cliente extends javax.swing.JFrame {

    

    public Cadastro_cliente() {
        initComponents();
    }

    private Connection conn;
    private Conexao conexao;
    
    Destinatario destinatario = new Destinatario();
    
    public void Cadastrar_Destino(Destinatario destinatario){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        destinatario.setNome(Cnpj.getText());
        destinatario.setEmail(Caixa_email.getText());
        destinatario.setDdd(Caixa_ddd.getText());
        destinatario.setTelefone(Caixa_telefone.getText());
        destinatario.setEndereco(Caixa_endereco.getText());
        destinatario.setCidade(Caixa_cidade.getText());
        destinatario.setCnpj(Cnpj.getText());
        destinatario.setUf((String) Box_estado.getSelectedItem());
        
   
       
        String sql = "insert into cliente(cnpj, nome_fantasia, endereco, uf,"
                + " cidade, ddd, telefone, email) values(?, ?, ?, ?, ?, ?, ?, ?) ";
        
        
        try {
            
            PreparedStatement pst = this.conn.prepareStatement(sql);
           pst.setString(1, destinatario.getCnpj());
           pst.setString(2, destinatario.getNome());
           pst.setString(3, destinatario.getEndereco());
           pst.setString(4, destinatario.getUf());
           pst.setString(5, destinatario.getCidade());
           pst.setString(6, destinatario.getDdd());
           pst.setString(7, destinatario.getTelefone());
           pst.setString(8, destinatario.getEmail());
            
           
           pst.execute();
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar destinatario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao destinatario");
            
        } finally {
            
            this.conexao.fecha_mt();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbutton1 = new javax.swing.JButton();
        Cnpj = new javax.swing.JTextField();
        Caixa_endereco = new javax.swing.JTextField();
        Caixa_cidade = new javax.swing.JTextField();
        Caixa_ddd = new javax.swing.JTextField();
        Caixa_telefone = new javax.swing.JTextField();
        Caixa_email = new javax.swing.JTextField();
        Box_estado = new javax.swing.JComboBox<>();
        button_cadastrar = new javax.swing.JButton();
        RazãoSoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(645, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cadastro Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(270, 270, 270))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 645, 30);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Razão Soc:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 90, 60, 20);

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
        jPanel1.add(jbutton1);
        jbutton1.setBounds(660, 10, 31, 26);

        Cnpj.setBackground(new java.awt.Color(255, 255, 255));
        Cnpj.setForeground(new java.awt.Color(0, 0, 0));
        Cnpj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Cnpj.setFocusable(false);
        Cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CnpjActionPerformed(evt);
            }
        });
        jPanel1.add(Cnpj);
        Cnpj.setBounds(100, 90, 200, 20);

        Caixa_endereco.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_endereco.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_endereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_endereco.setFocusable(false);
        Caixa_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_enderecoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_endereco);
        Caixa_endereco.setBounds(420, 140, 200, 20);

        Caixa_cidade.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_cidade.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_cidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_cidade.setFocusable(false);
        Caixa_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cidadeActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_cidade);
        Caixa_cidade.setBounds(100, 140, 200, 20);

        Caixa_ddd.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_ddd.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_ddd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_ddd.setFocusable(false);
        Caixa_ddd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_dddActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_ddd);
        Caixa_ddd.setBounds(230, 190, 40, 20);

        Caixa_telefone.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_telefone.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_telefone.setFocusable(false);
        Caixa_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefoneActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_telefone);
        Caixa_telefone.setBounds(380, 190, 120, 20);

        Caixa_email.setBackground(new java.awt.Color(255, 255, 255));
        Caixa_email.setForeground(new java.awt.Color(0, 0, 0));
        Caixa_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        Caixa_email.setFocusable(false);
        Caixa_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_emailActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_email);
        Caixa_email.setBounds(100, 250, 200, 20);

        Box_estado.setBackground(new java.awt.Color(255, 255, 255));
        Box_estado.setForeground(new java.awt.Color(0, 0, 0));
        Box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "MG", "RJ", "PN" }));
        Box_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(Box_estado);
        Box_estado.setBounds(100, 190, 72, 22);

        button_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        button_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botaosalvar.png"))); // NOI18N
        button_cadastrar.setBorder(null);
        button_cadastrar.setBorderPainted(false);
        button_cadastrar.setContentAreaFilled(false);
        button_cadastrar.setFocusPainted(false);
        button_cadastrar.setFocusable(false);
        button_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(button_cadastrar);
        button_cadastrar.setBounds(580, 390, 100, 40);

        RazãoSoc.setBackground(new java.awt.Color(255, 255, 255));
        RazãoSoc.setForeground(new java.awt.Color(0, 0, 0));
        RazãoSoc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        RazãoSoc.setFocusable(false);
        RazãoSoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RazãoSocActionPerformed(evt);
            }
        });
        jPanel1.add(RazãoSoc);
        RazãoSoc.setBounds(420, 90, 200, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Endereço:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 140, 60, 20);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cnpj:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 90, 40, 20);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefone:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 190, 60, 20);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cidade:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 140, 40, 20);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 250, 30, 20);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DDD:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 190, 30, 20);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("UF:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 190, 20, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CnpjActionPerformed

    private void Caixa_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_cidadeActionPerformed

    private void Caixa_dddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_dddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_dddActionPerformed

    private void Caixa_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_telefoneActionPerformed

    private void Caixa_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_emailActionPerformed

    private void RazãoSocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RazãoSocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RazãoSocActionPerformed

    private void Caixa_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_enderecoActionPerformed

    private void Box_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_estadoActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
            this.setVisible(false);
    }//GEN-LAST:event_jbutton1ActionPerformed

    private void button_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cadastrarActionPerformed
        Cadastrar_Destino(destinatario);
    }//GEN-LAST:event_button_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Box_estado;
    private javax.swing.JTextField Caixa_cidade;
    private javax.swing.JTextField Caixa_ddd;
    private javax.swing.JTextField Caixa_email;
    private javax.swing.JTextField Caixa_endereco;
    private javax.swing.JTextField Caixa_telefone;
    private javax.swing.JTextField Cnpj;
    private javax.swing.JTextField RazãoSoc;
    private javax.swing.JButton button_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbutton1;
    // End of variables declaration//GEN-END:variables
}
