package com.ludwing.pe.ctest;

import com.ludwing.pe.cmodelo.TipoDocumento;
import com.ludwing.pe.cnegocio.TipoDocumentoBO;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {
    TipoDocumentoBO tdbo = new TipoDocumentoBO();
    TipoDocumento td =  new TipoDocumento();
    
    public void insertar() throws SQLException{
        td.setNombre("Registro Nacional de Identidad");
        td.setEstado("1");
        td.setOrden(1);
        td.setSigla("DNI");
        
        tdbo.agregarTipoDocumento(td);
    }
    
    public  void eliminar() throws SQLException, ParseException{
        td.setIdTipoDocumento(2);
        tdbo.eliminarTipoDocomento(td);
    }
    
    public  void modificar() throws SQLException, ParseException{
        td.setNombre("Diego");
        td.setEstado("1");
        td.setOrden(1);
        td.setSigla("D");
        td.setIdTipoDocumento(21);
        
        tdbo.modificarTipoDocumento(td);
    }
    public static void main(String[] args) throws SQLException, ParseException {
        Test t = new Test();
      t.insertar();
      //t.eliminar();
      //t.modificar();
    }
}
