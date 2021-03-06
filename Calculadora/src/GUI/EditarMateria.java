/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import datos.MateriaBD;
import javax.swing.JOptionPane;
import logica.Estudiante;
import logica.Materia;


public class EditarMateria extends javax.swing.JFrame {
     private Estudiante e;
     private Materia m;
     private MateriaBD materiabd = new MateriaBD();
     private Editar editar;

    /**
     * Creates new form EditarMateria
     */
    public EditarMateria() {
        initComponents();
    }
    
     public void recibirDatos(Estudiante estudiante){
        e = estudiante;
    }
     
     public void recibirMateria(Materia materia){
         m=materia;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese el nombre , la nota acumulada y los creditos de la materia.");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Nota:");

        jLabel4.setText("Creditos:");

        jButton1.setText("Guardar");
        jButton1.setActionCommand("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Materia materia = new Materia();
        try {
            materia.setId(m.getId());
            if (jTextField1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
            } else {
                materia.setNombre(jTextField1.getText());
                materia.setNota(Double.parseDouble(jTextField2.getText()));
                materia.setCreditos(Integer.parseInt(jTextField3.getText()));
                if (materia.getCreditos() <= 0 || materia.getNota() < 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un valor valido");
                } else {
                    for (int i = 0; i < e.getCarrera().getMaterias().size(); i++) {
                        Materia comparar = e.getCarrera().getMaterias().get(i);
                        if(materia.getId().equals(comparar.getId())){
                            e.getCarrera().getMaterias().remove(i);
                            e.getCarrera().getMaterias().add(materia);
                            break;
                        }
                        
                    }
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    materiabd.actualizarMateria(materia, e);
                    JOptionPane.showMessageDialog(this, "Cambios guardados");
                }
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(this, "No ingreso un número");
        }catch(Exception a){
            System.out.println(a);
        }
        editar= new Editar();
        editar.recibirDatos(e);
        editar.cargar();
        editar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
