package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamada Marcador que tiene los marcadores de lso 2 equipos 
 */
public class Marcador {
    //atributos 
    private byte marcadorEquipoLocal;
    private byte marcadorEquipoVisitante;
    // constructor
    public Marcador(byte marcadorEquipoLocal, byte marcadorEquipoVisitante) {
        this.marcadorEquipoLocal = marcadorEquipoLocal;
        this.marcadorEquipoVisitante = marcadorEquipoVisitante;
    }
    // metodos de acceso 
    public byte getMarcadorEquipoLocal() {
        return marcadorEquipoLocal;
    }

    public void setMarcadorEquipoLocal(byte marcadorEquipoLocal) {
        this.marcadorEquipoLocal = marcadorEquipoLocal;
    }

    public byte getMarcadorEquipoVisitante() {
        return marcadorEquipoVisitante;
    }

    public void setMarcadorEquipoVisitante(byte marcadorEquipoVisitante) {
        this.marcadorEquipoVisitante = marcadorEquipoVisitante;
    }
    
  
}
