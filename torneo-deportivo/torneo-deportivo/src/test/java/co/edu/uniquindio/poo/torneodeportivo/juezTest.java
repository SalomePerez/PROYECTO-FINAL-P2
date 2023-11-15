package co.edu.uniquindio.poo.torneodeportivo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class juezTest {
    
       private static final Logger LOG = Logger.getLogger(JugadorTest.class.getName());

   @Test
   public void datosCompletos (){

    LOG.info("Inicio de prueba registrarJugadorEquipo...");

    var juez= new Juez("jose", "jaramillo", "joescqgmail.com", "321586974",TipoGenero.MASCULINO, "certificado");

    assertEquals("jose",juez.getNombre());
    assertEquals("jaramillo", juez.getApellido());
    assertEquals("joescqgmail.com",juez.getEmail());
    assertEquals("321586974",juez.getCelular());
   }
}
