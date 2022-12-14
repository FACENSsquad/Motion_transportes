
package TELAS;

import BEANS.Motorista;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cadastro_motorista extends javax.swing.JFrame {

       
       
    public Cadastro_motorista() {
        initComponents();
        tabela_motorista();
    }
    
       private Connection conn;
       private Conexao conexao;
       

       Motorista motorista = new Motorista(); //acessar os atributos da classe Motorista
       
    
    public void Cadastrar_Motorista(Motorista motorista){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        
        motorista.setNome(Caixa_nome1.getText());
        motorista.setTelefone(Caixa_telefone.getText());
        
        String sql = "insert into motorista(nome, telefone) values "
                   + "(?, ?)";
        
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, motorista.getNome());
            pst.setString(2, motorista.getTelefone());
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar motorista" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar motorista");
            
        } finally {
            this.conexao.fecha_mt();
            
        }

    }
    
    
    public void delete(){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        int confirmar;
        String message = "Deseja realmente remover este Motorista?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from motorista where id = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"N??o foi possivel remover este motorista, verifique se ele encontra-se em viagem");
            System.out.println(e);
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
    
    public void consultar (){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
    
        String sql = "select * from motorista where id = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_nome1.setText(rs.getString(2));
              Caixa_telefone.setText(rs.getString(3));
              
      
            } else {
                JOptionPane.showMessageDialog(null,"Motorista n??o encontrado");
                
              Caixa_nome1.setText(null);
              Caixa_telefone.setText(null);
              
            }
     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
            System.out.println(e);
        }
    }
    
    
    private void tabela_motorista(){
    
     DefaultTableModel model = (DefaultTableModel) Table_motorista.getModel(); //criando tabela
     model.setNumRows(0);   // listar tabela apartir de
    
     Table_motorista.getColumnModel().getColumn(0).setPreferredWidth(10);
     Table_motorista.getColumnModel().getColumn(1).setPreferredWidth(10);
     Table_motorista.getColumnModel().getColumn(2).setPreferredWidth(10);
    
        try {
            
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from motorista");  // passando conexao para pst
           rs = pst.executeQuery();
           
            while (rs.next()) {
                
            
                model.addRow(new Object[]{
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getString(3),
                
            });
          } 
        } catch (Exception e) {
            System.out.println("Erro ao carregar Tabela Motorista.");
        }
     
    }
    
    
    public void update_motorista (){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
   
        String sql = "update motorista set nome = ?, telefone = ? "
                      + "where id = ?;";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, Caixa_nome1.getText());
            pst.setString(2, Caixa_telefone.getText());
            pst.setInt(3, Integer.parseInt(Caixa_codigo.getText()));
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Motorista atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em  UPDATE Motorista");
            System.out.println(e);
        }  
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jbutton1 = new javax.swing.JButton();
        Caixa_telefone = new javax.swing.JTextField();
        Caixa_nome1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_motorista = new javax.swing.JTable();
        Caixa_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JButton();
        Botton_deletar = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 450));
        jPanel2.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Codigo:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 170, 40, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Telefone:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 110, 60, 15);

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
        cadastrar.setBounds(430, 250, 97, 38);

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

        Caixa_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefoneActionPerformed(evt);
            }
        });
        jPanel2.add(Caixa_telefone);
        Caixa_telefone.setBounds(370, 110, 150, 19);

        Caixa_nome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_nome1ActionPerformed(evt);
            }
        });
        jPanel2.add(Caixa_nome1);
        Caixa_nome1.setBounds(90, 110, 150, 19);

        Table_motorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_motorista);
        if (Table_motorista.getColumnModel().getColumnCount() > 0) {
            Table_motorista.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(50, 320, 470, 90);
        jPanel2.add(Caixa_codigo);
        Caixa_codigo.setBounds(100, 170, 400, 19);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(50, 110, 40, 20);

        Botton_Atualizar.setText("Atualizar");
        Botton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_AtualizarActionPerformed(evt);
            }
        });
        jPanel2.add(Botton_Atualizar);
        Botton_Atualizar.setBounds(70, 260, 77, 25);

        Botton_deletar.setText("Deletar");
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel2.add(Botton_deletar);
        Botton_deletar.setBounds(260, 260, 68, 25);

        Botton_consultar.setText("P");
        Botton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_consultarActionPerformed(evt);
            }
        });
        jPanel2.add(Botton_consultar);
        Botton_consultar.setBounds(510, 170, 30, 20);

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

        setSize(new java.awt.Dimension(702, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
            this.setVisible(false);
    }//GEN-LAST:event_jbutton1ActionPerformed

    private void Caixa_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_telefoneActionPerformed

    private void Caixa_nome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_nome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_nome1ActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Cadastrar_Motorista(motorista);
        this.dispose();
    }//GEN-LAST:event_cadastrarActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
        delete();
        
        dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed
        consultar();
    }//GEN-LAST:event_Botton_consultarActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
        update_motorista();
        
        dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

   
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
    private javax.swing.JButton Botton_Atualizar;
    private javax.swing.JButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_nome1;
    private javax.swing.JTextField Caixa_telefone;
    private javax.swing.JTable Table_motorista;
    private javax.swing.JButton cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbutton1;
    // End of variables declaration//GEN-END:variables
}
