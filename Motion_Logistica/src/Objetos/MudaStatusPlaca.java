/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author eduar
 */
public class MudaStatusPlaca {
    private Connection conn;
    private Conexao conexao;

    public static void removePlaca (String placaCodigo){
        Conexao conexao = new Conexao();
        Connection conn = conexao.mt_Conexao();
               
        String sql = "DELETE from estatus WHERE placa = ?";        
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, placaCodigo);
           
            pst.execute();
            
            
        } catch (Exception e) {
            
            System.out.println("Erro ao remover placa" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao remover placa");
            
        } finally {
            conexao.fecha_mt();
            JOptionPane.showMessageDialog(null, "Placa removida com sucesso dos status");
        }

    }
}
