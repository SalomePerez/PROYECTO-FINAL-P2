/**
 * Clase que agrupa los datos de un Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Torneo {

    private final String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaInicioInscripciones;
    private LocalDate fechaCierreInscripciones;
    private final byte numeroParticipantes;
    private final byte limiteEdad;
    private final int valorInscripcion;
    private final TipoTorneo tipoTorneo;
    private final Collection<Participante> participantes;
    private final Collection<Equipo> equipos;
    private final TipoGeneroTorneo genero;    
    private ArrayList<Juez> listaDeJueces = new ArrayList<>();
    private ArrayList<MatchDay> enfrentamientos = new ArrayList<>();
    private CaracterTorneo caracter;
    private Marcador marcador;

    public Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
            LocalDate fechaCierreInscripciones, byte numeroParticipantes, byte limiteEdad, int valorInscripcion,
            TipoTorneo tipoTorneo, Collection<Participante> participantes, Collection<Equipo> equipos, TipoGeneroTorneo genero, ArrayList<Juez> listaDeJueces,CaracterTorneo caracter, Marcador marcador) {


                ASSERTION.assertion(nombre != null, "El nombre es requerido");
                ASSERTION.assertion(numeroParticipantes >= 0, "El número de participantes no puede ser negativo");
                ASSERTION.assertion(limiteEdad >= 0, "El limite de edad no puede ser negativo");
                ASSERTION.assertion(valorInscripcion >= 0, "El valor de la inscripción no puede ser negativo");
                
                this.nombre = nombre;
                this.participantes = new LinkedList<>();
                
        setFechaInicioInscripciones(fechaInicioInscripciones);
        setFechaCierreInscripciones(fechaCierreInscripciones);
        setFechaInicio(fechaInicio);
        this.numeroParticipantes = numeroParticipantes;
        this.limiteEdad = limiteEdad;
        this.valorInscripcion = valorInscripcion;
        this.tipoTorneo = tipoTorneo;
        this.equipos = new LinkedList<>();
        this.genero = genero;
        this.listaDeJueces = new ArrayList<>();
        this.enfrentamientos = new ArrayList<>();
        this.listaDeJueces=listaDeJueces;
        this.caracter=  Objects.requireNonNull(caracter, "El carácter del torneo es requerido");
        this.marcador=marcador;

    }


    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaInicioInscripciones() {
        return fechaInicioInscripciones;
    }

    public LocalDate getFechaCierreInscripciones() {
        return fechaCierreInscripciones;
    }

    public byte getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public byte getLimiteEdad() {
        return limiteEdad;
    }

    public int getValorInscripcion() {
        return valorInscripcion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        ASSERTION.assertion(fechaInicio != null, "La fecha de inicio es requerida");
        ASSERTION.assertion((fechaInicioInscripciones == null || fechaInicio.isAfter(fechaInicioInscripciones)) &&
                (fechaCierreInscripciones == null || fechaInicio.isAfter(fechaCierreInscripciones)),
                "La fecha de inicio no es válida");
        this.fechaInicio = fechaInicio;
    }

    public void setFechaInicioInscripciones(LocalDate fechaInicioInscripciones) {
        ASSERTION.assertion(fechaInicioInscripciones != null, "La fecha de inicio de inscripciones es requerida");
        this.fechaInicioInscripciones = fechaInicioInscripciones;
    }

    public void setFechaCierreInscripciones(LocalDate fechaCierreInscripciones) {
        ASSERTION.assertion(fechaCierreInscripciones != null, "La fecha de cierre es requerida");
        ASSERTION.assertion(fechaCierreInscripciones.isAfter(fechaInicioInscripciones),
                "La fecha de cierre de inscripciones debe ser posterior a la fecha de inicio de inscripciones");
        this.fechaCierreInscripciones = fechaCierreInscripciones;
    }

    /**
     * Permite registrar un equipo en el torneo
     * 
     * @param equipo Equipo a ser registrado
    * @throws Se genera un error si ya existe un equipo registrado con el mismo
     *            nombre, o en caso de que las inscripciones del torneo no esten
     *            abiertas.
     */
    public void registrarEquipo(Equipo equipo) {

        validarEquipoExiste(equipo);

        validarInscripciopnesAbiertas();

        equipos.add(equipo);
    }

    /**
     * Valida que las inscripciones del torneo esten abiertas, en caso de no estarlo
     * genera un assertion error.
     */
    private void validarInscripciopnesAbiertas() {
        boolean inscripcionAbierta = fechaInicioInscripciones.isBefore(LocalDate.now())
                && fechaCierreInscripciones.isAfter(LocalDate.now());
        ASSERTION.assertion(inscripcionAbierta, "Las inscripciones no están abiertas");
    }

    /**
     * Valida que no exista ya un equipo registrado con el mismo nombre, en caso de
     * haberlo genera un assertion error.
     */
    private void validarEquipoExiste(Equipo equipo) {
        boolean existeEquipo = buscarEquipoPorNombre(equipo.nombre()).isPresent();
        ASSERTION.assertion(!existeEquipo, "El equipo ya esta registrado");
    }

    /**
     * Permite obtener una copia no modificable de la lista de los equipos
     * registrados.
     * 
     * @return Collection<Equipo> no modificable de los equipos registrados en el
     *         torneo.
     */
    public Collection<Equipo> getEquipos() {
        return Collections.unmodifiableCollection(equipos);
    }

    /**
     * Permite buscar un equipo por su nomnbre entre los equipos registrados en el
     * torneo
     * 
     * @param nombre Nombre del equipo que se está buscando
     * @return Un Optional<Equipo> con el equipo cuyo nombre sea igual al nombre
     *         buscado, o un Optional vacio en caso de no encontrar un equipo con
     *         nombre igual al dado.
     */
    public Optional<Equipo> buscarEquipoPorNombre(String nombre) {
        Predicate<Equipo> condicion = equipo -> equipo.nombre().equals(nombre);
        return equipos.stream().filter(condicion).findAny();
    }

    /**
     * Permite registrar un jugador en el equipo siempre y cuando este dentro de las
     * fechas validas de registro,
     * no exista ya un jugador registrado con el mismo nombre y apellido y el
     * jugador no exceda el limite de edad del torneo.
     * 
     * @param nombre  Nombre del equipo en que se desea registrar el jugador
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(String nombre, Jugador jugador) {
        var equipo = buscarEquipoPorNombre(nombre);
        equipo.ifPresent((e) -> registrarJugador(e, jugador));
    }

    /**
     * Permite registrar un jugador en el equipo siempre y cuando este dentro de las
     * fechas validas de registro,
     * no exista ya un jugador registrado con el mismo nombre y apellido y el
     * jugador no exceda el limite de edad del torneo.
     * 
     * @param equipo  Equipo en el que se desea registrar el jugador.
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Equipo equipo, Jugador jugador) {
        ASSERTION.assertion(!LocalDate.now().isAfter(fechaCierreInscripciones),
                "No se pueden registrar jugadores después del a fecha de cierre de inscripciones");
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // metodo de comparacin q concuerde el genero
        ASSERTION.assertion(genero.equals(jugador.getGenero()),
                "el genero no es permitido, no concuerda el genero del torneo con el de el jugado");
                //validacion de primer punto de requisitos de proyecto final, validacion vassada en el genro tanto de torneo como de jugadro
        switch (genero) {
            case FEMENINO:
                if (jugador.getGenero().equals(TipoGenero.FEMENINO)) {
                    equipo.registrarJugador(jugador);
                    validarLimiteEdadJugador(jugador);
                    equipo.registrarJugador(jugador);
                }
                break;
            case MASCULINO:
                if (jugador.getGenero().equals(TipoGenero.MASCULINO)) {
                     validarEquipoExiste(equipo);
                     validarLimiteEdadJugador(jugador);
                    equipo.registrarJugador(jugador);
                }
                break;
            default:
                equipo.registrarJugador(jugador);
                validarLimiteEdadJugador(jugador);
                equipo.registrarJugador(jugador);
                break;
        }
         

}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    

   


    /**
     * Permite buscar un jugador basado en su nombre y apellido en todos los equipos
     * registrados en el torneo.
     * 
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador encontrado o un optional vacío en caso de no
     *         haber encontrado un jugador con el nombre y apellido del jugador
     *         buscado.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador) {
        return equipos.stream()
                .map(equipo -> equipo.buscarJugador(jugador))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido,
     * en caso de haberlo genera un assertion error.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion(!existeJugador, "El jugador ya esta registrado");
    }

    /**
     * Valida que no exista se puedan registrar jugadores que al momento del inicio
     * del torneo excedan el limite de edad.
     */
    private void validarLimiteEdadJugador(Jugador jugador) {
        var edadAlInicioTorneo = jugador.calcularEdad(fechaInicio);
        ASSERTION.assertion(limiteEdad == 0 || limiteEdad >= edadAlInicioTorneo,
                "No se pueden registrar jugadores que excedan el limite de edad del torneo");
    }

    public ArrayList<Juez> getListaDeJueces() {
        return listaDeJueces;
    }

    public void setListaDeJueces(ArrayList<Juez> listaDeJueces) {
        this.listaDeJueces = listaDeJueces;
    }

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    //  Requerimiento # 4
    //me muestra los enfrentamientos de cada equipo, segun su nombre

    /**
     * Permite registrar un participante en el torneo
     * 
     * @param participante Participante a ser registrado
     * @throws Se genera un error si ya existe un equipo registrado con el mismo
     *            nombre, o en caso de que las inscripciones del torneo no estén
     *            abiertas.
     */
    public void registrarParticipante(Participante participante) {
        validarParticipanteExiste(participante);

        validarInscripciopnesAbiertas();
        validarCaracter(participante);

        participantes.add(participante);
    }
    /**
     * Valida que el participante sea acorde con el carácter del torneo.
     * 
     * @param participante Participante a ser registrado
     */
    private void validarCaracter(Participante participante) {
        ASSERTION.assertion(caracter.esValido(participante), "Las inscripciones no están abiertas");
    }

    /**
     * Permite buscar un participante por su nombre entre los participantes
     * registrados en el torneo
     * 
     * @param nombre Nombre del participante que se está buscando
     * @return Un Optional<Participante> con el participante cuyo nombre sea igual
     *         al nombre buscado, o un Optional vacío en caso de no encontrar un
     *         participante con nombre igual al dado.
     */
    public Optional<Participante> buscarParticipantePorNombre(String nombre) {
        Predicate<Participante> condicion = participante -> participante.getNombreCompleto().equals(nombre);
        return participantes.stream().filter(condicion).findAny();
    }
       /**
     * Valida que no exista ya un equipo registrado con el mismo nombre, en caso de
     * haberlo genera un assertion error.
     */
    private void validarParticipanteExiste(Participante participante) {
        boolean existeEquipo = buscarParticipantePorNombre(participante.getNombreCompleto()).isPresent();
        ASSERTION.assertion(!existeEquipo, "El equipo ya esta registrado");
    }

