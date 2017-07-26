package model;

public class Medico {
    private String idMedico;
    private String paterno;
    private String materno;
    private String nombres;
    private String idEspecial;

    public Medico(String idMedico, String paterno, String materno, String nombres, String idespecial) {
        this.idMedico = idMedico;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.idEspecial = idespecial;
    }
    public String getIdMedico() {
        return idMedico;
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
    public String getIdespecial() {
        return idEspecial;
    }

    @Override
    public String toString() {
        return this.idMedico + " " + this.paterno + " " + this.materno + " " + 
                this.nombres + " " + this.idEspecial;
    }
}
