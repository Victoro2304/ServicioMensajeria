package org.itson.aquitectura.serviciomensajeria.transportechain;

import org.itson.aquitectura.serviciomensajeria.paquete.TipoPaquete;
import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.ExpressStrategy;

/**
 * Esta clase permite utilizar los métodos necesarios en caso que el transporte
 * requerido sea el dron.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class Dron extends TransporteBaseHandler {

    private final String NOMBRE;
    private final double VELOCIDAD = 60.0;

    /**
     * Método constructor que inicializa el nombre del transporte.
     */
    public Dron() {
        this.NOMBRE = "Dron";
    }

    /**
     * Este método ayuda a manejar la petición y decidir si el dron será
     * utilizado.
     *
     * @param pedido Datos del pedido.
     * @return Transporte a utilizar.
     */
    @Override
    public Transporte manejadorTransporte(Pedido pedido) {
        if ((pedido.getPaquete().getTipoPaquete() == TipoPaquete.SOBRE || pedido.getPaquete().getTipoPaquete() == TipoPaquete.CAJA_PEQUENA)
                && pedido.getDistancia() <= 1.0
                && pedido.getServicio() instanceof ExpressStrategy) {
            return this;
        } else if (siguiente != null) {
            return siguiente.manejadorTransporte(pedido);
        }
        return null;
    }

    /**
     * Permite obtener el costo que tendrá el dron.
     *
     * @return Costo del dron.
     */
    @Override
    public double obtenerCosto() {
        return 20.0;
    }

    /**
     * Permite calcular el tiempo de entrega que tendrá el dron en la entrega.
     *
     * @param distancia Distancia de la entrega.
     * @return Tiempo de entrega del dron.
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
