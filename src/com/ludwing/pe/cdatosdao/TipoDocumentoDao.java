package com.ludwing.pe.cdatosdao;

import com.ludwing.pe.cmodelo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class TipoDocumentoDao {
    private String mensaje;
    
    
    
    //Primer metodo ´INSERTAR TIPO DOCUMENTO A LA DB
    public String agregarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "INSERT INTO TIPO_DOCUMENTO(NOMBRE,SIGLA,ESTADO,ORDEN)" + "VALUES(?,?,?,?)";
                
               
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            //ps.setDate(5,  tipoDocumento.getFecha());
            
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue creado correctamente";
            
            
            
            
        } catch (Exception e) {
            mensaje = "Alto! error al crear tipo documento. "+ e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
   //Segundo Metodo Eliminar   
 public String elimiarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "DELETE FROM TIPO_DOCUMENTO WHERE ID_TIPO_DOCUMENTO = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoDocumento.getIdTipoDocumento());
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue eliminado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al eliminar tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    //Tercero Metodo - Modificar Tipo documento.
    public String modificarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "UPDATE TIPO_DOCUMENTO "
                + " SET NOMBRE=?, SIGLA=?, ESTADO=?, ORDEN=?"
                + " WHERE ID_TIPO_DOCUMENTO=?";
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            ps.setInt(5, tipoDocumento.getIdTipoDocumento());
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue actualizado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al actualizar tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    //Cuarto Metodo - Listar Documento.
    public void listarTipoDocumento(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resulSet = null;
        
        String [] columnas = {"ID","NOMBRE","SIGLA","ESTADO","ORDEN"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM TIPO_DOCUMENTO";
        String[] datosTP = new String[5];
        
        try {
            statement = conn.createStatement();
            resulSet = statement.executeQuery(sql);
            
            
            while(resulSet.next()){
                TipoDocumento td = new TipoDocumento();
                td.setIdTipoDocumento(resulSet.getInt("ID_TIPO_DOCUMENTO"));
                td.setNombre(resulSet.getString("NOMBRE"));
                td.setEstado(resulSet.getString("ESTADO"));
                td.setOrden(resulSet.getInt("ORDEN"));
                td.setSigla(resulSet.getString("SIGLA"));
                
                datosTP[0] = td.getIdTipoDocumento()+"";
                datosTP[1] = td.getNombre()+"";
                datosTP[2] = td.getSigla()+"";
                datosTP[3] = td.getEstado()+"";
                datosTP[4] = td.getOrden()+"";
                
                
                model.addRow(datosTP);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
