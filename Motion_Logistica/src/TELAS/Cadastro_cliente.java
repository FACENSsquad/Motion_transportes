/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TELAS;

import BEANS.Destinatario;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinic
 */
public class Cadastro_cliente extends javax.swing.JFrame {

    

    public Cadastro_cliente() {
        initComponents();
        tabela_cliente();
    }

    private Connection conn;
    private Conexao conexao;
    
    Destinatario destinatario = new Destinatario();
    
    public void Cadastrar_Destino(Destinatario destinatario){
    
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        destinatario.setCnpj(Caixa_cnpj.getText());
        destinatario.setNome(Caixa_nome.getText());
        destinatario.setEndereco(Caixa_endereco.getText());
        destinatario.setUf((String) Box_estado.getSelectedItem());
        destinatario.setCidade(Caixa_cidade.getText());
        destinatario.setDdd(Caixa_ddd.getText());
        destinatario.setTelefone(Caixa_telefone.getText());
        destinatario.setEmail(Caixa_email.getText());
        destinatario.setCoordX(Double.parseDouble(Caixa_coordX.getText()));
        destinatario.setCoordY(Double.parseDouble(Caixa_coordY.getText()));

   
       
        String sql = "insert into cliente(cnpj, nome_fantasia, endereco, uf,"
                + " cidade, ddd, telefone, email, coordX, coordY) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        
        
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
           pst.setDouble(9, destinatario.getCoordX());
           pst.setDouble(10, destinatario.getCoordY());

           
           pst.execute();
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar destinatario" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao destinatario");
            
        } finally {
            
            this.conexao.fecha_mt();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        }
        
    }
    
    public void delete(){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
        
        int confirmar;
        String message = "Deseja realmente remover este Cliente?";
        
        confirmar = JOptionPane.showConfirmDialog(null, message);
       
        
        if(confirmar == JOptionPane.YES_OPTION){
            
        String sql = "delete from cliente where id = ?";
        try {
             PreparedStatement pst = this.conn.prepareStatement(sql);
             pst.setString(1, Caixa_codigo.getText());
             pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Não foi possivel remover este Cliente, verifique se ele não esta ativo no DashBoard");
            System.out.println(e);
        }
    } else if(confirmar == JOptionPane.NO_OPTION) {
     dispose();
        }
    }
    
    public void update_cliente (){
       
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
   
        String sql = "update motorista set cnpj = ?, nome_fantasia = ?, endereco = ?, uf = ?,"
                + "cidade = ?, ddd = ?, telegone = ?, email = ?, coordX = ?, coordY = ? "
                + "where id = ?;";
        try {
            PreparedStatement pst = this.conn.prepareStatement(sql);
            pst.setString(1, Caixa_cnpj.getText());
            pst.setString(2, Caixa_nome.getText());
            pst.setString(2, Caixa_endereco.getText());
            pst.setString(2, (String) Box_estado.getSelectedItem());
            pst.setString(2, Caixa_cidade.getText());
            pst.setString(2, Caixa_ddd.getText());
            pst.setString(2, Caixa_telefone.getText());
            pst.setString(2, Caixa_email.getText());
            pst.setString(2, Caixa_coordX.getText());
            pst.setString(2, Caixa_coordY.getText());
            pst.setInt(3, Integer.parseInt(Caixa_codigo.getText()));
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Erro em  UPDATE Cliente");
            System.out.println(e);
        }  
    }
    
    public void consultar (){
        
        this.conexao = new Conexao();
        this.conn = this.conexao.mt_Conexao();
    
        String sql = "select * from cliente where id = ?;";
        ResultSet rs;
        
        try { 
            PreparedStatement pst3 = this.conn.prepareStatement(sql);
            pst3.setString(1, Caixa_codigo.getText());
            rs = pst3.executeQuery();
            
            if (rs.next()) {
                
              Caixa_cnpj.setText(rs.getString(2));
              Caixa_nome.setText(rs.getString(3));
              Caixa_endereco.setText(rs.getString(4));
              Box_estado.setSelectedItem(rs.getString(5));
              Caixa_cidade.setText(rs.getString(6));
              Caixa_ddd.setText(rs.getString(7));
              Caixa_telefone.setText(rs.getString(8));
              Caixa_email.setText(rs.getString(9));
              Caixa_coordX.setText(rs.getString(10));
              Caixa_coordY.setText(rs.getString(11));
              
      
            } else {
                JOptionPane.showMessageDialog(null,"Motorista não encontrado");
                
              Caixa_cnpj.setText(rs.getString(null));
              Caixa_nome.setText(rs.getString(null));
              Caixa_endereco.setText(rs.getString(null));
              Box_estado.setSelectedItem(rs.getString(null));
              Caixa_cidade.setText(rs.getString(null));
              Caixa_ddd.setText(rs.getString(null));
              Caixa_telefone.setText(rs.getString(null));
              Caixa_email.setText(rs.getString(null));
              Caixa_coordX.setText(rs.getString(null));
              Caixa_coordY.setText(rs.getString(null));
              
            }
     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro em metodo CONSULTAR");
            System.out.println(e);
        }
    }
    
    private void tabela_cliente(){
    
     DefaultTableModel model = (DefaultTableModel) Table_cliente.getModel(); //criando tabela
     model.setNumRows(0);   // listar tabela apartir de
    
     Table_cliente.getColumnModel().getColumn(0).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(1).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(2).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(3).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(4).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(5).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(6).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(7).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(8).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(9).setPreferredWidth(10);
     Table_cliente.getColumnModel().getColumn(10).setPreferredWidth(10);
    
        try {
            
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select * from cliente");  // passando conexao para pst
           rs = pst.executeQuery();
           
            while (rs.next()) {
                
            
                model.addRow(new Object[]{
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getString(7),
                   rs.getString(8),
                   rs.getString(9),
                   rs.getString(10),
                   rs.getString(11),
                
            });
          } 
        } catch (Exception e) {
            System.out.println("Erro ao carregar Tabela Motorista.");
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
        Box_estado = new javax.swing.JComboBox<>();
        button_cadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Caixa_ddd = new javax.swing.JTextField();
        Caixa_cnpj = new javax.swing.JTextField();
        Caixa_cidade = new javax.swing.JTextField();
        Caixa_nome = new javax.swing.JTextField();
        Caixa_endereco = new javax.swing.JTextField();
        Caixa_email = new javax.swing.JTextField();
        Caixa_coordX = new javax.swing.JTextField();
        Caixa_telefone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Caixa_telefone3 = new javax.swing.JTextField();
        Caixa_coordY = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_cliente = new javax.swing.JTable();
        Caixa_codigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Botton_Atualizar = new javax.swing.JButton();
        Botton_deletar = new javax.swing.JButton();
        Botton_consultar = new javax.swing.JButton();

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
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(407, 407, 407))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 930, 30);

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
        jbutton1.setBounds(950, 10, 31, 26);

        Box_estado.setBackground(new java.awt.Color(255, 255, 255));
        Box_estado.setForeground(new java.awt.Color(0, 0, 0));
        Box_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "MG", "RJ", "PN" }));
        Box_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(Box_estado);
        Box_estado.setBounds(100, 190, 44, 24);

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
        button_cadastrar.setBounds(740, 380, 100, 40);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Endereço:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 140, 60, 20);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cnpj:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 90, 40, 20);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Coordenada (x):");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(700, 90, 90, 20);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cidade:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 140, 40, 20);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Codigo:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(100, 300, 50, 30);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DDD:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 190, 30, 20);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("UF:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 190, 20, 20);

        Caixa_ddd.setText("15");
        Caixa_ddd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_dddActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_ddd);
        Caixa_ddd.setBounds(230, 190, 60, 20);

        Caixa_cnpj.setText("05454606980110");
        Caixa_cnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cnpjActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_cnpj);
        Caixa_cnpj.setBounds(100, 82, 200, 30);

        Caixa_cidade.setText("Votorantim");
        Caixa_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_cidadeActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_cidade);
        Caixa_cidade.setBounds(100, 132, 200, 30);

        Caixa_nome.setText("Cliente Exemplo");
        Caixa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_nomeActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_nome);
        Caixa_nome.setBounds(420, 80, 200, 30);

        Caixa_endereco.setText("Rua 1 Jardim 2");
        Caixa_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_enderecoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_endereco);
        Caixa_endereco.setBounds(420, 130, 200, 30);

        Caixa_email.setText("cliente@cliente.com");
        Caixa_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_emailActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_email);
        Caixa_email.setBounds(430, 240, 190, 30);

        Caixa_coordX.setText("-23.51");
        Caixa_coordX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_coordXActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_coordX);
        Caixa_coordX.setBounds(810, 80, 170, 30);

        Caixa_telefone.setText("999999999");
        Caixa_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefoneActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_telefone);
        Caixa_telefone.setBounds(430, 190, 190, 30);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Telefone:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(360, 200, 60, 20);

        Caixa_telefone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_telefone3ActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_telefone3);
        Caixa_telefone3.setBounds(810, 80, 170, 30);

        Caixa_coordY.setText("-47.45");
        Caixa_coordY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_coordYActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_coordY);
        Caixa_coordY.setBounds(810, 130, 170, 30);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Coordenada (y):");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(690, 140, 90, 20);

        Table_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "CNPJ", "Nome", "Endereço", "UF", "Cidade", "DDD", "Telefone", "E-mail", "Coordenada X", "Coordenada Y"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_cliente);
        if (Table_cliente.getColumnModel().getColumnCount() > 0) {
            Table_cliente.getColumnModel().getColumn(0).setResizable(false);
            Table_cliente.getColumnModel().getColumn(1).setResizable(false);
            Table_cliente.getColumnModel().getColumn(2).setResizable(false);
            Table_cliente.getColumnModel().getColumn(3).setResizable(false);
            Table_cliente.getColumnModel().getColumn(4).setResizable(false);
            Table_cliente.getColumnModel().getColumn(5).setResizable(false);
            Table_cliente.getColumnModel().getColumn(6).setResizable(false);
            Table_cliente.getColumnModel().getColumn(7).setResizable(false);
            Table_cliente.getColumnModel().getColumn(8).setResizable(false);
            Table_cliente.getColumnModel().getColumn(9).setResizable(false);
            Table_cliente.getColumnModel().getColumn(10).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 440, 810, 80);

        Caixa_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Caixa_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(Caixa_codigo);
        Caixa_codigo.setBounds(190, 300, 430, 30);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(370, 250, 40, 20);

        Botton_Atualizar.setText("Atualizar");
        Botton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_AtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_Atualizar);
        Botton_Atualizar.setBounds(140, 390, 110, 30);

        Botton_deletar.setText("Deletar");
        Botton_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_deletarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_deletar);
        Botton_deletar.setBounds(440, 390, 100, 30);

        Botton_consultar.setText("P");
        Botton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botton_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(Botton_consultar);
        Botton_consultar.setBounds(640, 300, 40, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 990, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Box_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Box_estadoActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
            this.setVisible(false);
    }//GEN-LAST:event_jbutton1ActionPerformed

    private void button_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cadastrarActionPerformed
        Cadastrar_Destino(destinatario);
        this.dispose();
    }//GEN-LAST:event_button_cadastrarActionPerformed

    private void Caixa_dddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_dddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_dddActionPerformed

    private void Caixa_cnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_cnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_cnpjActionPerformed

    private void Caixa_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_cidadeActionPerformed

    private void Caixa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_nomeActionPerformed

    private void Caixa_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_enderecoActionPerformed

    private void Caixa_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_emailActionPerformed

    private void Caixa_coordXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_coordXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_coordXActionPerformed

    private void Caixa_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_telefoneActionPerformed

    private void Caixa_telefone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_telefone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_telefone3ActionPerformed

    private void Caixa_coordYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_coordYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_coordYActionPerformed

    private void Caixa_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Caixa_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Caixa_codigoActionPerformed

    private void Botton_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_deletarActionPerformed
        delete();
        
        dispose();
    }//GEN-LAST:event_Botton_deletarActionPerformed

    private void Botton_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_AtualizarActionPerformed
       update_cliente();
       
       dispose();
    }//GEN-LAST:event_Botton_AtualizarActionPerformed

    private void Botton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botton_consultarActionPerformed
        consultar();
    }//GEN-LAST:event_Botton_consultarActionPerformed

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
    private javax.swing.JButton Botton_Atualizar;
    private javax.swing.JButton Botton_consultar;
    private javax.swing.JButton Botton_deletar;
    private javax.swing.JComboBox<String> Box_estado;
    private javax.swing.JTextField Caixa_cidade;
    private javax.swing.JTextField Caixa_cnpj;
    private javax.swing.JTextField Caixa_codigo;
    private javax.swing.JTextField Caixa_coordX;
    private javax.swing.JTextField Caixa_coordY;
    private javax.swing.JTextField Caixa_ddd;
    private javax.swing.JTextField Caixa_email;
    private javax.swing.JTextField Caixa_endereco;
    private javax.swing.JTextField Caixa_nome;
    private javax.swing.JTextField Caixa_telefone;
    private javax.swing.JTextField Caixa_telefone3;
    private javax.swing.JTable Table_cliente;
    private javax.swing.JButton button_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbutton1;
    // End of variables declaration//GEN-END:variables
}
