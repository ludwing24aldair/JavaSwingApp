package com.ludwing.pe.cdatosdao;

import com.ludwing.pe.cmodelo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;


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
    
    //modificar metodo - modificar Tipo Documento
}
