package es.ucm.abd.practica2.view;

import es.ucm.abd.practica2.controller.SearchPanelController;
import es.ucm.abd.practica2.model.Abedemon;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Panel de búsqueda de Abedemon.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class SearchPanel extends javax.swing.JPanel {
    private SearchPanelController controller;
    
    /**
     * Creates new form SearchPanel
     */
    public SearchPanel() {
        initComponents();
        textPaneAbedemons.setEditable(false);
        textPaneAbedemons.setContentType("text/html");
    }
    
    public Abedemon getSelectedAbedemon() {
        return controller.getAbedemon(tableAbedemons.getSelectedRow());
    }


    public void setController(SearchPanelController controller) {
        this.controller = controller;
        comboTipos.setModel(controller.getTypes());
        comboTipos.setSelectedIndex(0);
        tableAbedemons.setModel(controller.getAbedemons());
        tableAbedemons.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tableAbedemons.getSelectedRow() != -1) {
                    String info = controller.getAbedemonInfo(tableAbedemons.getSelectedRow());
                    textPaneAbedemons.setText(info);
                    textPaneAbedemons.setCaretPosition(0);
                }
            }
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboTipos = new javax.swing.JComboBox();
        labelTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAbedemons = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneAbedemons = new javax.swing.JTextPane();

        comboTipos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[Todos]" }));
        comboTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiposActionPerformed(evt);
            }
        });

        labelTipo.setText("Buscar por tipo:");

        tableAbedemons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Num. Poderes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(tableAbedemons);

        textPaneAbedemons.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                textPaneAbedemonsHyperlinkUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(textPaneAbedemons);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiposActionPerformed
        controller.searchAbedemonsOf(comboTipos.getSelectedIndex());
    }//GEN-LAST:event_comboTiposActionPerformed

    private void textPaneAbedemonsHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_textPaneAbedemonsHyperlinkUpdate
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            String id = evt.getDescription();
            String info = controller.getAbedemonInfo(id);
            textPaneAbedemons.setText(info);
            textPaneAbedemons.setCaretPosition(0);            
        }
    }//GEN-LAST:event_textPaneAbedemonsHyperlinkUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboTipos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTable tableAbedemons;
    private javax.swing.JTextPane textPaneAbedemons;
    // End of variables declaration//GEN-END:variables
}
