package com.ludwing.pe.cnegocio;

import com.ludwing.pe.cdatosdao.TipoDocumentoDao;
import com.ludwing.pe.cmodelo.TipoDocumento;
import com.ludwing.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;


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
}
