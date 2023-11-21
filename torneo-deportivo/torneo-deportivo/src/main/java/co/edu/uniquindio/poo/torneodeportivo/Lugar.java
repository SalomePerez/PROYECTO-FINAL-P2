package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

/**
 * registro que agrupa los datos de un equipo
 *@author: Samuel Castaño
 *@author: Daniel Jurado
 *@author: Salomé Pérez
 *@since : 22-11-2023
 * licencia GNU/GLP V3.0 (https://github.com/SalomePerez/PROYECTO-FINAL-P2.git)
 * esta clase llamda lugar con 2 atributos que definen el lugar 
 */
public class Lugar {
    //atributo
    private String nombre;
    private String ubicacion;
   // constructor 
    public Lugar(String nombre, String ubicacion) {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
        ASSERTION.assertion(ubicacion != null && !ubicacion.isBlank(), "El nombre es requerido");
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
   //metodos de acceso 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
