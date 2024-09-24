package org.itson.aquitectura.serviciomensajeria.paquete;

/**
 * Esta clase nos permite identificar el tipo de paquete especificado en el
 * pedido con ayuda de la clase TipoPaquete y además permite obtener su costo.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class Paquete {

    private TipoPaquete tipoPaquete;

    /**
     * Constructor que permite crear un paquete según el tipo especificado.
     *
     * @param tipo Tipo de paquete a utilizar.
     */
    public Paquete(TipoPaquete tipo) {
        this.tipoPaquete = tipo;
    }

    /**
     * Método que nos permite obtener el costo del paquete según el tipo
     * especificado.
     *
     * @return Costo del paquete según el tamaño.
     */
    public double getCosto() {
        switch (this.tipoPaquete) {
            case SOBRE:
                return 5.0;
            case CAJA_PEQUENA:
                return 10.0;
            case CAJA_MEDIANA:
                return 20.0;
            case CAJA_GRANDE:
                return 50.0;
            default:
                break;
        }
        return -1;
    }

    /**
     * Permite obtener el tipo de paquete seleccionado.
     *
     * @return Tipo de paquete.
     */
    public TipoPaquete getTipoPaquete() {
        return tipoPaquete;
    }
}
