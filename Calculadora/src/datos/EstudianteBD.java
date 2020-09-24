package datos;


import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logica.Estudiante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class EstudianteBD {
    
    private Conexion cn;
    
    public EstudianteBD(){
        cn = new Conexion();
    }
    
     public ResultSet getEstudianteByUsuario(String usu) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT "
                + " con_usuario,"
                + " con_nombre, "
                + " con_nombre_carrera,"
                + " con_contraseña,"
                + " con_ponderado,"
                + " con_avance,"
                + " con_creditos_cursados,"
                + " con_cantidad_creditos "
                + " FROM lista "
                + " WHERE con_usuario = ? ");
        pstm.setString(1, usu);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }
    
     /**
     * trae todos los registros de la tabla estudiantes
     */
    public ResultSet getEstudiantes() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT  "
                + " con_usuario ,"
                + " con_nombre, "
                + " con_nombre_carrera,"
                + " con_contraseña,"
                + " con_ponderado ,"
                + " con_avance ,"
                + " con_creditos_cursados ,"
                + " con_cantidad_creditos  "
                + " FROM lista "
                + " ORDER BY con_nombre, con_nombre_carrera ");


        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarEstudiante(Estudiante e) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into lista (con_nombre, "
                    + " con_nombre_carrera,"
                    + " con_usuario,"
                    + " con_contraseña ,"
                    + " con_ponderado ,"
                    + " con_avance,"
                    + " con_creditos_cursados ,"
                    + " con_cantidad_creditos) "
                    + " values(?,?,?,?,?,?,?,?)");
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getNombreCarrera());
            pstm.setString(3, e.getUsuario());
            pstm.setString(4, e.getContraseña());
            pstm.setDouble(5, e.getCarrera().getPonderado());
            pstm.setDouble(6, e.getCarrera().getAvance());
            pstm.setDouble(7, e.getCarrera().getCreditosCursados());
            pstm.setDouble(8, e.getCarrera().getCantidadCreditos());

            pstm.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
      public void actualizarEstudiante(Estudiante e) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update lista set con_nombre = ?, "
                    + " con_nombre_carrera = ?,"
                    + " con_contraseña = ?,"
                    + " con_ponderado = ?,"
                    + " con_avance = ?,"
                    + " con_creditos_cursados = ?,"
                    + " con_cantidad_creditos = ? "
                    + " where con_usuario = ?");
            pstm.setString(1, e.getNombre());
            pstm.setString(2, e.getNombreCarrera());
            pstm.setString(3, e.getContraseña());
            pstm.setDouble(4, e.getCarrera().getPonderado());
            pstm.setDouble(5, e.getCarrera().getAvance());
            pstm.setDouble(6, e.getCarrera().getCreditosCursados());
            pstm.setDouble(7, e.getCarrera().getCantidadCreditos());
            pstm.setString(8, e.getUsuario());

            pstm.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
      
    public void borrarEstudiante(Estudiante e) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from lista "
                    + " where con_usuario = ?");

            pstm.setString(1, e.getUsuario());

            pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
