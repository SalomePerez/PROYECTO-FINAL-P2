package co.edu.uniquindio.poo.torneodeportivo;
/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase tiene los tipos de torneo en una clase de tipo Enum
 */
public enum CaracterTorneo {
/** el caracter torneo, es una clase que contiene que tipo torneo es dependiendo de su disciplina en este ca
 * @param INDIVIDUAL 
 * @param GRUPAL
 * */ 

    INDIVIDUAL {
        public boolean esValido(Participante participante) {
            return participante instanceof Jugador;
        }
    },
    GRUPAL {
        public boolean esValido(Participante participante) {
            return  participante instanceof Jugador;
        }
    };  
    // metodo abstracto que busca que sea valido 
    public abstract boolean esValido(Participante participante);
}
