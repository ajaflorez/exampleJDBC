package model;

public class Asegurado {
    private String autogenerado;
    private String dni;
    private String paterno;
    private String materno;
    private String nombres;
    private String fec_nac;
    private String tipo;

    public Asegurado(String autogenerado, String dni, String paterno, String materno, String nombres, String fec_nac, String tipo) {
        this.autogenerado = autogenerado;
        this.dni = dni;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.fec_nac = fec_nac;
        this.tipo = tipo;
    }

    public String getAutogenerado() {
        return autogenerado;
    }
    public String getDni() {
        return dni;
    }
    public String getPaterno() {
        return paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public String getNombres() {
        return nombres;
    }
    public String getFec_nac() {
        return fec_nac;
    }
    public String getTipo() {
        return tipo;
    }
    @Override
    public String toString() {
        return autogenerado + " " + dni + " " + paterno + " " + materno + " " + nombres + " " + fec_nac + " " + tipo;
    }
}
