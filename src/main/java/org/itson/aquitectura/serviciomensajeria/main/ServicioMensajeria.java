package org.itson.aquitectura.serviciomensajeria.main;

import java.util.Scanner;
import org.itson.aquitectura.serviciomensajeria.paquete.Paquete;
import org.itson.aquitectura.serviciomensajeria.paquete.TipoPaquete;
import org.itson.aquitectura.serviciomensajeria.pedido.Pedido;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.EstandarStrategy;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.ExpressStrategy;
import org.itson.aquitectura.serviciomensajeria.serviciostrategy.ServicioStrategy;
import org.itson.aquitectura.serviciomensajeria.transportechain.Auto;
import org.itson.aquitectura.serviciomensajeria.transportechain.Bicicleta;
import org.itson.aquitectura.serviciomensajeria.transportechain.Dron;
import org.itson.aquitectura.serviciomensajeria.transportechain.Moto;
import org.itson.aquitectura.serviciomensajeria.transportechain.Transporte;

/**
 * Clase Main que nos permite crear el menú donde el usuario ingresa los datos
 * del pedido.
 *
 * @author Víctor Humberto Encinas Guzmán
 */
public class ServicioMensajeria {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        ServicioStrategy servicio = seleccionarServicio(tec);
        Paquete paquete = seleccionarPaquete(tec);

        System.out.println("\nIngrese la distancia del pedido en KM");
        System.out.print("Respuesta: ");
        Double distancia = tec.nextDouble();

        Pedido pedido = new Pedido(servicio, paquete, distancia);

        Transporte dron = new Dron();
        Transporte bicicleta = new Bicicleta();
        Transporte moto = new Moto();
        Transporte auto = new Auto();

        dron.setNext(bicicleta);
        bicicleta.setNext(moto);
        moto.setNext(auto);

        Transporte transporte = dron.manejadorTransporte(pedido);

        if (transporte != null) {
            pedido.setTransporte(transporte);
        } else {
            System.out.println("No hay transportes que puedan procesar el pedido");
        }

        double tiempoEntrega = transporte.calcularTiempo(pedido.getDistancia());

        double costoTotal = servicio.calcularCosto(pedido);

        System.out.println("\nSeleccione la moneda a utilizar:");
        System.out.println("1. Pesos mexicano");
        System.out.println("2. Dolar estadounidense");

        System.out.print("Opcion: ");
        int seleccion = tec.nextInt();

        if (seleccion == 2) {
            costoTotal = costoTotal / 20;
        }

        System.out.println("\nEl costo del pedido es de $" + costoTotal
                + ", se entregará en " + transporte.getNombre()
                + " en un tiempo aproximado de " + tiempoEntrega + " minutos.");

    }

    /**
     * Método que permite seleccionar un servicio según la opción indicada por
     * el usuario.
     *
     * @param scanner Scanner para detectar el contenido escrito.
     * @return El servicio elegido.
     */
    public static ServicioStrategy seleccionarServicio(Scanner scanner) {
        ServicioStrategy servicio = null;

        System.out.println("\nSeleccione un servicio: ");
        System.out.println("1. Estandar");
        System.out.println("2. Express");

        System.out.print("Opcion: ");
        int seleccion = scanner.nextInt();

        switch (seleccion) {
            case 1:
                servicio = new EstandarStrategy();
                break;
            case 2:
                servicio = new ExpressStrategy();
                break;
            default:
                System.out.println("Opción no válida.");
        }

        return servicio;
    }

    /**
     * Método que permite seleccionar un paquete según la opción indicada por
     * el usuario.
     *
     * @param scanner Scanner para detectar el contenido escrito.
     * @return El paquete elegido.
     */
    public static Paquete seleccionarPaquete(Scanner scanner) {
        Paquete paquete = null;

        System.out.println("\nElige un tipo de paquete:");
        System.out.println("1. Sobre");
        System.out.println("2. Caja pequeña");
        System.out.println("3. Caja Mediana");
        System.out.println("4. Caja Grande");

        System.out.print("Opcion: ");
        int seleccion = scanner.nextInt();

        switch (seleccion) {
            case 1:
                paquete = new Paquete(TipoPaquete.SOBRE);
                break;
            case 2:
                paquete = new Paquete(TipoPaquete.CAJA_PEQUENA);
                break;
            case 3:
                paquete = new Paquete(TipoPaquete.CAJA_MEDIANA);
                break;
            case 4:
                paquete = new Paquete(TipoPaquete.CAJA_GRANDE);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        return paquete;
    }

}
