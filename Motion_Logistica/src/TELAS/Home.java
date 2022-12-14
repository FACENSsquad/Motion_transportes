
package TELAS;

import CONEXAO.Conexao;
import Objetos.MudaStatusPlaca;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Vinic
 */
public class Home extends javax.swing.JFrame {
       boolean menuAberto;
       Menu menuObj = new Menu();
       String placaSelecionada;
       
       private void recarregarTudo(){
           //sem uso
       }
       
       private void tabela_veiculos(){
        
        DefaultTableModel model = (DefaultTableModel) Veiculos.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Veiculos.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
      
        
        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select v.placa from estatus as e right join veiculo as v on e.placa = v.placa where e.estatus is NULL");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   rs.getString(1)
               });
           }
        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
    }
       
   private void tabela_transito(){
        
        DefaultTableModel model = (DefaultTableModel) Transito.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Transito.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela            
        Transito.removeColumn(Transito.getColumnModel().getColumn(2));
        Transito.removeColumn(Transito.getColumnModel().getColumn(1));

        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select e.placa, c.coordX, c.coordY from estatus as e inner join clientes as c on e.destinatario = c.id where estatus = 1");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set

           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   rs.getString(1),
                   rs.getDouble(2),
                   rs.getDouble(3),
               });
           }
           


        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
        
        //Pega os valores de cada c??lula quando ?? dado o duplo clique
        Transito.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1){
            int row = Transito.rowAtPoint(e.getPoint());
            placaSelecionada = Transito.getModel().getValueAt(row, 0).toString();       
            System.out.println(placaSelecionada);
        }    
            
        if (e.getClickCount() == 2) {
        int row=Transito.rowAtPoint(e.getPoint());
        int col= Transito.columnAtPoint(e.getPoint());
        System.out.println(Transito.getModel().getValueAt(row,1).toString());
        System.out.println(Transito.getModel().getValueAt(row,2).toString());
        Popup_infos_placa popup = new Popup_infos_placa((Double)Transito.getModel().getValueAt(row,1),(Double)Transito.getModel().getValueAt(row,2),Transito.getModel().getValueAt(row, 0).toString());
        popup.setVisible(true);
        popup.setLocation(e.getXOnScreen() + 10, e.getYOnScreen() - 10);
        //Mapa_1_marcador map = new Mapa_1_marcador((Double)Transito.getModel().getValueAt(row,1),(Double)Transito.getModel().getValueAt(row,2)); 
        }}
        });
    }
   
        private void tabela_coletando(){
        
        DefaultTableModel model = (DefaultTableModel) Coletando.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Coletando.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        Coletando.removeColumn(Coletando.getColumnModel().getColumn(2));
        Coletando.removeColumn(Coletando.getColumnModel().getColumn(1));

        
        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select e.placa, c.coordX, c.coordY from estatus as e inner join clientes as c on e.destinatario = c.id where estatus = 2");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   rs.getDouble(2),
                   rs.getDouble(3),

               });

           }
        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
            Coletando.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int row = Coletando.rowAtPoint(e.getPoint());
                        placaSelecionada = Coletando.getModel().getValueAt(row, 0).toString();
                        System.out.println(placaSelecionada);
                    }

                    if (e.getClickCount() == 2) {
                        int row = Coletando.rowAtPoint(e.getPoint());
                        int col = Coletando.columnAtPoint(e.getPoint());
                        System.out.println(Coletando.getModel().getValueAt(row, 1).toString());
                        System.out.println(Coletando.getModel().getValueAt(row, 2).toString());
                        Popup_infos_placa popup = new Popup_infos_placa((Double) Coletando.getModel().getValueAt(row, 1), (Double) Coletando.getModel().getValueAt(row, 2), Coletando.getModel().getValueAt(row, 0).toString());
                        popup.setVisible(true);
                        popup.setLocation(e.getXOnScreen() + 10, e.getYOnScreen() - 10);                        
                        //Mapa_1_marcador map = new Mapa_1_marcador((Double) Coletando.getModel().getValueAt(row, 1), (Double) Coletando.getModel().getValueAt(row, 2));
                    }
                }
            });
    }
   
   
            

   private void tabela_destino(){
        
        DefaultTableModel model = (DefaultTableModel) Destino.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Destino.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        Destino.removeColumn(Destino.getColumnModel().getColumn(2));
        Destino.removeColumn(Destino.getColumnModel().getColumn(1));

        
        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select e.placa, c.coordX, c.coordY from estatus as e inner join clientes as c on e.destinatario = c.id where estatus = 3");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   rs.getDouble(2),
                   rs.getDouble(3),

               });
           }
        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
        
       Destino.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                   int row = Destino.rowAtPoint(e.getPoint());
                   placaSelecionada = Destino.getModel().getValueAt(row, 0).toString();
                   System.out.println(placaSelecionada);
               }
               if (e.getClickCount() == 2) {
                   int row = Destino.rowAtPoint(e.getPoint());
                   int col = Destino.columnAtPoint(e.getPoint());
                   System.out.println(Destino.getModel().getValueAt(row, 1).toString());
                   System.out.println(Destino.getModel().getValueAt(row, 2).toString());
                   Popup_infos_placa popup = new Popup_infos_placa((Double) Destino.getModel().getValueAt(row, 1), (Double) Destino.getModel().getValueAt(row, 2), Destino.getModel().getValueAt(row, 0).toString());
                   popup.setVisible(true);
                   popup.setLocation(e.getXOnScreen() + 10, e.getYOnScreen() -10);
                   
//Mapa_1_marcador map = new Mapa_1_marcador((Double) Destino.getModel().getValueAt(row, 1), (Double) Destino.getModel().getValueAt(row, 2));
               }
           }
       });
    }
           
           private void tabela_descarga(){
        
        DefaultTableModel model = (DefaultTableModel) Descarga.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Descarga.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
        Descarga.removeColumn(Descarga.getColumnModel().getColumn(2));
        Descarga.removeColumn(Descarga.getColumnModel().getColumn(1));

        
        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select e.placa, c.coordX, c.coordY from estatus as e inner join clientes as c on e.destinatario = c.id where estatus = 4");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   rs.getDouble(2),
                   rs.getDouble(3),

               });
           }
        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
               Descarga.addMouseListener(new MouseAdapter() {
                   public void mouseClicked(MouseEvent e) {
                       if (e.getClickCount() == 1) {
                           int row = Descarga.rowAtPoint(e.getPoint());
                           placaSelecionada = Descarga.getModel().getValueAt(row, 0).toString();
                           System.out.println(placaSelecionada);
                       }
                       if (e.getClickCount() == 2) {
                           int row = Descarga.rowAtPoint(e.getPoint());
                           int col = Descarga.columnAtPoint(e.getPoint());
                           System.out.println(Descarga.getModel().getValueAt(row, 1).toString());
                           System.out.println(Descarga.getModel().getValueAt(row, 2).toString());
                           Popup_infos_placa popup = new Popup_infos_placa((Double) Descarga.getModel().getValueAt(row, 1), (Double) Descarga.getModel().getValueAt(row, 2), Descarga.getModel().getValueAt(row, 0).toString());
                           popup.setVisible(true);
                           popup.setLocation(e.getXOnScreen() + 10, e.getYOnScreen() - 10);
                           
//Mapa_1_marcador map = new Mapa_1_marcador((Double) Descarga.getModel().getValueAt(row, 1), (Double) Descarga.getModel().getValueAt(row, 2));
                       }
                   }
               });

    }
    
        private void tabela_finalizado(){
        
        DefaultTableModel model = (DefaultTableModel) Finalizado.getModel(); //criando tabela
        model.setNumRows(0);   // listar tabela apartir de
        
        Finalizado.getColumnModel().getColumn(0).setPreferredWidth(10);  // colunas da tabela
      
        
        try {
           Connection conn = new Conexao().mt_Conexao(); // estabelecendo conexao 
           PreparedStatement pst;  
           ResultSet rs;
           
           pst = conn.prepareStatement("select placa from estatus where estatus = 5");  // passando conexao para pst
           rs = pst.executeQuery();      //executando  os valores da conexao com result set
           
           while (rs.next()){   // lendo os valores do banco, utilizando netx para percorrer os dados
               model.addRow(new Object[]{
                   
                   rs.getString(1),
                   
               });
           }
        } catch ( Exception e) {
            System.out.println("Erro"+e);
        }
    }
               
    public Home(){
        menuAberto = false;
        initComponents();
        tabela_transito();
        tabela_coletando();
        tabela_destino();
        tabela_descarga();
        tabela_finalizado();
        tabela_veiculos();

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
        jToggleButton1 = new javax.swing.JToggleButton();
        botaoRemovePlaca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Transito = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Veiculos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Coletando = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Destino = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Descarga = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        Finalizado = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        Alerta = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        botaoRemovePlaca1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 44));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Usuario:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(590, 0, 54, 40);

        usuario.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        usuario.setForeground(new java.awt.Color(51, 51, 51));
        usuario.setText("teste");
        jPanel2.add(usuario);
        usuario.setBounds(662, 0, 32, 40);

        logo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        logo.setText("MotiON");
        jPanel2.add(logo);
        logo.setBounds(23, 7, 48, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botao_menu.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(1201, 0, 68, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1280, 44);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 55));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 55));

        Status_transito.setBackground(new java.awt.Color(255, 255, 255));
        Status_transito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_veiculos.png"))); // NOI18N
        Status_transito.setBorderPainted(false);
        Status_transito.setContentAreaFilled(false);
        Status_transito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_transitoActionPerformed(evt);
            }
        });

        Status_coletando.setBackground(new java.awt.Color(255, 255, 255));
        Status_coletando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_transito.png"))); // NOI18N
        Status_coletando.setBorderPainted(false);
        Status_coletando.setContentAreaFilled(false);

        Status_destino.setBackground(new java.awt.Color(255, 255, 255));
        Status_destino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_coletando.png"))); // NOI18N
        Status_destino.setBorderPainted(false);
        Status_destino.setContentAreaFilled(false);

        Status_descarga1.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_destino.png"))); // NOI18N
        Status_descarga1.setBorderPainted(false);
        Status_descarga1.setContentAreaFilled(false);

        Status_descarga2.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_descarga.png"))); // NOI18N
        Status_descarga2.setBorderPainted(false);
        Status_descarga2.setContentAreaFilled(false);
        Status_descarga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_descarga2ActionPerformed(evt);
            }
        });

        Status_descarga3.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_finalizado.png"))); // NOI18N
        Status_descarga3.setBorderPainted(false);
        Status_descarga3.setContentAreaFilled(false);

        Status_descarga.setBackground(new java.awt.Color(255, 255, 255));
        Status_descarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/status_alerta.png"))); // NOI18N
        Status_descarga.setBorderPainted(false);
        Status_descarga.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
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
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Status_descarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_descarga1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Status_destino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Status_coletando, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Status_transito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 54, 1280, 55);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(1280, 55));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 695));
        jPanel3.setLayout(null);

        jToggleButton1.setText("Atribuir status");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton1);
        jToggleButton1.setBounds(1140, 520, 110, 50);

        botaoRemovePlaca.setBackground(new java.awt.Color(255, 255, 255));
        botaoRemovePlaca.setForeground(new java.awt.Color(51, 255, 51));
        botaoRemovePlaca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/atualizar.png"))); // NOI18N
        botaoRemovePlaca.setBorderPainted(false);
        botaoRemovePlaca.setContentAreaFilled(false);
        botaoRemovePlaca.setFocusCycleRoot(true);
        botaoRemovePlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemovePlacaActionPerformed(evt);
            }
        });
        jPanel3.add(botaoRemovePlaca);
        botaoRemovePlaca.setBounds(1100, 540, 32, 31);

        Transito.setBackground(new java.awt.Color(255, 255, 255));
        Transito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Transito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Transito.setToolTipText("");
        Transito.setGridColor(new java.awt.Color(255, 255, 255));
        Transito.setRowHeight(25);
        Transito.setRowSelectionAllowed(false);
        Transito.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Transito.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Transito.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Transito);
        if (Transito.getColumnModel().getColumnCount() > 0) {
            Transito.getColumnModel().getColumn(0).setResizable(false);
            Transito.getColumnModel().getColumn(1).setResizable(false);
            Transito.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(220, 0, 160, 570);

        Veiculos.setBackground(new java.awt.Color(255, 255, 255));
        Veiculos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Veiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Veiculos.setToolTipText("");
        Veiculos.setGridColor(new java.awt.Color(255, 255, 255));
        Veiculos.setPreferredSize(new java.awt.Dimension(100, 560));
        Veiculos.setRowHeight(25);
        Veiculos.setRowSelectionAllowed(false);
        Veiculos.setSelectionBackground(new java.awt.Color(0, 0, 0));
        Veiculos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Veiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Veiculos);
        if (Veiculos.getColumnModel().getColumnCount() > 0) {
            Veiculos.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 40, 190, 530);

        Coletando.setBackground(new java.awt.Color(255, 255, 255));
        Coletando.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Coletando.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Coletando.setToolTipText("");
        Coletando.setGridColor(new java.awt.Color(255, 255, 255));
        Coletando.setRowHeight(25);
        Coletando.setRowSelectionAllowed(false);
        Coletando.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Coletando.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Coletando.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(Coletando);
        if (Coletando.getColumnModel().getColumnCount() > 0) {
            Coletando.getColumnModel().getColumn(0).setResizable(false);
            Coletando.getColumnModel().getColumn(1).setResizable(false);
            Coletando.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(400, 0, 160, 570);

        Destino.setBackground(new java.awt.Color(255, 255, 255));
        Destino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Destino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Destino.setToolTipText("");
        Destino.setGridColor(new java.awt.Color(255, 255, 255));
        Destino.setRowHeight(25);
        Destino.setRowSelectionAllowed(false);
        Destino.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Destino.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Destino.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(Destino);
        if (Destino.getColumnModel().getColumnCount() > 0) {
            Destino.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(580, 0, 150, 570);

        Descarga.setBackground(new java.awt.Color(255, 255, 255));
        Descarga.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Descarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "1", "2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Descarga.setToolTipText("");
        Descarga.setGridColor(new java.awt.Color(255, 255, 255));
        Descarga.setRowHeight(25);
        Descarga.setRowSelectionAllowed(false);
        Descarga.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Descarga.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Descarga.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(Descarga);
        if (Descarga.getColumnModel().getColumnCount() > 0) {
            Descarga.getColumnModel().getColumn(0).setResizable(false);
            Descarga.getColumnModel().getColumn(1).setResizable(false);
            Descarga.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel3.add(jScrollPane7);
        jScrollPane7.setBounds(750, 0, 150, 570);

        Finalizado.setBackground(new java.awt.Color(255, 255, 255));
        Finalizado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Finalizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finalizado.setToolTipText("");
        Finalizado.setGridColor(new java.awt.Color(255, 255, 255));
        Finalizado.setRowHeight(25);
        Finalizado.setRowSelectionAllowed(false);
        Finalizado.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Finalizado.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Finalizado.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(Finalizado);
        if (Finalizado.getColumnModel().getColumnCount() > 0) {
            Finalizado.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane8);
        jScrollPane8.setBounds(920, 0, 150, 570);

        Alerta.setBackground(new java.awt.Color(255, 255, 255));
        Alerta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Alerta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Alerta.setToolTipText("");
        Alerta.setGridColor(new java.awt.Color(255, 255, 255));
        Alerta.setRowHeight(25);
        Alerta.setRowSelectionAllowed(false);
        Alerta.setSelectionBackground(new java.awt.Color(255, 255, 255));
        Alerta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Alerta.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(Alerta);
        if (Alerta.getColumnModel().getColumnCount() > 0) {
            Alerta.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane9);
        jScrollPane9.setBounds(1100, 0, 150, 510);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botao_addPlaca.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setFocusCycleRoot(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(10, 0, 32, 31);

        botaoRemovePlaca1.setBackground(new java.awt.Color(255, 255, 255));
        botaoRemovePlaca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMGs/botao_removePlaca.png"))); // NOI18N
        botaoRemovePlaca1.setBorderPainted(false);
        botaoRemovePlaca1.setFocusCycleRoot(true);
        botaoRemovePlaca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemovePlaca1ActionPerformed(evt);
            }
        });
        jPanel3.add(botaoRemovePlaca1);
        botaoRemovePlaca1.setBounds(170, 0, 32, 31);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jTextField1);
        jTextField1.setBounds(42, 2, 127, 27);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 120, 1280, 685);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRemovePlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemovePlacaActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoRemovePlacaActionPerformed

    private void Status_transitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_transitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_transitoActionPerformed

    private void Status_descarga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_descarga2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_descarga2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(menuAberto == false){
            menuObj.setLocation(jButton2.getLocationOnScreen().x - 100,jButton2.getLocationOnScreen().y + 40);
            menuObj.setVisible(true);
            menuAberto = true;
        }
        else{
            menuObj.setVisible(false);
            menuAberto = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Cadastro_veiculo veiculo = new Cadastro_veiculo();
        veiculo.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void botaoRemovePlaca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemovePlaca1ActionPerformed
        if (placaSelecionada == null){
            JOptionPane.showMessageDialog(null, "Nenhuma placa selecionada");
        }
        else{
        MudaStatusPlaca.removePlaca(placaSelecionada);
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_botaoRemovePlaca1ActionPerformed

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
    private javax.swing.JTable Alerta;
    private javax.swing.JTable Coletando;
    private javax.swing.JTable Descarga;
    private javax.swing.JTable Destino;
    private javax.swing.JTable Finalizado;
    private javax.swing.JButton Status_coletando;
    private javax.swing.JButton Status_descarga;
    private javax.swing.JButton Status_descarga1;
    private javax.swing.JButton Status_descarga2;
    private javax.swing.JButton Status_descarga3;
    private javax.swing.JButton Status_destino;
    private javax.swing.JButton Status_transito;
    private javax.swing.JTable Transito;
    private javax.swing.JTable Veiculos;
    private javax.swing.JButton botaoRemovePlaca;
    private javax.swing.JButton botaoRemovePlaca1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

    private void Menu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
