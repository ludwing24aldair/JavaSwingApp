package com.ludwing.pe.ctest;

import com.ludwing.pe.cmodelo.TipoDocumento;
import com.ludwing.pe.cnegocio.TipoDocumentoBO;
import java.sql.SQLException;

public class Test {
    TipoDocumentoBO tdbo = new TipoDocumentoBO();
    TipoDocumento td =  new TipoDocumento();
    
    public void insertar() throws SQLException{
        td.setNombre("Registro Nacional de Identidad");
        td.setEstado("1");
      //  td.setFecha(1);
        td.setOrden(1);
        td.setSigla("DNI");
        
        tdbo.agregarTipoDocumento(td);
    }
    
    public static void main(String[] args) throws SQLException {
        Test test = new Test();
        test.insertar();
    }
}
