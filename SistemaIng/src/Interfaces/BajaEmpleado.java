

package Interfaces;

import Modelos.ConexionBD;
import java.sql.SQLException;


public class BajaEmpleado extends javax.swing.JFrame {
    ConexionBD conexion = new ConexionBD();
    String eLegajo;
    String dni;
    
   
    public BajaEmpleado() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        legajo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Legajo");

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ok(evt);
            }
        });

        jScrollPane3.setViewportView(jTextPane2);

        jButton2.setText("Atras");

        jButton3.setText("Listado Empleados");

        jButton4.setText("Dar Baja");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarBaja(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(legajo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(99, 99, 99)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(legajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Ok(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ok
        eLegajo = legajo.getText();
        conexion.Conectar();
        try{
            conexion.setS(conexion.getConexion().createStatement());
            conexion.setRs(conexion.getS().executeQuery("SELECT * FROM empleado Where elegajo ='"+eLegajo+"';"));
            if(conexion.getRs().next()){
                jTextPane2.setText("Legajo:"+conexion.getRs().getString("elegajo")+"\nNombre:"+conexion.getRs().getString("nombre")+"\nDNI:"+conexion.getRs().getString("dni")+"\nTelefono:"+conexion.getRs().getString("telefono"));
                dni = conexion.getRs().getString("dni");
            }
            else{
                jTextPane2.setText("**No existe empleado con ese Numero de legajo**");
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_Ok

    private void DarBaja(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarBaja
        try{
            conexion.setS(conexion.getConexion().createStatement());
            conexion.getS().executeUpdate("DELETE FROM empleado WHERE elegajo='"+eLegajo+"'");
            jTextPane2.setText("");
            legajo.setText("");
            conexion.getS().executeUpdate("DELETE FROM usuario WHERE dni ='" +dni+"'");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_DarBaja

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextField legajo;
    // End of variables declaration//GEN-END:variables
}
