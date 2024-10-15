package com.ludwing.pe.cnegocio;

import com.ludwing.pe.cdatosdao.TipoDocumentoDao;
import com.ludwing.pe.cmodelo.TipoDocumento;
import com.ludwing.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;


public class TipoDocumentoBO {
    private String mensaje;
    TipoDocumentoDao tdd = new TipoDocumentoDao();
    
    public String agregarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.agregarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String eliminarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.elimiarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String modificarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
   public void ListarTipoDocumento(JTable table) throws SQLException{
       Connection c = Conexion.getConnection();
       tdd.listarTipoDocumento(c, table);
        try {
           tdd.listarTipoDocumento(c, table);
       } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
       } finally {
            c.close();
       }
    }
}
