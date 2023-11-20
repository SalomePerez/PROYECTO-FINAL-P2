package co.edu.uniquindio.poo.torneodeportivo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class MatchDay {
    private LocalDateTime fechaEnfrentamiento;
    private Lugar lugar;
    private Equipo localTeam;
    private Equipo visitorTeam;
    private Marcador resultadoEnfrentamiento;
    private EstadoPartido estadoPartido;
    private LocalTime hora;
    private LocalDate fecha;
    private ArrayList<Juez> listaDeJueces;

    public MatchDay(LocalDateTime fechaEnfrentamiento, Juez juez, Lugar lugar, Equipo localTeam, Equipo visitorTeam, Marcador resultadoEnfrentamiento,
            EstadoPartido estadoPartido, LocalTime hora, LocalDate fecha, ArrayList<Juez> listaDeJueces) {

        this.fechaEnfrentamiento = fechaEnfrentamiento;
    
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
        this.listaDeJueces = new ArrayList<>();
    }

    public LocalDateTime getFechaEnfrentamiento() {
        return fechaEnfrentamiento;
    }

    public void setFechaEnfrentamiento(LocalDateTime fechaEnfrentamiento) {
        this.fechaEnfrentamiento = fechaEnfrentamiento;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Equipo getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(Equipo localTeam) {
        this.localTeam = localTeam;
    }

    public Equipo getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Equipo visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Marcador getResultadoEnfrentamiento() {
        return resultadoEnfrentamiento;
    }

    public void setResultadoEnfrentamiento(Marcador resultadoEnfrentamiento) {
        this.resultadoEnfrentamiento = resultadoEnfrentamiento;
    }

    public EstadoPartido getEstadoPartido() {
        return estadoPartido;
    }

    public void setEstadoPartido(EstadoPartido estadoPartido) {
        this.estadoPartido = estadoPartido;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Juez> getListaDeJueces() {
        return listaDeJueces;
    }

    public void setListaDeJueces(ArrayList<Juez> listaDeJueces) {
        this.listaDeJueces = listaDeJueces;
    }

    

    
}