package org.itson.aquitectura.serviciomensajeria.serviciostrategy;

import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;

/**
 * Esta interfaz permite declarar los métodos a usar según la estrategia
 * seleccionada.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public interface ServicioStrategy {

    /**
     * Método que nos permite obtener el costo del servicio especificado.
     *
     * @param pedido Datos del pedido
     * @return Costo del servicio.
     */
    public double calcularCosto(Pedido pedido);
}
