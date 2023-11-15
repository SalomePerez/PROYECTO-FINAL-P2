package co.edu.uniquindio.poo.torneodeportivo;

public class Enfrentamiento {

    private byte MarcadorEquipo1;
    private byte MarcadorEquipo;

    public Enfrentamiento(byte marcadorEquipo1, byte marcadorEquipo) {
        MarcadorEquipo1 = marcadorEquipo1;
        MarcadorEquipo = marcadorEquipo;
    }

    public byte getMarcadorEquipo1() {
        return MarcadorEquipo1;
    }

    public void setMarcadorEquipo1(byte marcadorEquipo1) {
        MarcadorEquipo1 = marcadorEquipo1;
    }

    public byte getMarcadorEquipo() {
        return MarcadorEquipo;
    }

    public void setMarcadorEquipo(byte marcadorEquipo) {
        MarcadorEquipo = marcadorEquipo;
    }
    
    
    
}
