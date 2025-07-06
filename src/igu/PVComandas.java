package igu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import javax.swing.JOptionPane;
import main.Crud;

/**
 *
 * @author ferfr
 */
public class PVComandas extends javax.swing.JPanel {

    
    Crud crud = new Crud();
    
    private String idEstadoActual = "SOL";
    
    private Map<String,String> estados = Map.of(
            "SOL", "Solicitado",
            "PRE", "En Preparación",
            "LIS", "Listo para Servir",
            "SER", "Servido",
            "CAN", "Cancelado"
    );
    
    private List<String> ordenEstados = List.of("SOL","PRE","LIS","SER","CAN");
    
    private Map<Integer, Integer> indexToDetalleComanda = new HashMap<>();
    
    
    public PVComandas() {
        
        initComponents();
        TextMesa.setEditable(false);
        if (Crud.getIdUsuario() != 3) {
            BEliminarComanda.setVisible(false);
        }else{
            BEliminarComanda.setVisible(true);
        }
        rellenarCBoxes();
        listeners();
    }

    /**
     * 0.- cambiar los nombres de las cosas para no confundirse
     * 1.- Añadir las comandas al COMBOBOX DE LAS COMANDAS --
     * 2.- MOSTRAR LOS SERVICIOS DE LA COMANDA SELECCIONADA -*
     * 3.- MOSTRAR LOS ESTADOS DE LOS SERVICIOS DE LA COMANDA
     * 4.- MOSTRAR LOS TIPOS DE ESTADOS QUE HAY (NOMBRES NO ID)
     * 5.- ACTIVAR BOTON PARA QUE FUNCIONE EL CAMBIAR ESTADO
     * 7.- HACER UN JFRAME PARA EL BOTON DE BORRAR
     * 8.- MODIFICAR PARA QUE SOLO EL ADMIN PUEDA VER EL BOTON DE BORRAR COMANDAS
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextComandas = new javax.swing.JLabel();
        CBComandas = new javax.swing.JComboBox<>();
        TextServicios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaServicios = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaEstadosServicios = new javax.swing.JList<>();
        TextEstados = new javax.swing.JLabel();
        TextNuevoEstado = new javax.swing.JLabel();
        CBNombresEstados = new javax.swing.JComboBox<>();
        BCambiarEstado = new javax.swing.JButton();
        BEliminarComanda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextMesa = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(800, 577));
        setMinimumSize(new java.awt.Dimension(800, 577));
        setPreferredSize(new java.awt.Dimension(800, 577));

        TextComandas.setText("Comandas");

        CBComandas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TextServicios.setText("Servicios");

        ListaServicios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListaServicios);

        ListaEstadosServicios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaEstadosServicios);

        TextEstados.setText("Estados");

        TextNuevoEstado.setText("Nuevo Estado");

        CBNombresEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BCambiarEstado.setText("Cambiar Estado");

        BEliminarComanda.setBackground(new java.awt.Color(255, 102, 102));
        BEliminarComanda.setFont(new java.awt.Font("Algerian", 3, 10)); // NOI18N
        BEliminarComanda.setText("XXXXXXXXXXXXXXXXXXX");
        BEliminarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BEliminarComandaMouseClicked(evt);
            }
        });

        jLabel1.setText("Mesa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextServicios)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(TextComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(TextEstados))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(TextNuevoEstado))
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CBNombresEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BEliminarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextComandas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBComandas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TextMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextServicios)
                    .addComponent(TextEstados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(TextNuevoEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBNombresEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BEliminarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BEliminarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BEliminarComandaMouseClicked
        // CREAR EL JFRAME PARA BORRAR COMANDAS
    }//GEN-LAST:event_BEliminarComandaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCambiarEstado;
    private javax.swing.JButton BEliminarComanda;
    private javax.swing.JComboBox<String> CBComandas;
    private javax.swing.JComboBox<String> CBNombresEstados;
    private javax.swing.JList<String> ListaEstadosServicios;
    private javax.swing.JList<String> ListaServicios;
    private javax.swing.JLabel TextComandas;
    private javax.swing.JLabel TextEstados;
    private javax.swing.JTextField TextMesa;
    private javax.swing.JLabel TextNuevoEstado;
    private javax.swing.JLabel TextServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    private void rellenarCBoxes(){
        crud.rellenarCBComandas(CBComandas);
        CBNombresEstados.removeAllItems();
        for(String id : ordenEstados){
            CBNombresEstados.addItem(estados.get(id));
        }
        limpiarListas();
    }
    
    private void limpiarListas(){
        ListaServicios.setListData(new String[0]);
        ListaEstadosServicios.setListData(new String [0]);
        indexToDetalleComanda.clear();
    }
    
    private boolean esCambioValido(String idActual, String idNuevo){
        if (idActual == null || idNuevo == null) {
            return false;
        }
        return ordenEstados.indexOf(idNuevo) >= ordenEstados.indexOf(idActual);
    }
    
    private String getIdEstadoNombre(String nombre){
        
        for(Map.Entry<String, String> entry: estados.entrySet()){
            if (entry.getValue().equals(nombre)) {
                return entry.getKey();
            }
        }
        
        
        return null;
    }
    
    private void listeners(){
        
        
        //cuando se selecciona una comanda, carga servicios y estados
        CBComandas.addActionListener(e ->{
            String comandaSelec = (String) CBComandas.getSelectedItem();
            if (comandaSelec != null) {
                int idComanda = Integer.parseInt(comandaSelec.replaceAll("[^0-9]", ""));
                cargarServiciosYEstados(idComanda);
                crud.verMesaComanda(TextMesa,idComanda);
            }
        });
        //cuando se selecciona un nuevo estado
        CBNombresEstados.addActionListener(e -> {
            String nombreNuevo = (String) CBNombresEstados.getSelectedItem();
            
            if (nombreNuevo == null) {
                return;
            }
            
            String idNuevo = null;
            for(Map.Entry<String,String> entry: estados.entrySet()){
                if (entry.getValue().equals(nombreNuevo)) {
                    idNuevo = entry.getKey();
                    break;
                }
                
            }
            if (idNuevo != null && !esCambioValido(idEstadoActual, idNuevo)) {
                JOptionPane.showMessageDialog(this, "No puedes volver a un estado anterior.","Cambio invalido",JOptionPane.WARNING_MESSAGE);
                CBNombresEstados.setSelectedItem(estados.get(idEstadoActual));
            }
                    
        });
        /////////////////////////////////////////
        BCambiarEstado.addActionListener( e ->{
            int idServicio = ListaServicios.getSelectedIndex();
            if (idServicio == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un servicio para cambiar su estado");
                return;
            }
            
            String nombreNuevoEstado = (String) CBNombresEstados.getSelectedItem();
            if (nombreNuevoEstado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un nuevo estado");
                return;
            }
            String idNuevoEstado = getIdEstadoNombre(nombreNuevoEstado);
            if (idNuevoEstado == null) {
                JOptionPane.showMessageDialog(this, "Estado Invalido");
                return;
            }
            
            int idDetalleComanda = indexToDetalleComanda.get(idServicio);
            if (!indexToDetalleComanda.containsKey(idServicio)) {
                JOptionPane.showMessageDialog(this,"No se pudo encontrar el detalle de la comanda");
                return;
            }
            
            //Se obtiene el estado actual desde la base de datos o desde la lista que se muestra
            String estadoActualNombre = ListaEstadosServicios.getModel().getElementAt(idServicio);
            String idEstadoActual = getIdEstadoNombre(estadoActualNombre);
            
            if (!esCambioValido(idEstadoActual,idNuevoEstado)) {
                JOptionPane.showMessageDialog(this, "No puedes volver a un estado anterior");
                return;
            }
            
            //actualizar la bd y refrescar listas
            crud.actualizarEstado(idNuevoEstado, idDetalleComanda);
            //recargar lista actualizada
            String selectedComanda = (String) CBComandas.getSelectedItem();
            if (selectedComanda != null) {
                int idComanda = Integer.parseInt(selectedComanda.replaceAll("[^0-9]", ""));
                                
                cargarServiciosYEstados(idComanda);
            }
            
        });
    }
    
    public void cargarServiciosYEstados(int idComanda){
        
        limpiarListas();
        List<Object[]> datos = crud.cargarServiciosYEstados(idComanda);
        
        List<String> servicios = new ArrayList<>();
        List<String> estados = new ArrayList<>();
        
        for (int i = 0; i < datos.size(); i++) {
            Object[] fila = datos.get(i);
            int idDetalle = (int) fila[0];
            String servicio = (String) fila[1];
            String estado = (String) fila[2];
            
            servicios.add(servicio);
            estados.add(estado);
            indexToDetalleComanda.put(i, idDetalle); // para saber que id actualizar
        }
        
        ListaServicios.setListData(servicios.toArray(new String[0]));
        ListaEstadosServicios.setListData(estados.toArray(new String[0]));
    }
    
    public void recargarComandas(){
        crud.rellenarCBComandas(CBComandas);
    }
    
}
