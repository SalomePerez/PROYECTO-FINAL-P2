package co.edu.uniquindio.poo.torneodeportivo;

public class Juez extends Persona {

    private String licenciaDeJuez;

    

    public Juez(String nombre, String apellido, String email, String celular, TipoGenero genero,
            String licenciaDeJuez) {
        super(nombre, apellido, email, celular, genero);
        this.licenciaDeJuez = licenciaDeJuez;
    }

    public String getLicenciaDeJuez() {
        return licenciaDeJuez;
    }

    public void setLicenciaDeJuez(String licenciaDeJuez) {
        this.licenciaDeJuez = licenciaDeJuez;
    }
    
}