package co.edu.uniquindio.poo.torneodeportivo;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
/**
 * requrimiento #3
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada matchDay tiene metodos se encarga de todo lo referente a los encuentros entre los equipo, ajustando su estado 
 */
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;



public class MatchDay {

    // atributos
    private LocalDateTime fechaEnfrentamiento;
    private Lugar lugar;
    private Equipo localTeam;
    private Equipo visitorTeam;
    private Marcador resultadoEnfrentamiento;
    private EstadoPartido estado= EstadoPartido.PENDIENTE;
    private LocalDateTime fechahora;
    private ArrayList<Juez> listaDeJueces;

    //cosntructor
    public MatchDay(LocalDateTime fechaEnfrentamiento, Juez juez, Lugar lugar, Equipo localTeam, Equipo visitorTeam, Marcador resultadoEnfrentamiento,
            EstadoPartido estadoPartido, LocalTime hora, LocalDateTime fechahora, ArrayList<Juez> listaDeJueces) {
         //assetrs
        ASSERTION.assertion(fechaEnfrentamiento!= null, "La fecha de inicio es requerida");

        this.fechaEnfrentamiento = fechaEnfrentamiento;
        this.lugar = lugar;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        
        this.fechahora = fechahora;

    }
    // metodos de acceso
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

    public LocalDateTime getFechahora() {
        return fechahora;
    }
    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
    public ArrayList<Juez> getListaDeJueces() {
        return listaDeJueces;
    }

    public void setListaDeJueces(ArrayList<Juez> listaDeJueces) {
        this.listaDeJueces = listaDeJueces;
    }
    
    public EstadoPartido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
    }
//------------------------------------------------------------------------------------------------------------------------------------
    
    /** este metodo de solicitarResultado() crea un objeto de la clase Marcador 
     * @param marcadorEquipoLocal = 6
     * @param marcadorEquipoVisitante = 2
     * @return resultado .:. variable que contiene estos 2 resultados 
     */
    public Marcador solicitatarResultado() {
        var resultado = new Marcador((byte)6, (byte)2);
        return resultado;
    }
    /** este metodo  de deducirEstado () inicia con variables boolenas 
     * @param isSuspendido = false or true (dependiendo de las dediciones (if..))
     * @param isFinalizado = false or true (dependiendo de las dediciones (if..))
     * otra variable provisional es :
     * @param ahora = la fecha con la hora prepsnte con  la que vamos a comparar la fecha y la hora del partido ya planeado
     * @return estado .:. variable que contien el estado final del enfrentamiento
     */
    public EstadoPartido deducirEstado() {
        //atributo 
        boolean isSuspendido = false;
        // condicion de desicion 
        if (isSuspendido == false) {
            //atributo
            boolean isFinalizado = true;
            //condicion de desicion
            if (isFinalizado == false) {
                // atributo de control "ahora"
                LocalDateTime ahora = LocalDateTime.now();
                //condicion de desicion 
                if (ahora.isEqual(fechahora)) {
                    // resultado desicion 
                    estado = EstadoPartido.ENJUEGO;
                } else {
                    // resultado desicion 
                    estado = EstadoPartido.PENDIENTE;
                }
               //condicion de desicion 
            } else if (isFinalizado == true) {
                // resultado desicion
                estado = EstadoPartido.FINALIZADO;
            }
            //condicion desicion 
        } else if (isSuspendido == true) {
            //resultado desicion 
            estado = EstadoPartido.APLAZADO;
        }
        return estado;
    }
    
}