package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada Juez que extiende de la clase persona, hay sobrecarga de metodo, esta clase tiene un atributo propio de 
 * la licencia del Juez
 */
public class Juez extends Persona {
    //atributos
    private String licenciaDeJuez;
    //cosntructor
    public Juez(String nombre, String apellido, String email, String celular, TipoGenero genero,
            String licenciaDeJuez) {
        super(nombre, apellido, email, celular);
       //assertion
        assert licenciaDeJuez != null && !licenciaDeJuez.isBlank(): "Debe ingresar el nombre";
        
        this.licenciaDeJuez = licenciaDeJuez;
    }
    //metodos de acceso 
    public String getLicenciaDeJuez() {
        return licenciaDeJuez;
    }

    public void setLicenciaDeJuez(String licenciaDeJuez) {
        this.licenciaDeJuez = licenciaDeJuez;
    }
    
}