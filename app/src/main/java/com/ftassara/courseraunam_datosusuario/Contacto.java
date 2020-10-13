package com.ftassara.courseraunam_datosusuario;

import java.util.Date;

public class Contacto {

    private String Contacto;
    private String Telefono;
    private String Mail;
    private String FechaNac;
    private String Descripcion;

    public Contacto(String contacto, String telefono, String mail, String fechaNac, String descripcion) {
        Contacto = contacto;
        Telefono = telefono;
        Mail = mail;
        FechaNac = fechaNac;
        Descripcion = descripcion;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String contacto) {
        Contacto = contacto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String fechaNac) {
        FechaNac = fechaNac;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
