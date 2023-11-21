
package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada Equipo tiene varios atributos y metodos propios de un equipo y es un aclase de tipo record
 */
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public record Equipo(String nombre,Persona representante,Collection<Jugador> jugadores) {
    //constructor
    public Equipo{
        ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        ASSERTION.assertion( representante != null , "El representante es requerido");
    }
    //cosntructor
    public Equipo(String nombre,Persona representante){
        this(nombre,representante,new LinkedList<>());
    }

    /**
     * Permite registrar un jugador en un equipo siempre y cuando no exista ya un jugador registrado en el equipo con el mismo nombre y apellido
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Jugador jugador) {
        validarJugadorExiste(jugador);
        jugadores.add(jugador);
    }

    /**
     * Permimte buscar un jugador en el equipo basado en su nombre y apellido.
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador que coincida con el nombre y apellido del jugador buscado, 
     * o Optinal vacío en caso de no encontrar un jugador en el equipo con dicho nombre y apellido.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador){
        Predicate<Jugador> nombreIgual = j->j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j->j.getApellido().equals(jugador.getApellido());
        return jugadores.stream().filter(nombreIgual.and(apellidoIgual)).findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido
     * @param jugador
     * @throws se genra un error en caso de haberlo genera un assertion error.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion( !existeJugador,"El jugador ya esta registrado");
    }
}
