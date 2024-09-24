package org.itson.aquitectura.serviciomensajeria.transportechain;

import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;

/**
 * Esta clase abstracta permite declarar y definir algunos métodos a usar en los
 * transportes.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public abstract class TransporteBaseHandler implements Transporte {

    protected Transporte siguiente;

    /**
     * Nos permite conocer que transporte será el sigueinte que maneje la
     * petición en la cadena.
     *
     * @param siguiente Siguiente transporte en la cadena.
     */
    @Override
    public void setNext(Transporte siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Este método ayuda a manejar la petición y decidir cuál vehiculo será
     * utilizado.
     *
     * @param pedido Datos del pedido.
     * @return Transporte a utilizar.
     */
    @Override
    public abstract Transporte manejadorTransporte(Pedido pedido);

    /**
     * Permite obtener el costo que tendrá el transporte utilizado.
     *
     * @return Costo del transporte.
     */
    @Override
    public abstract double obtenerCosto();

    /**
     * Permite calcular el tiempo de entrega que tendrá el transporte utilizado.
     *
     * @param distancia Distancia de la entrega.
     * @return Tiempo de entrega del transporte.
     */
    @Override
    public abstract double calcularTiempo(Double distancia);
    
    /**
     * Método que permite obtener el nombre del transporte.
     *
     * @return Nombre del transporte
     */
    @Override
    public abstract String getNombre();

}
