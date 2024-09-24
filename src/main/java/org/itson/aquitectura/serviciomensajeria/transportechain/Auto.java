package org.itson.aquitectura.serviciomensajeria.transportechain;

import org.itson.aquitectura.serviciomensajeria.paquete.TipoPaquete;
import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;

/**
 * Esta clase permite utilizar los métodos necesarios en caso que el transporte
 * requerido sea el auto.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class Auto extends TransporteBaseHandler {

    private final String NOMBRE;
    private final double VELOCIDAD = 40.0;

    /**
     * Método constructor que inicializa el nombre del transporte.
     */
    public Auto() {
        this.NOMBRE = "Auto";
    }

    /**
     * Este método ayuda a manejar la petición y decidir si el auto será
     * utilizado.
     *
     * @param pedido Datos del pedido.
     * @return Transporte a utilizar.
     */
    @Override
    public Transporte manejadorTransporte(Pedido pedido) {
        if (pedido.getPaquete().getTipoPaquete() == TipoPaquete.CAJA_GRANDE) {
            return this;
        } else if (siguiente != null) {
            return siguiente.manejadorTransporte(pedido);
        }
        return null;
    }

    /**
     * Permite obtener el costo que tendrá el auto.
     *
     * @return Costo del auto.
     */
    @Override
    public double obtenerCosto() {
        return 30.0;
    }

    /**
     * Permite calcular el tiempo de entrega que tendrá el auto en la entrega.
     *
     * @param distancia Distancia de la entrega.
     * @return Tiempo de entrega del auto.
     */
    @Override
    public double calcularTiempo(Double distancia) {
        return (distancia / VELOCIDAD) * 60;
    }

    /**
     * Método que permite obtener el nombre del transporte.
     *
     * @return Nombre del transporte
     */
    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
