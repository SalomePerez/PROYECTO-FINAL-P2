package co.edu.uniquindio.poo.torneodeportivo;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> b699863ffce513b97456253008f8b1e34f4caf27
import java.time.LocalDateTime;
import java.time.LocalTime;


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

    public LocalDateTime getFechaEnfrentamiento() {
        return fechaEnfrentamiento;
    }

    public void setFechaEnfrentamiento(LocalDateTime fechaEnfrentamiento) {
        this.fechaEnfrentamiento = fechaEnfrentamiento;
    }

    public Juez getJuez() {
        return juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
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
        
}