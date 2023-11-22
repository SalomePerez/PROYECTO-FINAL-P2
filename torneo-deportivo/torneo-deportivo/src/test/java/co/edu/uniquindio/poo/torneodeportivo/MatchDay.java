package co.edu.uniquindio.poo.torneodeportivo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class MatchDay {
    
     private static final Logger LOG = Logger.getLogger(JugadorTest.class.getName());
     private Torneo torneo;
      private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez1;
    private Juez juez2;
    private Persona persona;
    private Persona persona1;
    private Equipo equipo1;
    private Equipo equipo2;  
    private Equipo equipo3;
    private MatchDay enfrentamiento1;
    private MatchDay enfrentamiento2;
    private ArrayList<Juez> jueces = new ArrayList<>();
    private ArrayList<MatchDay> enfrentamientos = new ArrayList<>();
    private Collection<Jugador> jugadoresEquipo1 = new ArrayList<>();
    private Collection<Jugador> jugadoresEquipo2 = new ArrayList<>();
    private Marcador marcador;

    public MatchDay(LocalDateTime fechaEnfrent, Juez juez12, Lugar lugar, Equipo equipo12, Equipo equipo22,
            Marcador marcador2, LocalTime now, LocalDateTime now2, ArrayList<Juez> jueces2) {
    }
    public MatchDay(String string, String string2, LocalDate now, Equipo equipo12, Equipo equipo32,
            ArrayList<Juez> jueces2) {
    }
    @Test
    void setUp() {
     
        jugador1 = new Jugador("daniel", "celemin", "celemin@uq", "320", LocalDate.of(2005, 1, 1), TipoGenero.MIXTO);
        jugadoresEquipo1.add(jugador1);
        
        jugador2 = new Jugador("salome", "perez", "perez@uq", "321", LocalDate.of(2005, 1, 1),TipoGenero.MIXTO);
        jugadoresEquipo2.add(jugador2);

        juez1 = new Juez("samuel", "castaño", "castaño.email", "319", TipoGenero.MASCULINO, "10");

        juez2 = new Juez("jurado", "dan", "dan.uq", "232",TipoGenero.MASCULINO, "20");
        jueces.add(juez1);
        jueces.add(juez2);

        Persona representanteEquipo1 = new Persona("samu", "el", "el.uq", "319");

        Persona representanteEquipo2 = new Persona("salo", "me", "me.uq", "315");

        equipo1 = new Equipo("barcelona", representanteEquipo1, jugadoresEquipo1);

        equipo2 = new Equipo("Real", representanteEquipo2, jugadoresEquipo2); 
        
        equipo3 = new Equipo("city", representanteEquipo2, jugadoresEquipo2);  

        Collection<Equipo> equipos = new LinkedList<>();                      
        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);

        //Participante participante = new Participante();
        Marcador marcador = new Marcador((byte)1,(byte)2);
        Lugar lugar = new Lugar("quimbaya", "poli");
        LocalDateTime fechaEnfrent = LocalDateTime.of(2023,12,23,12,45,0);

        enfrentamiento1 = new MatchDay( fechaEnfrent, juez1, lugar, equipo1, equipo2, marcador,
         LocalTime.now(), LocalDateTime.now(), jueces);
                                            
        enfrentamiento2 = new MatchDay("bernabeu", "bey", LocalDate.now(), equipo1, equipo3, jueces);
                                             
        enfrentamientos.add(enfrentamiento1);
        enfrentamientos.add(enfrentamiento2);                            
        torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1),LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte) 24, (byte) 18, 0, TipoTorneo.LOCAL, null, equipos , TipoGeneroTorneo.MIXTO, jueces, CaracterTorneo.GRUPAL, marcador); 
    }
     @Test
     public void obtEnfrentamientosEquipo(){
        // LOG.info("Inicio de prueba buscar enfrentramientos equipo segun nombre ");
         System.out.println("inicio prueba obtener enfrentamientos equipo segun el nombre");
         System.out.println(torneo.enfrentamientosEquipo("city").toString());
         System.out.println("prueba finalizada");
 
     }
     @Test
     public void obtEnfrentamientosJuez(){
         System.out.println("inicio prueba obtener enfrentamientos equipo segun el nombre");
         System.out.println(torneo.enfrentamientosJuez("10"));
         System.out.println("prueba finalizada");
     }
 
     @Test
     void posEquipos(){
         System.out.println("inicio prueba clasificar equipos de manera descendente");
         System.out.println(torneo.clasificarEquipos());
         System.out.println("prueba finalizada");
     }
}
