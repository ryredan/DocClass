/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulosrg.docclass;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author User
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    
    private ArrayList<Integer> tipoDocumentalIds;
    private ArrayList<Integer> propriedadeIds;
    private ArrayList<Integer> propriedadeValorIds;
    
    public MainWindow() {
        initComponents();
        
        String address = "localhost";
        String database = "pcdoc_database";
        
        String url = "jdbc:postgresql://" + address + "/" + database;
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","");
        try {
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement ps = this.conn.prepareStatement("SELECT id, descricao FROM tipo_documental");
            ResultSet result = ps.executeQuery();
            this.tipoDocumentalIds = new ArrayList<>();
            while(result.next()){
                this.tipoDocumentalIds.add(result.getInt("id"));
                ((DefaultComboBoxModel)this.tipo_documental.getModel()).addElement(result.getString("descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tipo_documental = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        propriedade = new javax.swing.JComboBox<>();
        valores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo documental:");

        tipo_documental.setModel(new DefaultComboBoxModel<>());
        tipo_documental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_documentalActionPerformed(evt);
            }
        });

        jLabel2.setText("Propriedade:");

        propriedade.setModel(new DefaultComboBoxModel<>());
        propriedade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propriedadeActionPerformed(evt);
            }
        });

        valores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valoresActionPerformed(evt);
            }
        });

        jLabel3.setText("Valores:");

        jLabel4.setText("Dicionário:");

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipo_documental, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(propriedade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipo_documental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(propriedade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_documentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_documentalActionPerformed
        try {
            this.propriedade.setModel(new DefaultComboBoxModel<>());
            PreparedStatement ps = this.conn.prepareStatement("SELECT propriedade.id, propriedade.nome_propriedade FROM propriedade INNER JOIN tipo_documental ON propriedade.modelo_alfresco_id = tipo_documental.modelo_alfresco_id WHERE tipo_documental.id = ? AND list");
            ps.setInt(1, tipoDocumentalIds.get(this.tipo_documental.getSelectedIndex()));
            ResultSet result = ps.executeQuery();
            this.propriedadeIds = new ArrayList<>();
            ArrayList<String> modelValues = new ArrayList<>();
            while(result.next()){
                this.propriedadeIds.add(result.getInt("id"));
                modelValues.add(result.getString("nome_propriedade"));
            }
            if(!modelValues.isEmpty()){
                ((DefaultComboBoxModel)this.propriedade.getModel()).addAll(modelValues);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tipo_documentalActionPerformed

    private void propriedadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propriedadeActionPerformed
        try {
            valores.setModel(new DefaultComboBoxModel<>());
            PreparedStatement ps = this.conn.prepareStatement("SELECT valor_lista_propriedade.id, valor_lista_propriedade.valor FROM valor_lista_propriedade INNER JOIN propriedade ON valor_lista_propriedade.propriedade_id = propriedade.id WHERE propriedade_id = ?");
            ps.setInt(1, propriedadeIds.get(propriedade.getSelectedIndex()));
            ResultSet result = ps.executeQuery();
            ArrayList<String> modelValues = new ArrayList<>();
            propriedadeValorIds = new ArrayList<>();
            while(result.next()){
                propriedadeValorIds.add(result.getInt("id"));
                modelValues.add(result.getString("valor"));
            }
            ((DefaultComboBoxModel)valores.getModel()).addAll(modelValues);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_propriedadeActionPerformed

    private void valoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valoresActionPerformed
        jList1.setModel(new DefaultListModel<>());
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT palavra FROM dicionario_propriedade INNER JOIN valor_lista_propriedade ON dicionario_propriedade.valor_propriedade_id = valor_lista_propriedade.id WHERE valor_lista_propriedade.id = ?");
            ps.setInt(1, propriedadeValorIds.get(valores.getSelectedIndex()));
            ResultSet rs = ps.executeQuery();
            this.dicioWords = new ArrayList<>();
            while(rs.next()){
                this.dicioWords.addAll(Arrays.asList((String[]) rs.getArray("palavra").getArray()));
                ((DefaultListModel)jList1.getModel()).addAll(dicioWords);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_valoresActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!jTextField1.getText().isEmpty()){
            dicioWords.add(jTextField1.getText());
            jTextField1.setText("");
            jList1.setModel(new DefaultListModel<>());
            ((DefaultListModel)jList1.getModel()).addAll(dicioWords);
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM dicionario_propriedade WHERE valor_propriedade_id = ?");
            ps.setInt(1, propriedadeValorIds.get(valores.getSelectedIndex()));
            ResultSet rs = ps.executeQuery();
            Array words = conn.createArrayOf("VARCHAR", dicioWords.toArray());
            if(!rs.next()){
                PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO dicionario_propriedade (palavra, valor_propriedade_id) VALUES (?, ?)");
                insertStmt.setArray(1, words);
                insertStmt.setInt(2, propriedadeValorIds.get(valores.getSelectedIndex()));
                insertStmt.execute();
            }else{
                PreparedStatement updateStmt = conn.prepareStatement("UPDATE dicionario_propriedade SET palavra = ? WHERE valor_propriedade_id = ?");
                updateStmt.setArray(1, words);
                updateStmt.setInt(2, propriedadeValorIds.get(valores.getSelectedIndex()));
                updateStmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dicioWords.remove(jList1.getSelectedIndex());
        ((DefaultListModel)jList1.getModel()).remove(jList1.getSelectedIndex());
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    
    Connection conn;
    ArrayList<String> dicioWords;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> propriedade;
    private javax.swing.JComboBox<String> tipo_documental;
    private javax.swing.JComboBox<String> valores;
    // End of variables declaration//GEN-END:variables
}
