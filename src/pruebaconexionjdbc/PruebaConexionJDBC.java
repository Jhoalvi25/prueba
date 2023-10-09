/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaconexionjdbc;

/**
 *
 * @author jhoalvi
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PruebaConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String contraseña = "";
        String url = "jdbc:mysql://localhost:3306/prueba";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,contraseña);
            statement = conexion.createStatement();
            
            //CREATE
            
            statement.executeUpdate("INSERT INTO CLIENTE(NOMBRE,TELEFONO,CORREO,DIRECCIÓN) VALUES('Marianela','12345678','MARIANELAPEREIRA@GMAIL.COM','VEREDA BOJACA')");
                
            
            //DELETE
            
            statement.executeUpdate("DELETE FROM CLIENTE WHERE ID=19");
            
            
             //READ
            
            rs = statement.executeQuery("SELECT * FROM CLIENTE"); 
            rs.next();
            do{
                System.out.println(rs.getInt("ID")+"-"+ rs.getString("NOMBRE")+"-"+ rs.getString("TELEFONO")+"-"+ rs.getString("CORREO")+"-"+ rs.getString("DIRECCIÓN"));
            }
            while( rs.next());
            
              //UPDATE
            
            //statement.executeUpdate("UPDATE CLIENTE SET NOMBRE='Marianela',TELEFONO='324566006',CORREO='MARIANELAPEREIRA23@OUTLOOK.COM',DIRECCIÓN='EL CURUBITO'");
            
        
            
            
           
        
        } catch (SQLException ex) {
            Logger.getLogger(PruebaConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
