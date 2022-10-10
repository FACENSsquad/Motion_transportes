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
public class Frame_cadastrarDestinatario extends javax.swing.JFrame {

    

    public Frame_cadastrarDestinatario() {
        initComponents();
    }

    private Connection conn;
    private Conexao conexao;
    
    Destinatario destinatario = new Destinatario();
    
    public void Cadastrar_Destino(Destinatario destinatario){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        destinatario.setNome(Caixa_cnpj.getText());
        destinatario.setEmail(Caixa_email.getText());
        destinatario.setDdd(Caixa_ddd.getText());
        destinatario.setTelefone(Caixa_telefone.getText());
        destinatario.setEndereco(Caixa_endereco.getText());
        destinatario.setCidade(Caixa_cidade.getText());
        destinatario.setCnpj(Caixa_cnpj.getText());
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

        Caixa_cnpj = new javax.swing.JTextField();
        Caixa_endereco = new javax.swing.JTextField();
        Caixa_cidade = new javax.swing.JTextField();
        Caixa_ddd = new javax.swing.JTextField();
        Caixa_telefone = new javax.swing.JTextField();
        Caixa_email = new javax.swing.JTextField();
        Box_estado = new javax.swing.JComboBox<>();
        Botton_cadastrar = new javax.swing.JButton();
        Caixa_nome1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Caixa_cnpj.setText("cnpj");
        Caixa_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cnpjActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_cnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        Caixa_endereco.setText("endereço");
        getContentPane().add(Caixa_endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        Caixa_cidade.setText("cidade");
        Caixa_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cidadeActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        Caixa_ddd.setText("ddd");
        Caixa_ddd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_dddActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_ddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        Caixa_telefone.setText("telefone");
        Caixa_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefoneActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        Caixa_email.setText("email");
        Caixa_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_emailActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        Box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "MG", "RJ", "PN" }));
        getContentPane().add(Box_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        Botton_cadastrar.setText("Confirmar");
        Botton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(Botton_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        Caixa_nome1.setText("nome");
        Caixa_nome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_nome1ActionPerformed(evt);
            }
        });
        getContentPane().add(Caixa_nome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 34, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Caixa_cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_cnpjActionPerformed

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

    private void Caixa_nome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_nome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_nome1ActionPerformed

    private void Botton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_cadastrarActionPerformed
        Cadastrar_Destino(destinatario);
    }//GEN-LAST:event_Botton_cadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_cadastrarDestinatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_cadastrarDestinatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_cadastrarDestinatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_cadastrarDestinatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_cadastrarDestinatario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botton_cadastrar;
    private javax.swing.JComboBox<String> Box_estado;
    private javax.swing.JTextField Caixa_cidade;
    private javax.swing.JTextField Caixa_cnpj;
    private javax.swing.JTextField Caixa_ddd;
    private javax.swing.JTextField Caixa_email;
    private javax.swing.JTextField Caixa_endereco;
    private javax.swing.JTextField Caixa_nome1;
    private javax.swing.JTextField Caixa_telefone;
    // End of variables declaration//GEN-END:variables
}
