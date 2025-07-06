package igu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Crud;

/**
 *
 * @author ferfr
 */
public class P_Camarero extends javax.swing.JPanel {
    
    
    //variables escenciales
    public static PAgregarServicio pAgregarServ = new PAgregarServicio();
    
    
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
        ListaSrviciosComanda = new javax.swing.JList<>();

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

        ListaSrviciosComanda.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListaSrviciosComanda);

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
        // TODO add your handling code here:
    }//GEN-LAST:event_CrearComandaMouseClicked

    private void BorrarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BorrarComandaMouseClicked
        // TODO add your handling code here:
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
    private javax.swing.JList<String> ListaSrviciosComanda;
    private javax.swing.JLabel TextMesa;
    private javax.swing.JLabel TextVCComanda;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public JList<String> getListaSrviciosComanda() {
        return ListaSrviciosComanda;
    }

    public void setListaSrviciosComanda(JList<String> ListaSrviciosComanda) {
        this.ListaSrviciosComanda = ListaSrviciosComanda;
    }
    
    public void rellenarInfoComanda(String servicio, String cantidad){
        String nuevo = "| " + servicio + " | " + cantidad + " Unidades |";
        
    }

    public JComboBox<String> getCBMesa() {
        return CBMesa;
    }
    
}
