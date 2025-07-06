package igu;

import igu.Dashboard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import main.Crud;


/**
 *
 * @author ferfr
 */
public class PAgregarServicio extends javax.swing.JFrame {

    
    
    //crear el crud
    Crud crud = new Crud();
    
    //otras cosas
    Map<String,String> mapaTipos = new HashMap<>();;
    List<String> listaServicios = new ArrayList<>();
    String idTipo;
    int idServicio;
    boolean serviciosCargados = false;
    
    
    /**
     * Creates new form PAgregarServicio
     */
    public PAgregarServicio() {
        initComponents();
        cargarCantidad();
        cargarTipos();
        configurarEventos();
        Descripcion.setEditable(false);
        Descripcion.setLineWrap(true);             // activa el salto de línea automático
        Descripcion.setWrapStyleWord(true);        // corta solo por palabras completas

        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AgregarServicio = new javax.swing.JButton();
        CerrarVentana = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        CBServicios = new javax.swing.JComboBox<>();
        TextServi = new javax.swing.JLabel();
        CBCantidad = new javax.swing.JComboBox<>();
        TextDescrip = new javax.swing.JLabel();
        TextCant = new javax.swing.JLabel();
        TextTDServ = new javax.swing.JLabel();
        CBTipoServicio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AgregarServicio.setText("Agregar Servicio");
        AgregarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AgregarServicioMouseClicked(evt);
            }
        });

        CerrarVentana.setText("Cerrar");
        CerrarVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarVentanaMouseClicked(evt);
            }
        });

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        CBServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        CBServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBServiciosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CBServiciosMousePressed(evt);
            }
        });

        TextServi.setText("Servicios");

        CBCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TextDescrip.setText("Descripcion");

        TextCant.setText("Cantidad");

        TextTDServ.setText("Tipo de Servicio");

        CBTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBTipoServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CBTipoServicioMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AgregarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CerrarVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextServi)
                            .addComponent(TextDescrip))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextCant)
                            .addComponent(CBCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextTDServ)
                            .addComponent(CBTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TextTDServ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextServi)
                    .addComponent(TextCant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(TextDescrip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CerrarVentana, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(AgregarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void CBTipoServicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBTipoServicioMousePressed
    }//GEN-LAST:event_CBTipoServicioMousePressed

    private void CBServiciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBServiciosMousePressed
    }//GEN-LAST:event_CBServiciosMousePressed

    private void CBServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBServiciosMouseClicked
    }//GEN-LAST:event_CBServiciosMouseClicked

    private void AgregarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgregarServicioMouseClicked
        
        String servicio = CBServicios.getSelectedItem().toString();
        String cantidad = CBCantidad.getSelectedItem().toString();
            
        Dashboard.p_camarero.rellenarInfoComanda(servicio,cantidad);
            
        idServicio = crud.seleccionarIDServicio(servicio);

    }//GEN-LAST:event_AgregarServicioMouseClicked

    private void CerrarVentanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarVentanaMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_CerrarVentanaMouseClicked

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarServicio;
    private javax.swing.JComboBox<String> CBCantidad;
    private javax.swing.JComboBox<String> CBServicios;
    private javax.swing.JComboBox<String> CBTipoServicio;
    private javax.swing.JButton CerrarVentana;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JLabel TextCant;
    private javax.swing.JLabel TextDescrip;
    private javax.swing.JLabel TextServi;
    private javax.swing.JLabel TextTDServ;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarTipos() {
        //se añaden los tipos a mapaTipos
        crud.cargarTiposServicio(mapaTipos);
        
        CBTipoServicio.removeAllItems();
        
        //se añaden los nombres de los tipos a CBTipoServicio
        for (String nombreTipo: mapaTipos.keySet()) {
            CBTipoServicio.addItem(nombreTipo);
            
        }
    }
    private void cargarCantidad(){
        CBCantidad.removeAllItems();
        
        for (int i = 0; i < 10; i++) {
            CBCantidad.addItem(""+(i+1));
        }
        
    }
    private void configurarEventos() {
        
        CBTipoServicio.addActionListener( e -> {
            //se guarda el tipo seleccionado
            String tipoSeleccionado = (String) CBTipoServicio.getSelectedItem();
            
            //mientras no sea nulo y el tipo si exista
            if(tipoSeleccionado != null && mapaTipos.containsKey(tipoSeleccionado)){
                idTipo = mapaTipos.get(tipoSeleccionado);
                //se gurda el id del tipo y se limpia la lista
                listaServicios.clear();
                //se añaden los servicios a la listaServicios
                crud.cargarServiciosPorTipo(idTipo, listaServicios);
                //se eliminan los items del ComboBox y se añaden los nuevos
                CBServicios.removeAllItems();
                for(String servicio: listaServicios){
                    CBServicios.addItem(servicio);
                }
                
                
                
                
            }
        });
        
        CBServicios.addActionListener(e ->{
            String nombre = (String) CBServicios.getSelectedItem();
        
            if (nombre != null) {
                idServicio = crud.seleccionarIDServicio(nombre);
                crud.cargarDescripciones(idServicio, Descripcion);
            }
        });
        
        
        
        
    }

    
}
