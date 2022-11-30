
package TELAS;

import BEANS.Motorista;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import BEANS.Veiculo;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Cadastro_veiculo extends javax.swing.JFrame {

       
       
    public Cadastro_veiculo() {
        initComponents();
        tabela_veiculo();
    }
    
       private Connection conn;
       private Conexao conexao;
       
       Veiculo veiculo = new Veiculo(); //acessar os atributos da classe Motorista
       
    
    public void Cadastrar_Veiculo(Veiculo veiculo){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        
        veiculo.setPlaca(Caixa_nome.getText());
        veiculo.setTipo_veiculo(veiculoss.getSelectedItem().toString());
        
        String sql = "insert into veiculo(placa, tipo_veiculo) values "
                   + "(?, ?)";
        
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, veiculo.getPlaca());
            pst.setString(2, veiculo.getTipo_veiculo());
           
            pst.execute();
            
            
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar motorista" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar motorista");
            
        } finally {
            this.conexao.fecha_mt();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
    
        
    }
    
private void tabela_veiculo(){
    
     DefaultTableModel model = (DefaultTableModel) Table_veiculo.getModel(); //criando tabela
     model.setNumRows(0);   // listar tabela apartir de
    
     Table_veiculo.getColumnModel().getColumn(0).setPreferredWidth(10);
     Table_veiculo.getColumnModel().getColumn(1).setPreferredWidth(10);
     
    
        try {
            
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from veiculo");  // passando conexao para pst
           rs = pst.executeQuery();
           
            while (rs.next()) {
                
            
                model.addRow(new Object[]{
                   rs.getString(1),
                   rs.getString(2),
                   
                
            });
          } 
        } catch (Exception e) {
            System.out.println("Erro ao carregar Tabela de Veiculos.");
        }
     
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        veiculoss = new javax.swing.JComboBox<>();
        Caixa_nome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_veiculo = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 450));
        jPanel2.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Placa:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 110, 40, 20);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Veiculo:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 110, 60, 15);

        Cadastrar.setBackground(new java.awt.Color(255, 255, 255));
        Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botaosalvar.png"))); // NOI18N
        Cadastrar.setBorder(null);
        Cadastrar.setBorderPainted(false);
        Cadastrar.setContentAreaFilled(false);
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(Cadastrar);
        Cadastrar.setBounds(540, 220, 97, 38);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setPreferredSize(new java.awt.Dimension(645, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cadastro Veiculo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 10, 645, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botao_fechar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(660, 10, 31, 26);

        veiculoss.setBackground(new java.awt.Color(255, 255, 255));
        veiculoss.setForeground(new java.awt.Color(0, 0, 0));
        veiculoss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caminhão", "Carro", "Van", "Moto" }));
        veiculoss.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        veiculoss.setFocusable(false);
        veiculoss.setLightWeightPopupEnabled(false);
        jPanel2.add(veiculoss);
        veiculoss.setBounds(360, 110, 100, 20);
        jPanel2.add(Caixa_nome);
        Caixa_nome.setBounds(90, 110, 170, 19);

        Table_veiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Placa", "Veiculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_veiculo);
        if (Table_veiculo.getColumnModel().getColumnCount() > 0) {
            Table_veiculo.getColumnModel().getColumn(0).setResizable(false);
            Table_veiculo.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 450, 90);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(702, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        Cadastrar_Veiculo(veiculo);
        this.dispose();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(Cadastro_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_veiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_veiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JTextField Caixa_nome;
    private javax.swing.JTable Table_veiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> veiculoss;
    // End of variables declaration//GEN-END:variables
}
