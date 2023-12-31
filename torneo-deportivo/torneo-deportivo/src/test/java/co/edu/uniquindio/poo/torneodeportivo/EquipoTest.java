/**
 * Clase para probar el registro de los equipos
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EquipoTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());
    /**
     * Verificar que sea posible registrar un equipo en el torneo 
     * 
     */
    @Test
    public void registrarEquipo() {
        LOG.info("Inicio de prueba registrar Equipo...");

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");
        
        var jugador1 = new Jugador("jose", "Franco", "jkl@bkjl","12345678", LocalDate.of(1, 8, 1999), TipoGenero.MASCULINO);
        var jugador2 = new Jugador("Enrri", "Fausto", "jkl@bkjhl","765432", LocalDate.of(3, 7, 1999), TipoGenero.MASCULINO);
        Collection<Jugador> jugadores;

        var equipo = new Equipo("Uniquindio", representante,jugadores);
        equipo.registrarJugador(jugador1);
        equipo.registrarJugador(jugador2);
        equipo.buscarJugador(jugador1);
        equipo.buscarJugador(jugador2);


        Juez jues= new Juez("Samuel", "Castaño", "samuela@", "312982", null, "licencia de juez");

        ArrayList<Juez>listJueces=new ArrayList<>();

        listJueces.add(jues);

       var marcador = new Marcador((byte)6, (byte)2);
        
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}
        var torneo=  new Torneo("Copa Mundo", LocalDate.now().plusMonths(1),LocalDate.now().minusDays(15),LocalDate.now().plusDays(15),(byte) 24, 
        (byte) 0, 0,TipoTorneo.LOCAL,equipo,listJueces,CaracterTorneo.GRUPAL,TipoGeneroTorneo.MASCULINO,marcador);
        //Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL, TipoGenero.MASCULINO);

        torneo.registrarEquipo(equipo);

        // Recuperación y verificación de datos
        assertTrue(torneo.getEquipos().contains(equipo));
        assertEquals(1, torneo.getEquipos().size());
        LOG.info("Fin de prueba registra rEquipo...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos con nombre repetido
     * 
     */
    @Test
    public void nombreEquipoRepetido() {
        LOG.info("Inicio de prueba nombreEquipoRepetido...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,null, null, TipoGeneroTorneo.MASCULINO, null, null, null );

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");

        var equipo = new Equipo("Uniquindio", representante);
        var equipo2 = new Equipo("Uniquindio", representante);
        torneo.registrarEquipo(equipo);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo2));
        
        LOG.info("Fin de prueba nombreEquipoRepetido...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos cuando las inscripciones ya cerraron
     * 
     */
    @Test
    public void inscripcionCerrada() {
        LOG.info("Inicio de prueba inscripcionCerrada...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual-1 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().minusDays(1), (byte)24, (byte)0, 0,TipoTorneo.LOCAL, null, null, TipoGeneroTorneo.MASCULINO, null, null, null);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");

        var equipo = new Equipo("Uniquindio", representante);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo));
        
        LOG.info("Fin de prueba inscripcionCerrada...");
    }

    /**
     * Verificar que la clase Torneo valide que no se ingresen equipos cuando las inscripciones aun no han abrierto
     * 
     */
    @Test
    public void inscripcionNoAbierta() {
        LOG.info("Inicio de prueba inscripcionNoAbierta...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual + 1 día\|fechaActual+15 días\|24\|0\|0\|LOCAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().plusDays(1), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,null, null, TipoGeneroTorneo.FEMENINO, null, null, null);

        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");

        var equipo = new Equipo("Uniquindio", representante);

        assertThrows(Throwable.class, ()-> torneo.registrarEquipo(equipo));
        
        LOG.info("Fin de prueba inscripcionNoAbierta...");
    }
}
