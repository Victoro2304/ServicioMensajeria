package org.itson.aquitectura.serviciomensajeria.transportechain;

import org.itson.aquitectura.serviciomensajeria.paquete.TipoPaquete;
import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.EstandarStrategy;

/**
 * Esta clase permite utilizar los métodos necesarios en caso que el transporte
 * requerido sea la bicicleta.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class Bicicleta extends TransporteBaseHandler {

    private final String NOMBRE;
    private final double VELOCIDAD = 20.0;

    /**
     * Método constructor que inicializa el nombre del transporte.
     */
    public Bicicleta() {
        this.NOMBRE = "Bicicleta";
    }

    /**
     * Este método ayuda a manejar la petición y decidir si la bicicleta será
     * utilizado.
     *
     * @param pedido Datos del pedido.
     * @return Transporte a utilizar.
     */
    @Override
    public Transporte manejadorTransporte(Pedido pedido) {
        if ((pedido.getPaquete().getTipoPaquete() == TipoPaquete.SOBRE
                || pedido.getPaquete().getTipoPaquete() == TipoPaquete.CAJA_PEQUENA
                || pedido.getPaquete().getTipoPaquete() == TipoPaquete.CAJA_MEDIANA)
                && pedido.getDistancia() <= 5.0
                && pedido.getServicio() instanceof EstandarStrategy) {
            return this;
        } else if (siguiente != null) {
            return siguiente.manejadorTransporte(pedido);
        }
        return null;
    }

    /**
     * Permite obtener el costo que tendrá la bicicleta.
     *
     * @return Costo de la bicicleta.
     */
    @Override
    public double obtenerCosto() {
        return 5.0;
    }

    /**
     * Permite calcular el tiempo de entrega que tendrá la bicicleta en la
     * entrega.
     *
     * @param distancia Distancia de la entrega.
     * @return Tiempo de entrega de la bicicleta.
     */
    @Override
    public double calcularTiempo(Double distancia
    ) {
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
