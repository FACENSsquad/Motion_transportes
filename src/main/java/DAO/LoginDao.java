/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BEANS.LoginBean;
import CONEXAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author eduar
 */
public class LoginDao {
      
    Connection conn;
    Conexao conexao;
    
    public ResultSet autenticaUsuario(LoginBean login_usuario){
        conn = new Conexao().mt_Conexao();
        try {
            String sql = "select * from usuario where email = ? and senha = ? and nivel = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1,login_usuario.getUsuario());
            pst.setString(2,login_usuario.getSenha());
            pst.setInt(3,login_usuario.getNivel());

            ResultSet rs = pst.executeQuery();
            return rs;
            
        } catch (Exception e){
         JOptionPane.showMessageDialog(null,"Erro em Login_dao " +e);
         return null;
        }
    }
    
}
