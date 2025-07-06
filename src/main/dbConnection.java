package main;


import java.sql.*;

/**
 *
 * @author ferfr
 */
public class dbConnection {
    

    static String db = "arcosdoradosdb";
    static String url = "jdbc:mysql://localhost:3306/"+db+"?serverTimezone=UTC";




    public static Connection conectar(int opcionUser){
        
        String user = "root";
        String pass = "nubolindo";
        
        if(opcionUser == 1){
            user = "cocina";
            pass = "cocina321";
        }else if(opcionUser == 2){
            user = "mesero";
            pass = "mesero123";
        }else if(opcionUser == 3){
            user = "admin";
            pass = "Admin01";
        }

        Connection con = null;
        try {

            con = DriverManager.getConnection(url, user,pass);
            System.out.println("user "+user+" Conectado");


        }catch (SQLException e){
            
            System.out.println("Esto es un error sisi");
            e.printStackTrace();
        }
        return con;

    }
   
    
}
