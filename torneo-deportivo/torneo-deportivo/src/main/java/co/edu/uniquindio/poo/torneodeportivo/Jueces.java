package co.edu.uniquindio.poo.torneodeportivo;

public class Jueces extends Persona{

    private String licenciaDeJuez;

    public Jueces(String nombre, String apellido, String email, String celular, String licenciaDeJuez) {
        super(nombre, apellido, email, celular);
        this.licenciaDeJuez = licenciaDeJuez;
    }

    public String getLicenciaDeJuez() {
        return licenciaDeJuez;
    }

    public void setLicenciaDeJuez(String licenciaDeJuez) {
        this.licenciaDeJuez = licenciaDeJuez;
    }

}