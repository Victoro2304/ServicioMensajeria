package org.itson.aquitectura.serviciomensajeria.serviciostrategy;

import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;

/**
 * Esta clase permite devolver el coste del servicio Estandar.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class EstandarStrategy implements ServicioStrategy {

    private final double COSTO_BASE = 30.0;
    private final double COSTO_KM = 5.0;
    
    /**
     * Método que nos permite obtener el costo del servicio Estandar.
     *
     * @param pedido Datos del pedido
     * @return Costo del servicio.
     */
    @Override
    public double calcularCosto(Pedido pedido) {
        double costoFinal = 0;
        costoFinal += COSTO_BASE;
        costoFinal += pedido.getTransporte().obtenerCosto();
        costoFinal += pedido.getPaquete().getCosto();
        
        if (pedido.getDistancia() > 10) {
            costoFinal += (pedido.getDistancia() - 10) * COSTO_KM;
        }

        return costoFinal;
    }

}
