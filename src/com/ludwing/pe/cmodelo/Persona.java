package com.ludwing.pe.cmodelo;

import java.util.Date;

   public class Persona {
        private int idpersona;
        private String nombre;
        private String apellid;
        private String documento;
        private Date FechaNacimint;
        private String correo;
        private String telefono;
        private String genero;

        public Persona(int idpersona, String nombre, String apellid, String documento, Date FechaNacimint, String correo, String telefono, String genero) {
            this.idpersona = idpersona;
            this.nombre = nombre;
            this.apellid = apellid;
            this.documento = documento;
            this.FechaNacimint = FechaNacimint;
            this.correo = correo;
            this.telefono = telefono;
            this.genero = genero;
        }

        public int getIdpersona() {
            return idpersona;
        }

        public void setIdpersona(int idpersona) {
            this.idpersona = idpersona;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellid() {
            return apellid;
        }

        public void setApellid(String apellid) {
            this.apellid = apellid;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public Date getFechaNacimint() {
            return FechaNacimint;
        }

        public void setFechaNacimint(Date FechaNacimint) {
            this.FechaNacimint = FechaNacimint;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }
           
    }
    