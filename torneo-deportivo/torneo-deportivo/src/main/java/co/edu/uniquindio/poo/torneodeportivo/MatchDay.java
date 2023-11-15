package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MatchDay {
    private LocalDateTime fechaEnfrentamiento;
    private Juez juez;
    private Lugar lugar;
    private Equipo localTeam;
    private Equipo visitorTeam;
    private Enfrentamiento resultadoEnfrentamiento;
    private EstadoPartido estadoPartido;

    public MatchDay(LocalDateTime fechaEnfrentamiento, Juez juez, Lugar lugar, Equipo localTeam, Equipo visitorTeam, Enfrentamiento resultadoEnfrentamiento,
            EstadoPartido estadoPartido) {

        this.fechaEnfrentamiento = fechaEnfrentamiento;
        this.juez = juez;
        this.lugar = lugar;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;

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