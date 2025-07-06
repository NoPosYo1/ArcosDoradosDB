package igu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import main.Crud;
import igu.Dashboard;

/**
 *
 * @author ferfr
 */
public class P_Camarero extends javax.swing.JPanel {
    
    
    //variables escenciales
    public static PAgregarServicio pAgregarServ = new PAgregarServicio();
    
    
    //crear 2 List para que guarden el servicio y la cantidad para la comanda
    private Map<String, Integer> serviciosCantidad = new LinkedHashMap<>();

    
    //para la JList
    private ArrayList listaSer = new ArrayList(); // se guardan los servicios agregados
    private DefaultListModel nuevoModelo = new DefaultListModel();
    
    //crud
    Crud crud = new Crud();
    
    
    public P_Camarero() {
        initComponents();
        añadirMesas();
    }

    /**
     * crear comanda,borrarla
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextVCComanda = new javax.swing.JLabel();
        BAgregarServicio = new javax.swing.JButton();
        TextMesa = new javax.swing.JLabel();
        CBMesa = new javax.swing.JComboBox<>();
        BorrarComanda = new javax.swing.JButton();
        CrearComanda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaServiciosComanda = new javax.swing.JList<>();

        setMaximumSize(new java.awt.Dimension(800, 577));
        setMinimumSize(new java.awt.Dimension(800, 577));

        TextVCComanda.setText("Vista Creacion Comanda");

        BAgregarServicio.setText("Agregar Servicio");
        BAgregarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BAgregarServicioMouseClicked(evt);
            }
        });

        TextMesa.setText("Mesa");

        CBMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BorrarComanda.setText("Borrar Comanda");
        BorrarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BorrarComandaMouseClicked(evt);
            }
        });

        CrearComanda.setText("Crear Comanda");
        CrearComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearComandaMouseClicked(evt);
            }
        });

        ListaServiciosComanda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaServiciosComanda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TextMesa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextVCComanda)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BAgregarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BorrarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(345, 345, 345)
                                .addComponent(CrearComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextVCComanda)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAgregarServicio)
                    .addComponent(TextMesa)
                    .addComponent(CBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CrearComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(BorrarComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BAgregarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BAgregarServicioMouseClicked
        pAgregarServ.setVisible(true);
    }//GEN-LAST:event_BAgregarServicioMouseClicked

    private void CrearComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearComandaMouseClicked
        
        try {
            // 1. Obtener la mesa seleccionada
            int idMesa = Integer.parseInt((String) CBMesa.getSelectedItem());

            // 2. Crear comanda
            int idComanda = crud.crearComanda(idMesa, PPrincipal.id_empleado);

            // 3. Agregar servicios a la comanda
            for (Map.Entry<String, Integer> entry : serviciosCantidad.entrySet()) {
                String servicio = entry.getKey();
                int cantidad = entry.getValue();

                int idServicio = crud.seleccionarIDServicio(servicio);
                String estadoInicial = "SOL";

                int idDetalle = crud.insertarDetalleComanda(idComanda, idServicio, cantidad);

                // 4. Insertar en historial
                crud.actualizarEstado(estadoInicial, idDetalle);
            }

            // 5. Mostrar mensaje y limpiar
            JOptionPane.showMessageDialog(this, "Comanda creada exitosamente.");
            serviciosCantidad.clear();
            listaSer.clear();
            nuevoModelo.clear();
            ListaServiciosComanda.setModel(nuevoModelo);
            Dashboard.pvComandas.recargarComandas();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al crear la comanda.");
        }
        
    }//GEN-LAST:event_CrearComandaMouseClicked

    private void BorrarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarComandaMouseClicked

        serviciosCantidad.clear();
        listaSer.clear();
        nuevoModelo.clear();
        ListaServiciosComanda.setModel(nuevoModelo);
        
        JOptionPane.showMessageDialog(null, "Comanda Eliminada con Exito!");


    }//GEN-LAST:event_BorrarComandaMouseClicked
    //metodos adicionales que no son crud
    private void añadirMesas(){
        CBMesa.removeAllItems();
        
        for (int i = 1; i < 11; i++) {
            CBMesa.addItem("" + i);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregarServicio;
    private javax.swing.JButton BorrarComanda;
    private javax.swing.JComboBox<String> CBMesa;
    private javax.swing.JButton CrearComanda;
    private javax.swing.JList<String> ListaServiciosComanda;
    private javax.swing.JLabel TextMesa;
    private javax.swing.JLabel TextVCComanda;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public JList<String> getListaServiciosComanda() {
        return ListaServiciosComanda;
    }

    public void setListaServiciosComanda(JList<String> ListaSrviciosComanda) {
        this.ListaServiciosComanda = ListaSrviciosComanda;
    }
    
    public void rellenarInfoComanda(String servicio, String cantidad) {
        int cantNueva = Integer.parseInt(cantidad);

        // Si ya existe el servicio, suma la cantidad
        serviciosCantidad.merge(servicio, cantNueva, Integer::sum);

        // Actualizar la lista visual
        listaSer.clear();
        nuevoModelo.clear();

        for (Map.Entry<String, Integer> entry : serviciosCantidad.entrySet()) {
            String linea = "| " + entry.getKey() + " | " + entry.getValue() + " Unidades |";
            listaSer.add(linea);
            nuevoModelo.addElement(linea);
        }

        ListaServiciosComanda.setModel(nuevoModelo);
    }

    
}
