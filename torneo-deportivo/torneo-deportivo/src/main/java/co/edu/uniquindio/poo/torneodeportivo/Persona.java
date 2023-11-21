package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * clase llamada Persona con atributos de una persona 
 */
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
public class Persona {
    // atributo
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;
     //constructor 
    public Persona(String nombre,String apellido,String email, String celular){
        //assertions
        ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        ASSERTION.assertion( apellido != null && !apellido.isBlank() , "El apellido es requerido");
        ASSERTION.assertion( celular != null && !celular.isBlank() , "El celular es requerido");
        ASSERTION.assertion( email != null && !email.isBlank() , "El email es requerido");
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;

    }
    //metodos de acceso 
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }


    
}