//--------------------------------------------------------------------------------------------------------  
        // Para registrar los jueces a lista 2#
        public void registrarJuez(Juez juez) {
            listaDeJueces.add(juez);
        }
//---------------------------------------------------------------------------------------------------------

    // requerimiento 4#
    

    public ArrayList<MatchDay> enfrentamientosEquipo(String nombreEquipo){
        ArrayList<MatchDay> enfrentEquipo = new ArrayList<>();
        for(int i = 0;i < enfrentamientos.size();i++){
            String aux1 = enfrentamientos.get(i).getVisitorTeam().toString();
            String aux2 = enfrentamientos.get(i).getLocalTeam().toString();
            if(aux1.equalsIgnoreCase(nombreEquipo) || aux2.equalsIgnoreCase(nombreEquipo)){
                enfrentEquipo.add(enfrentamientos.get(i));
            }

        }
        return enfrentEquipo;
    }
//--------------------------------------------------------------------------------------------------------------
    //Requerimiento # 5 
    //me muestra los enfrentamientos en los que pitara el juez, segun su licencia
    //enfrentamientos.get(i).getJuez();

    public ArrayList<MatchDay> enfrentamientosJuez(String licencia){
        ArrayList<MatchDay> refereeMatches = new ArrayList<>();
        for(int i = 0 ; i < enfrentamientos.size() ; i++){
           ArrayList<Juez> refereeAux = enfrentamientos.get(i).getListaDeJueces();
           for(int j = 0; j < refereeAux.size(); j++){
                if(refereeAux.get(j).getLicenciaDeJuez().equalsIgnoreCase(licencia)){
                    refereeMatches.add(enfrentamientos.get(i));
                }
           }
        }
        return refereeMatches;
    }
}
