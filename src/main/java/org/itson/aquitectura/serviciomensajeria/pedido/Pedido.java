package org.itson.aquitectura.serviciomensajeria.pedido;

import org.itson.aquitectura.serviciomensajeria.paquete.Paquete;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.ServicioStrategy;
import org.itson.aquitectura.serviciomensajeria.transportechain.Transporte;

/**
 * Esta clase permite crear los pedidos necesarios para el servicio de
 * mensajería.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class Pedido {

    private ServicioStrategy servicio;
    private Paquete paquete;
    private Transporte transporte;
    private double distancia;

    /**
     * Método constructor que permite inicializar los valores necesarios para la
     * construcción de un pedido
     *
     * @param servicio Servicio utilizado.
     * @param paquete Paquete enviado.
     * @param distancia Distancia de entrega.
     */
    public Pedido(ServicioStrategy servicio, Paquete paquete, double distancia) {
        this.servicio = servicio;
        this.paquete = paquete;
        this.distancia = distancia;
    }

    /**
     * Permite calcular el costo total del pedido según el servicio elegido.
     *
     * @return Costo total del pedido.
     */
    public double calcularCosto() {
        return servicio.calcularCosto(this);
    }

    /**
     * Permite asignar el transporte utilizado según las caracteristicas del
     * pedido.
     *
     * @param transporte Transporte utilizado.
     */
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     * Permite obtener el transporte utilizado.
     *
     * @return Transporte utilizado.
     */
    public Transporte getTransporte() {
        return transporte;
    }

    /**
     * Permite obtener el tipo de servicio utilizado.
     * 
     * @return Tipo de servicio utilizado.
     */
    public ServicioStrategy getServicio() {
        return servicio;
    }

    /**
     * Permite obtener el tipo de paquete utilizado.
     * 
     * @return Tipo de paquete utilizado.
     */
    public Paquete getPaquete() {
        return paquete;
    }

    /**
     * Permite obtener la distancia del pedido.
     * 
     * @return Distancia del pedido.
     */
    public double getDistancia() {
        return distancia;
    }
}
