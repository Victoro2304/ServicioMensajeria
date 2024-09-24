package org.itson.aquitectura.serviciomensajeria.transportechain;

import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;

/**
 * Esta interfaz permite declarar los métodos a usar en el manejador de la
 * cadena.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public interface Transporte {

    /**
     * Nos permite conocer que transporte será el sigueinte que maneje la
     * petición en la cadena.
     *
     * @param transporte Siguiente transporte en la cadena.
     */
    public void setNext(Transporte transporte);

    /**
     * Este método ayuda a manejar la petición y decidir cuál vehiculo será
     * utilizado.
     *
     * @param pedido Datos del pedido.
     * @return Transporte a utilizar.
     */
    public Transporte manejadorTransporte(Pedido pedido);

    /**
     * Permite obtener el costo que tendrá el transporte utilizado.
     *
     * @return Costo del transporte.
     */
    public double obtenerCosto();

    /**
     * Permite calcular el tiempo de entrega que tendrá el transporte utilizado.
     *
     * @param distancia Distancia de la entrega.
     * @return Tiempo de entrega del transporte.
     */
    public double calcularTiempo(Double distancia);
    
    /**
     * Método que permite obtener el nombre del transporte.
     *
     * @return Nombre del transporte
     */
    public abstract String getNombre();
}
