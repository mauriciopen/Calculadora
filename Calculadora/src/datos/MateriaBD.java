/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Estudiante;
import logica.Materia;


public class MateriaBD {
    private Conexion cn;
    
    public MateriaBD(){
        cn = new Conexion();
    }
    
     public ResultSet getMateriaById(String id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT "
                + " con_nombre"
                + " con_creditos,"
                + " con_nota,"
                + " con_usuario_estudiante,"
                + " FROM materias "
                + " WHERE con_name = ? ");
        pstm.setString(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    
     /**
     * trae todos los registros de la tabla materias
     */
    public ResultSet getMaterias() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre,"
                + " con_creditos,"
                + " con_nota,"
                + " con_usuario_estudiante "
                + " FROM materias "
                + " ORDER BY con_usuario_estudiante, con_nombre ");


        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarMateria(Estudiante e, Materia m) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into materias (con_id,"
                    + " con_nombre, "
                    + " con_creditos,"
                    + " con_nota,"
                    + " con_usuario_estudiante)"
                    + " values(?,?,?,?,?)");
            pstm.setString(1, m.getId());
            pstm.setString(2, m.getNombre());
            pstm.setInt(3, m.getCreditos());
            pstm.setDouble(4, m.getNota());
            pstm.setString(5, e.getUsuario());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
      public void actualizarMateria(Materia m, Estudiante e) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update materias set con_nombre = ?, "
                    + " con_creditos = ?,"
                    + " con_nota = ?,"
                    + " con_usuario_estudiante = ?"
                    + " where (con_id = ?)");
            pstm.setString(1, m.getNombre());
            pstm.setInt(2, m.getCreditos());
            pstm.setDouble(3, m.getNota());
            pstm.setString(4, e.getUsuario());
            pstm.setString(5, m.getId());

            pstm.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
      
    public void borrarMateria(Materia m) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from materias "
                    + " where con_id = ?");

            pstm.setString(1,m.getId() );

            pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
