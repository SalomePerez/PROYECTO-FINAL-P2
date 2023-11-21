
package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada torneo tiene gran parte de los metodos de validaciones y registro y contiene 2 requisitos del proyecto final
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Torneo {
    //atributos
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
    //constuctor
    public Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
            LocalDate fechaCierreInscripciones, byte numeroParticipantes, byte limiteEdad, int valorInscripcion,
            TipoTorneo tipoTorneo, Collection<Participante> participantes, Collection<Equipo> equipos, TipoGeneroTorneo genero, ArrayList<Juez> listaDeJueces,CaracterTorneo caracter, Marcador marcador) {

            // assertion de los atributos propios de esta clase que exige que no sean null
            ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
            ASSERTION.assertion(numeroParticipantes >= 0 , "El número de participantes no puede ser negativo");
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
   // metodos de acceso
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

    public ArrayList<Juez> getListaDeJueces() {
        return listaDeJueces;
    }
    
    public void setListaDeJueces(ArrayList<Juez> listaDeJueces) {
        this.listaDeJueces = listaDeJueces;
    }
    
    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

public Collection<Participante> getParticipantes() {
        return participantes;
    }
    public TipoGeneroTorneo getGenero() {
        return genero;
    }
    public ArrayList<MatchDay> getEnfrentamientos() {
        return enfrentamientos;
    }
    public void setEnfrentamientos(ArrayList<MatchDay> enfrentamientos) {
        this.enfrentamientos = enfrentamientos;
    }
    public CaracterTorneo getCaracter() {
        return caracter;
    }
    public void setCaracter(CaracterTorneo caracter) {
        this.caracter = caracter;
    }
    public Marcador getMarcador() {
        return marcador;
    }
    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------
    /**metodo que valida la fecha de inicio utilizando los assertion
     * @param fechaInicio 
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        ASSERTION.assertion(fechaInicio != null, "La fecha de inicio es requerida");
        ASSERTION.assertion((fechaInicioInscripciones == null || fechaInicio.isAfter(fechaInicioInscripciones)) &&
                (fechaCierreInscripciones == null || fechaInicio.isAfter(fechaCierreInscripciones)),
                "La fecha de inicio no es válida");
        this.fechaInicio = fechaInicio;
    }
    /** metodo que valida la fecha de inicio de inscripciones utilizando los assertion
     * @param fechaInicioInscripciones
     */
    public void setFechaInicioInscripciones(LocalDate fechaInicioInscripciones) {
        ASSERTION.assertion(fechaInicioInscripciones != null, "La fecha de inicio de inscripciones es requerida");
        this.fechaInicioInscripciones = fechaInicioInscripciones;
    }
    /** metodo que valida la fecha de cierre de inscripciones utilizando los assertion 
     * @param fechaCierreInscripciones
     */
    public void setFechaCierreInscripciones(LocalDate fechaCierreInscripciones) {
        ASSERTION.assertion(fechaCierreInscripciones != null, "La fecha de cierre es requerida");
        ASSERTION.assertion(fechaCierreInscripciones.isAfter(fechaInicioInscripciones),
                "La fecha de cierre de inscripciones debe ser posterior a la fecha de inicio de inscripciones");
        this.fechaCierreInscripciones = fechaCierreInscripciones;
    }

    /**
     * Permite registrar un equipo en el torneo
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
     * @throws se genera un assertion error si las inscripciones se recliza antes de
     * las fechas acordada.
     */
    private void validarInscripciopnesAbiertas() {
        boolean inscripcionAbierta = fechaInicioInscripciones.isBefore(LocalDate.now())
                && fechaCierreInscripciones.isAfter(LocalDate.now());
        ASSERTION.assertion(inscripcionAbierta, "Las inscripciones no están abiertas");
    }

    /**
     * Valida que no exista ya un equipo registrado con el mismo nombre, en caso de
     * @throws se genera un error si validamos el nombre del equipo y no lo encontramos.
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
        // assertion que compare el genero del toenro con el del jugador 
        ASSERTION.assertion(genero.equals(jugador.getGenero()),"el genero no es permitido, no concuerda el genero del torneo con el de el jugado");

/** requerimeinto #1 
 * validacion de primer punto de requisitos de proyecto final, validacion vasada en el genero tanto de torneo como de jugador
 * @param genero 
 */
        switch (genero) {
            case FEMENINO:
                if (jugador.getGenero().equals(TipoGenero.FEMENINO)) {
                    // si el genero del jugador es gual a al genero femenino del torneo
                    // se ejecutan este metodos de validacion como de registro del jugador 
                    validarJugadorExiste(jugador);
                    validarLimiteEdadJugador(jugador);
                    equipo.registrarJugador(jugador);
                }
                break;
            case MASCULINO:
                if (jugador.getGenero().equals(TipoGenero.MASCULINO)) {
                    // si el genero del jugador es gual a al genero masculino del torneo
                    // se ejecutan este metodos de validacion como de registro del jugador 
                     validarJugadorExiste(jugador);
                     validarLimiteEdadJugador(jugador);
                    equipo.registrarJugador(jugador);
                }
                break;
            default:
                // si el genero del jugador es gual a al genero es mixto del torneo
                // se ejecutan este metodos de validacion como de registro del jugador 
                validarJugadorExiste(jugador);
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
     * Validar que no exista ya un jugador registrado con el mismo nombre y apellido,
     * @param jugador 
     * @throws se genera un error si el jugador ya existe.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion(!existeJugador, "El jugador ya esta registrado");
    }

    /**
     * Valida que no exista se puedan registrar jugadores que al momento del inicio
     * del torneo excedan el limite de edad.
     * @param jugador 
     * @throws se genera un error si el limite de edad del jugador si excede el limite de edad
     */
    private void validarLimiteEdadJugador(Jugador jugador) {
        var edadAlInicioTorneo = jugador.calcularEdad(fechaInicio);
        ASSERTION.assertion(limiteEdad == 0 || limiteEdad >= edadAlInicioTorneo,
                "No se pueden registrar jugadores que excedan el limite de edad del torneo");
    }

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
     * @param participante Participante a ser registrado
     * @throws se genera un error si las inscripciones no estan abiertas
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
     * @throws se genera un erro si ese equipo ya esta registrado haberlo genera un assertion error.
     */
    private void validarParticipanteExiste(Participante participante) {
        boolean existeEquipo = buscarParticipantePorNombre(participante.getNombreCompleto()).isPresent();
        ASSERTION.assertion(!existeEquipo, "El equipo ya esta registrado");
    }

//--------------------------------------------------------------------------------------------------------  

        /**requerimiento #2
         * este metodo agrega a los jueces despues de ver si existe 
         * @param juez
         */

        private void validarjuezExiste(Juez juez) {
        boolean existejuez = buscarParticipantePorNombre(juez.getApellido()).isPresent();
        ASSERTION.assertion(!existejuez, "El equipo ya esta registrado");

    }
        public void registrarJuez(Juez juez) {
        validarjuezExiste(juez);
        listaDeJueces.add(juez);
        }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

/**requerimiento #4
 *El método enfrentamientosEquipo recibe como entrada el nombre de un equipo (nombreEquipo) y devuelve un ArrayList de objetos MatchDay
  que representan los enfrentamientos en los que el equipo especificado está involucrado.
 * @param nombreEquipo
 * @return
 */
    public ArrayList<MatchDay> enfrentamientosEquipo(String nombreEquipo){
        //Se inicializa un ArrayList vacío llamado enfrentEquipo para almacenar los enfrentamientos que involucran al equipo especificado.
        ArrayList<MatchDay> enfrentEquipo = new ArrayList<>();
        //Se itera sobre la lista enfrentamientos, que presumiblemente contiene objetos MatchDay que representan todos los enfrentamientos.
        for(int i = 0;i < enfrentamientos.size();i++){
        //Para cada enfrentamiento, se obtienen los nombres del equipo local (aux2) y el equipo visitante (aux1)
        // utilizando los métodos getLocalTeam() y getVisitorTeam(), respectivamente.
            String aux1 = enfrentamientos.get(i).getVisitorTeam().toString();
            String aux2 = enfrentamientos.get(i).getLocalTeam().toString();
        //Se verifica si aux1 o aux2 coinciden con el nombreEquipo especificado utilizando el método equalsIgnoreCase(), 
        //que realiza una comparación sin tener en cuenta las mayúsculas y minúsculas.
            if(aux1.equalsIgnoreCase(nombreEquipo) || aux2.equalsIgnoreCase(nombreEquipo)){
                //Si hay una coincidencia, se agrega el objeto MatchDay actual a la lista enfrentEquipo.
                enfrentEquipo.add(enfrentamientos.get(i));
            }

        }
        return enfrentEquipo;
    }

//--------------------------------------------------------------------------------------------------------------

    /**requerimiento #5
     * El método enfrentamientosJuez recibe como entrada una licencia de juez (licencia) y
     * devuelve un ArrayList de objetos MatchDay que representan los enfrentamientos en los que ese juez está involucrado.
     * @param licencia
     * @return refereeMatches
     */
    public ArrayList<MatchDay> enfrentamientosJuez(String licencia) {
        //se inicializa un ArrayList vacío llamado refereeMatches para almacenar los enfrentamientos en los que el juez está involucrado.
        ArrayList<MatchDay> refereeMatches = new ArrayList<>();
        //Se itera sobre la lista enfrentamientos, que contiene objetos MatchDay que representan los enfrentamientos.
        for (MatchDay enfrentamiento : enfrentamientos) {
            //Para cada enfrentamiento, se obtiene la lista de jueces (refereeAux) utilizando el método getListaDeJueces().
            ArrayList<Juez> refereeAux = enfrentamiento.getListaDeJueces();
            //Se itera sobre la lista de jueces (refereeAux) 
            for (Juez referee : refereeAux) {
                // se verifica si la licencia del juez actual coincide con 
               //la licencia especificada utilizando el método getLicenciaDeJuez() y equalsIgnoreCase().
                if (referee.getLicenciaDeJuez().equalsIgnoreCase(licencia)) {
                    //se agrega el objeto MatchDay actual a la lista refereeMatches.
                    refereeMatches.add(enfrentamiento);
                }
            }
        }
        
        return refereeMatches;
    }
    /**El método deducirPartido toma una lista de objetos MatchDay llamada enfrentamientos como entrada y devuelve un ArrayList de matrices de cadenas (String[])
     *  que representan los resultados deducidos de los partidos finalizados.
     * @param enfrentamientos
     * @return listaPartidosFinalizados
     */
    public ArrayList<String[]> deducirPartido(ArrayList<MatchDay> enfrentamientos) {
        //Se inicializa un ArrayList vacío llamado listaPartidosFinalizado para almacenar los resultados deducidos de los partidos finalizados.
        ArrayList<String[]> listaPartidosFinalizado = new ArrayList<>();
         //Se utiliza el método stream() en la lista enfrentamientos para realizar operaciones en cada objeto MatchDay.
        enfrentamientos.stream()
        //Se aplica un filtro utilizando filter() para seleccionar solo los enfrentamientos que tienen un estado de partido igual a FINALIZADO, utilizando el método getEstado().
            .filter(enfrentamiento -> enfrentamiento.getEstado()== EstadoPartido.FINALIZADO)
            .forEach(enfrentamiento -> {
                //Para cada enfrentamiento seleccionado, se obtienen los resultados del marcador del equipo local y visitante utilizando los métodos 
                //getMarcadorEquipoLocal() y getMarcadorEquipoVisitante() respectivamente.
                int resultadoLocal = enfrentamiento.getResultadoEnfrentamiento().getMarcadorEquipoLocal();
                int resultadoVisitante = enfrentamiento.getResultadoEnfrentamiento().getMarcadorEquipoVisitante();
                //Se crean dos matrices de cadenas (String[]) llamadas auxLocal y auxVisitante para almacenar el nombre del equipo y el resultado deducido.
                //Se asigna el nombre del equipo local y la cadena "EMPATO" a auxLocal, y se asigna el nombre del equipo visitante y la cadena "EMPATO" a auxVisitante.
                String[] auxLocal = {enfrentamiento.getLocalTeam().nombre(), "EMPATO"};
                String[] auxVisitante = {enfrentamiento.getVisitorTeam().nombre(), "EMPATO"};
                //Se comparan los resultados del marcador para determinar si el equipo local ganó o perdió en comparación con el equipo visitante. 
                //Si el resultado local es mayor que el resultado visitante, se actualizan las cadenas de resultado en auxLocal y
                //auxVisitante para reflejar que el equipo local ganó y el equipo visitante perdió. Si el resultado local es menor que el resultado visitante, 
                //se actualizan las cadenas de resultado para reflejar que el equipo local perdió y el equipo visitante ganó.
                if (resultadoLocal > resultadoVisitante) {
                    auxLocal[1] = "GANO";
                    auxVisitante[1] = "PERDIO";
                } else if (resultadoLocal < resultadoVisitante) {
                    auxLocal[1] = "PERDIO";
                    auxVisitante[1] = "GANO";
                }
                //Se agregan las matrices auxLocal y auxVisitante a la lista listaPartidosFinalizado.
                listaPartidosFinalizado.add(auxLocal);
                listaPartidosFinalizado.add(auxVisitante);
            });
    
        return listaPartidosFinalizado;
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    /** requisito #6
     * Este método se encarga de clasificar los equipos en función de sus estadísticas de victorias, derrotas y empates.
     * 
     * @return posiciones 
     */
    public List<String> clasificarEquipos() {
    ArrayList<String[]> listaPartidosFinalizado = deducirPartido(enfrentamientos);

    Map<String, EstadisticasEquipo> estadisticasEquipos = new HashMap<>();
   //un bucle for-each que itera sobre la lista listaPartidosFinalizado, que contiene matrices de cadenas (String[]) 
   //representando los resultados deducidos de los partidos finalizados.
    for (String[] resultado : listaPartidosFinalizado) {
        //Para cada elemento resultado en la lista listaPartidosFinalizado, se extraen dos cadenas de la matriz: nombreEquipo y resultadoPartido.
        String nombreEquipo = resultado[0];
        String resultadoPartido = resultado[1];
        //Se utiliza el nombre del equipo (nombreEquipo) para obtener las estadísticas del equipo correspondiente de un mapa llamado estadisticasEquipos. 
        //Si no existen estadísticas para ese equipo, se crea un nuevo objeto EstadisticasEquipo utilizando el operador new.
        EstadisticasEquipo estadisticas = estadisticasEquipos.getOrDefault(nombreEquipo, new EstadisticasEquipo());
        //Se verifica el valor de resultadoPartido para determinar si el equipo ganó, perdió o empató el partido. 
        if (resultadoPartido.equals("GANO")) {
            //Si es "GANO", se incrementa el contador de victorias en las estadísticas del equipo utilizando el método incrementarVictorias()de la clase EstadisticasEquipo.
            estadisticas.incrementarVictorias();
        } else if (resultadoPartido.equals("PERDIO")) {
            //Si es "PERDIO", se incrementa el contador de derrotas.
            estadisticas.incrementarDerrotas();
        } else {
            // Si no es ninguno de los dos, se incrementa el contador de empates.
            estadisticas.incrementarEmpates();
        }
           //El método put() es una operación de mapa que toma dos parámetros: la clave y el valor. En este caso, el nombreEquipo (nombre del equipo) se utiliza como clave, 
           //y el objeto estadisticas (estadísticas del equipo) se utiliza como valor. Esta operación agrega o actualiza la entrada en el mapa con el par clave-valor especificado.
        estadisticasEquipos.put(nombreEquipo, estadisticas);
    }
    //crea una lista llamada posiciones que contiene las claves (nombres de los equipos) del mapa estadisticasEquipos.
    List<String> posiciones = new ArrayList<>(estadisticasEquipos.keySet());
    //se utiliza el método sort() en la lista posiciones para ordenar los nombres de los equipos en función de sus estadísticas. 
    posiciones.sort((equipo1, equipo2) -> {
        // se obtienen las estadísticas del equipo 1 y del equipo 2 utilizando los nombres de los equipos (equipo1 y equipo2) como claves en el mapa estadisticasEquipos
        EstadisticasEquipo estadisticas1 = estadisticasEquipos.get(equipo1);
        EstadisticasEquipo estadisticas2 = estadisticasEquipos.get(equipo2);
        //Si el número de victorias es diferente de cero, se devuelve el resultado de la comparación. Esto asegura que los equipos se ordenen en función de sus victorias de mayor a menor.
        int comparacionVictorias = Integer.compare(estadisticas2.getVictorias(), estadisticas1.getVictorias());

        if (comparacionVictorias != 0) {
            return comparacionVictorias;
        }
        //Esto asegura que, en caso de empate en victorias, los equipos se ordenen en función de sus derrotas de menor a mayor.
        return Integer.compare(estadisticas1.getDerrotas(), estadisticas2.getDerrotas());
    });

    return posiciones;
}

/*El código que has proporcionado define una clase estática llamada EstadisticasEquipo. Esta clase representa las estadísticas de un equipo y tiene los siguientes atributos: victorias, derrotas y empates. 
 * 
 */
private static class EstadisticasEquipo {
    //atributos
    private int victorias;
    private int derrotas;
    private int empates;
    // constructor
    public EstadisticasEquipo() {
        this.victorias = 0;
        this.derrotas = 0;
        this.empates = 0;
    }
    // metodos que cambian el estado de las variables (victorias,derrotas,empates)
    public void incrementarVictorias() {
        victorias++;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }

    public void incrementarEmpates() {
        empates++;
    }
    // metodos de acceso
    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }
}
    
}
