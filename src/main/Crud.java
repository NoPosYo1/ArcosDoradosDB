package main;

import igu.Dashboard;
import javax.swing.*;
import java.sql.*;
import igu.PPrincipal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ferfr
 */
public class Crud {
    
    //usuario elegido admin,mesero,cocina
    static String user;
    static int idUsuario;
    
    
    //ordenadas por orden de uso general/(pantallas) - sin elegir ususario
    public void mostrarEmpleados(JComboBox<String> cb){
        user = PPrincipal.getUsuarioApp();
        idUsuario = seleccionarUser(user);
        
        String query = "SELECT nombre, apellido_1 FROM empleado ORDER BY id_empleado ASC";
        
        try(Connection con = dbConnection.conectar(idUsuario)){
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            cb.removeAllItems();
            
            while(rs.next()){
                String empleado = rs.getNString("nombre")+" " + rs.getNString("apellido_1");
                cb.addItem(empleado);
            }                  

        }catch(SQLException e){
            e.printStackTrace();
            
            JOptionPane.showInputDialog(null,e);
        }
        
    }
    
    //no tiene nada de bd pero igual lo deje 
    public void mostrarUsuarios(JComboBox<String> cb){
        String cocina = "cocina";
        String mesero = "mesero";
        String admin  = "admin";
        cb.removeAllItems();
        
        cb.addItem(cocina);
        cb.addItem(mesero);
        cb.addItem(admin);
        
    }

    
    //Pantalla agregar servicios
    public void cargarTiposServicio(Map<String, String> mapaTipos) {
        String query = "SELECT id_tipo, nombre FROM tipo";
        mapaTipos.clear();
        
        try (Connection con = dbConnection.conectar(idUsuario)){
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mapaTipos.put(rs.getString("nombre"), rs.getString("id_tipo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

    public void cargarServiciosPorTipo(String idTipo, List<String> listaServicios){
        listaServicios.clear(); // Para elimiar lo que tenga
        String query = "SELECT nombre FROM servicio WHERE id_tipo = ?";
        
        try (Connection con = dbConnection.conectar(idUsuario)){

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idTipo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaServicios.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int seleccionarIDServicio(String nombreServicio){
        int idServicio = 0;
        String query = "SELECT id_servicio FROM servicio WHERE nombre = ?";
        try (Connection con = dbConnection.conectar(idUsuario)){

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombreServicio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idServicio = rs.getInt("id_servicio");
            
            }else{
                System.out.println("nada");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return idServicio;
    }
    
    public void cargarDescripciones(int idServicio, JTextArea ta){
        
        String query = "SELECT descripcion FROM servicio WHERE id_servicio = ?";
        
        try (Connection con = dbConnection.conectar(idUsuario)){

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idServicio);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                ta.setText(rs.getString("descripcion"));
            }
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void actualizarEstado(String id_estado, int id_detalle_comanda) {
        String query = "{CALL ActualizarEstado(?, ?)}";

        try (Connection con = dbConnection.conectar(idUsuario);
             CallableStatement cs = con.prepareCall(query)) {

            
            cs.setInt(1, id_detalle_comanda);
            cs.setString(2, id_estado);
            
            cs.executeUpdate();

            System.out.println("Estado Actualizado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public int crearComanda(int mesa, int id_empleado){
        
        String query = "INSERT INTO comanda (mesa, fecha_hora_creacion, id_empleado) VALUES ( ?, NOW(), ?) ";
        int idComanda = -1;
        try (Connection con = dbConnection.conectar(idUsuario);
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, mesa);
            ps.setInt(2, id_empleado);

            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) {
                    idComanda = rs.getInt(1);
                }
            }
            
            System.out.println("Comanda creada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return idComanda;
    }
    
    public int insertarDetalleComanda(int id_comanda,int id_servicio,int cantidad){
        int idDetalleComanda = -1;
        String query = "INSERT INTO detalle_comanda (cantidad, id_servicio, id_comanda) VALUES ( ?, ?, ?) ";
        
        try (Connection con = dbConnection.conectar(idUsuario);
             PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, cantidad);
            ps.setInt(2, id_servicio); 
            ps.setInt(3, id_comanda);

            ps.executeUpdate();

            System.out.println("Servicio añadido correctamente.");
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idDetalleComanda = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        return idDetalleComanda;
    }
    
    public List<Object []> cargarServiciosYEstados(int idComanda){
        
        List<Object[]> lista = new ArrayList<>();
        
        String query ="SELECT dc.id_detalle_comanda, s.nombre AS servicio, "
                + "(SELECT e.nombre FROM historial h "
                + "JOIN estado e ON h.id_estado = e.id_estado "
                + "WHERE h.id_detalle_comanda = dc.id_detalle_comanda "
                + "ORDER BY h.fecha_hora DESC LIMIT 1) AS estado_actual "
                + "FROM detalle_comanda dc "
                + "JOIN servicio s ON dc.id_servicio = s.id_servicio "
                + "WHERE dc.id_comanda = ?";
        
        try(Connection con = dbConnection.conectar(idUsuario)){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idComanda);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int idDetalle = rs.getInt("id_detalle_comanda");
                String servicio = rs.getString("servicio");
                String estadoActual = rs.getString("estado_actual");
                
                lista.add(new Object[]{idDetalle, servicio, estadoActual});
            }
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void rellenarCBComandas(JComboBox<String> cb){
        String query = "SELECT id_comanda FROM comanda ORDER BY id_comanda ASC";
        
        try(Connection con = dbConnection.conectar(idUsuario);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            
            cb.removeAllItems();
            
            while(rs.next()){
                int id = rs.getInt("id_comanda");
                cb.addItem("Comanda #"+id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void verMesaComanda(JTextField t,int idComanda){
        String query = "SELECT mesa FROM comanda WHERE id_comanda = ?";
        
        try(Connection con = dbConnection.conectar(idUsuario);
            PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setInt(1, idComanda);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int numeroMesa = rs.getInt("mesa");
                t.setText(String.valueOf(numeroMesa));
            }else{
                t.setText("No encontrado");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    
    //seleccionar usuario App
    private int seleccionarUser(String user) {
        int idUsuario = 0;
        if(user.equals("cocina")){
            idUsuario = 1;
        }else if(user.equals("mesero")){
            idUsuario = 2;
        }else if(user.equals("admin")){
            idUsuario = 3;
        }
        return idUsuario;
    }
    
    public void cambiarUsuarioApp(String us){
        user = us;
        
        idUsuario = seleccionarUser(user);
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    
    
    
}
