package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class MatchDay {
    private LocalDateTime fechaEnfrentamiento;
    private Juez juez;
    private Lugar lugar;
    private Equipo localTeam;
    private Equipo visitorTeam;
    private Marcador resultadoEnfrentamiento;
    private EstadoPartido estadoPartido;
    private LocalTime hora;
    private LocalDate fecha;

    public MatchDay(LocalDateTime fechaEnfrentamiento, Juez juez, Lugar lugar, Equipo localTeam, Equipo visitorTeam, Marcador resultadoEnfrentamiento,
            EstadoPartido estadoPartido, LocalTime hora, LocalDate fecha) {

        this.fechaEnfrentamiento = fechaEnfrentamiento;
        this.juez = juez;
        this.lugar = lugar;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.hora = hora;
        this.fecha = fecha;

        if(estadoPartido == EstadoPartido.FINALIZADO){
             this.resultadoEnfrentamiento = resultadoEnfrentamiento;
        }
         else if(estadoPartido == EstadoPartido.APLAZADO){
                System.out.println("se aplaza por el clima :( ");
        }
        else{
            this.resultadoEnfrentamiento = null;
        }
    }    
        
}