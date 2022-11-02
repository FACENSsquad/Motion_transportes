/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import BEANS.LoginBean;
import DAO.LoginDao;
import java.sql.ResultSet;

/**
 *
 * @author eduar
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        senhaCampo = new javax.swing.JPasswordField();
        border_senha = new javax.swing.JPanel();
        email = new javax.swing.JLabel();
        loginCampo = new javax.swing.JTextField();
        entrar = new javax.swing.JButton();
        border_email = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(226, 226, 226));
        setPreferredSize(new java.awt.Dimension(440, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        logo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        logo.setText("MotiON");
        jPanel1.add(logo);
        logo.setBounds(179, 66, 86, 38);

        senha.setText("Senha:");
        jPanel1.add(senha);
        senha.setBounds(40, 250, 48, 15);

        senhaCampo.setText("teste");
        senhaCampo.setBorder(null);
        senhaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaCampoActionPerformed(evt);
            }
        });
        jPanel1.add(senhaCampo);
        senhaCampo.setBounds(90, 240, 320, 31);

        border_senha.setBackground(new java.awt.Color(105, 197, 103));

        javax.swing.GroupLayout border_senhaLayout = new javax.swing.GroupLayout(border_senha);
        border_senha.setLayout(border_senhaLayout);
        border_senhaLayout.setHorizontalGroup(
            border_senhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        border_senhaLayout.setVerticalGroup(
            border_senhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(border_senha);
        border_senha.setBounds(40, 270, 360, 3);

        email.setText("Email:");
        jPanel1.add(email);
        email.setBounds(40, 180, 48, 15);

        loginCampo.setText("teste@teste.com");
        loginCampo.setBorder(null);
        loginCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginCampoActionPerformed(evt);
            }
        });
        jPanel1.add(loginCampo);
        loginCampo.setBounds(90, 170, 320, 32);

        entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Botaologin.png"))); // NOI18N
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        jPanel1.add(entrar);
        entrar.setBounds(320, 310, 87, 30);

        border_email.setBackground(new java.awt.Color(105, 197, 103));

        javax.swing.GroupLayout border_emailLayout = new javax.swing.GroupLayout(border_email);
        border_email.setLayout(border_emailLayout);
        border_emailLayout.setHorizontalGroup(
            border_emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        border_emailLayout.setVerticalGroup(
            border_emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(border_email);
        border_email.setBounds(40, 200, 360, 3);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 460, 420);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void senhaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaCampoActionPerformed

    private void loginCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginCampoActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        try {
            String usuario_login, usuario_senha;
            usuario_login = loginCampo.getText();
            usuario_senha = senhaCampo.getText();

            LoginBean loginBean = new LoginBean();
            loginBean.setUsuario(usuario_login);
            loginBean.setSenha(usuario_senha);

            int max = 0;
            while (max <= 2){ //se adicionar mais um nível de acesso, prestar atenção neste trecho
                loginBean.setNivel(max); //primeiro o sistema vai tentar logar como usuário normal
                LoginDao loginDao = new LoginDao();
                ResultSet rsLoginDao = loginDao.autenticaUsuario(loginBean);

                if(rsLoginDao.next()){
                    dispose();
                    if (max == 0){
                        System.out.println("ADMIN LOGADO!!!!!");
                    }else{
                        System.out.println("USUÁRIO COMUM LOGADO!!!!!!");
                    }
                    return;
                } else {
                    if (max > 1){
                        System.out.println("Usuario ou senha incorretos");
                    }
                    max++;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro em tela de login");
        }
    }//GEN-LAST:event_entrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel border_email;
    private javax.swing.JPanel border_senha;
    private javax.swing.JLabel email;
    private javax.swing.JButton entrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginCampo;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel senha;
    private javax.swing.JPasswordField senhaCampo;
    // End of variables declaration//GEN-END:variables
}
