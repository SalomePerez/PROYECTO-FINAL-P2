
package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada Jugador que extiende de la clase Persona cpn 2 atributos propios como lo es el genero y la fecha de nacimiento 
 */
import java.time.LocalDate;
import java.time.Period;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Jugador extends Persona {
    //atributos
    private final LocalDate fechaNacimiento;
    private TipoGenero genero;
    //cosntructor
    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, TipoGenero genero) {
        super(nombre, apellido, email, celular);
        ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
          // ASSERTION.assertion(Torneo.getGenero==genero);
        this.fechaNacimiento = fechaNacimiento;
    }
    //metodos de acceso 
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }
    
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */

}
