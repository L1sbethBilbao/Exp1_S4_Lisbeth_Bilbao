package javaapplication4;

/**
 *
 * @author lisbe
 */
import java.util.Scanner;

public class JavaApplication4 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("----BIENVENIDOS AL SISTEMA DE VENTAS DEL TEATRO MORO---- ");

            final int CANTIDAD_ENTRADAS = 3;

            int entradasVipDisponibles = CANTIDAD_ENTRADAS;
            int entradasPlateaBajaDisponibles = CANTIDAD_ENTRADAS;
            int entradasPlateaAltaDisponibles = CANTIDAD_ENTRADAS;
            int entradasPalcoDisponibles = CANTIDAD_ENTRADAS;

            double acumuladorPrecioEntradas = 0;
            double contadorEntradas = 0;

            boolean muestraMenu = true;
            while (muestraMenu) {
                int opcion = 0;

                boolean mostrarMenuPrincipal = true;
                while (mostrarMenuPrincipal) {
                    System.out.println("MENU PRINCIPAL: ");
                    System.out.println("- ELIGA EL NUMERO QUE CORRESPONDA A SU OPCION ");
                    System.out.println(" 1. COMPRAR ENTRADA ");
                    System.out.println(" 2. SALIR ");

                    opcion = sc.nextInt();

                    //validaciones menu principal
                    if (opcion < 1) {
                        System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                        mostrarMenuPrincipal = true;
                    } else if (opcion > 2) {
                        System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                        mostrarMenuPrincipal = true;
                    }

                    mostrarMenuPrincipal = false;

                }
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has elegido: OPCION 1 COMPRAR ENTRADA");
                        muestraMenu = false;

                        double descuento;
                        double iva = 0;
                        String nombre_entrada = "";
                        String nombre_tarifa = "";
                        double precio = 0;
                        double subtotal_con_descuento;
                        int tipo_entrada = 0;
                        int tipo_tarifa;
                        double total = 0;
                        int edad = 0;

                        if ((entradasVipDisponibles == 0 && entradasPlateaBajaDisponibles == 0)
                                && (entradasPlateaAltaDisponibles == 0 && entradasPalcoDisponibles == 0)) {
                            boolean mostrarSalidaAgotadas = true;
                            while (mostrarSalidaAgotadas) {
                                System.out.println("\u001B[31m *** Entradas agotadas *** \u001B[31m");
                                muestraMenu = true;
                                int salir = 0;
                                System.out.println("- ¿Desea salir del sistema?");
                                System.out.println("1- Si ");
                                System.out.println("2- No ");
                                salir = sc.nextInt();

                                //validaciones menu
                                if (salir < 1) {
                                    System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                                    mostrarSalidaAgotadas = true;
                                } else if (salir > 2) {
                                    System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                                    mostrarSalidaAgotadas = true;
                                }

                                if (salir == 1) {
                                    //al agotarse entradas y usuario quiere salir, se cierra el sistema
                                    System.exit(0);
                                }

                                mostrarSalidaAgotadas = false;
                            }
                        }

                        // VARIABLES
                        boolean mostrarMenuTipoEntrada = true;

                        while (mostrarMenuTipoEntrada) {
                            // TIPOS DE ENTRADAS
                            System.out.println("- ¿Que tipo de entrada desea comprar?");
                            System.out.println("     Seleccione un numero de opcion del 1 al 4: ");
                            System.out.println(" 1.- VIP , entradas disponibles:" + entradasVipDisponibles);
                            System.out.println(" 2.- PLATEA BAJA,entradas disponibles:" + entradasPlateaBajaDisponibles);
                            System.out.println(" 3.- PLATEA ALTA,entradas disponibles:" + entradasPlateaAltaDisponibles);
                            System.out.println(" 4.- PALCO,entradas disponibles:" + entradasPalcoDisponibles);
                            tipo_entrada = sc.nextInt();

                            if (tipo_entrada < 1) {
                                System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                                mostrarMenuTipoEntrada = true;
                            } else if (tipo_entrada > 4) {
                                System.out.println("\u001B[31m *** Opcion Invalida *** \u001B[31m");
                                mostrarMenuTipoEntrada = true;
                            } else {
                                mostrarMenuTipoEntrada = false;
                            }
                        }
                        if (tipo_entrada == 1) {
                            if (entradasVipDisponibles > 0) {
                                entradasVipDisponibles = entradasVipDisponibles - 1;
                            } else {
                                System.out.println("\u001B[31m ***No quedan entradas VIP Disponibles*** \u001B[31m");
                                muestraMenu = true;
                            }
                        } else if (tipo_entrada == 2) {
                            if (entradasPlateaBajaDisponibles > 0) {
                                entradasPlateaBajaDisponibles = entradasPlateaBajaDisponibles - 1;
                            } else {
                                System.out.println("\u001B[31m ***No quedan entradas PLATEA BAJA Disponibles*** \u001B[31m");
                                muestraMenu = true;
                            }
                        } else if (tipo_entrada == 3) {
                            if (entradasPlateaAltaDisponibles > 0) {
                                entradasPlateaAltaDisponibles = entradasPlateaAltaDisponibles - 1;
                            } else {
                                System.out.println("\u001B[31m ***No quedan entradas PLATEA ALTA Disponibles*** \u001B[31m");
                                muestraMenu = true;
                            }
                        } else if (tipo_entrada == 4) {
                            if (entradasPalcoDisponibles > 0) {
                                entradasPalcoDisponibles = entradasPalcoDisponibles - 1;
                            } else {
                                System.out.println("\u001B[31m ***No quedan entradas PALCO Disponibles*** \u001B[31m");
                                muestraMenu = true;
                            }
                        }

                        if (!muestraMenu) {
                            // TARIFAS
                            boolean muestraMenuEdad = true;
                            while (muestraMenuEdad) {
                                System.out.println("Ingrese su edad en numeros");
                                edad = sc.nextInt();

                                if (edad < 1) {
                                    System.out.println("\u001B[31m ***Edad No Valida*** \u001B[31m");
                                } else if (edad > 100) {
                                    System.out.println("\u001B[31m ***Edad No Valida*** \u001B[31m");
                                } else {
                                    muestraMenuEdad = false;
                                }

                            }

                            if (edad < 18) {
                                tipo_tarifa = 1; // estudiante
                            } else if (edad >= 60) {
                                tipo_tarifa = 3; // adulto mayor
                            } else {
                                tipo_tarifa = 2; // público general
                            }

                            if (tipo_tarifa == 1) {
                                // Estudiante
                                switch (tipo_entrada) {
                                    case 1 ->
                                        precio = 20000;
                                    case 2 ->
                                        precio = 10000;
                                    case 3 ->
                                        precio = 9000;
                                    case 4 ->
                                        precio = 6500;
                                }
                            } else if (tipo_tarifa == 2) {
                                // Público general
                                switch (tipo_entrada) {
                                    case 1 ->
                                        precio = 30000;
                                    case 2 ->
                                        precio = 15000;
                                    case 3 ->
                                        precio = 18000;
                                    case 4 ->
                                        precio = 13000;
                                }
                            } else if (tipo_tarifa == 3) {
                                // adulto mayor
                                switch (tipo_entrada) {
                                    case 1 ->
                                        precio = 30000;
                                    case 2 ->
                                        precio = 15000;
                                    case 3 ->
                                        precio = 18000;
                                    case 4 ->
                                        precio = 13000;
                                }
                            }
                            // OPERACIONES ARITMeTICAS 
                            //subtotal_con_descuento = precio - iva;
                            if (tipo_tarifa == 1) {
                                descuento = precio * 0.1;
                                subtotal_con_descuento = precio - descuento;
                                iva = (subtotal_con_descuento) * 0.19;
                                total = subtotal_con_descuento;

                            } else if (tipo_tarifa == 3) {
                                descuento = precio * 0.15;
                                subtotal_con_descuento = precio - descuento;
                                iva = (subtotal_con_descuento) * 0.19;
                                total = subtotal_con_descuento;
                            } else {
                                descuento = 0;
                                subtotal_con_descuento = precio - descuento;
                                iva = (subtotal_con_descuento) * 0.19;
                                total = subtotal_con_descuento;
                            }

                            //acumuluacion de precio
                            acumuladorPrecioEntradas = acumuladorPrecioEntradas + total;
                            contadorEntradas = contadorEntradas + 1;

                            // REDONDENDEANDO LOS VALORES
                            iva = Math.round(iva);
                            descuento = Math.round(descuento);

                            switch (tipo_entrada) {
                                case 1 ->
                                    nombre_entrada = "VIP";
                                case 2 ->
                                    nombre_entrada = "PLATEA BAJA";
                                case 3 ->
                                    nombre_entrada = "PLATEA ALTA";
                                case 4 ->
                                    nombre_entrada = "PALCO";
                            }
                            switch (tipo_tarifa) {
                                case 1 ->
                                    nombre_tarifa = "Estudiante";
                                case 2 ->
                                    nombre_tarifa = "Público General";
                                case 3 ->
                                    nombre_tarifa = "Adulto mayor";
                            }
                            System.out.println("\u001B[34m --------------------------------- \u001B[31m");
                            System.out.println("\u001B[34m *** USTED A SELECCIONADO *** \u001B[31m");
                            System.out.println("\u001B[34m Ubicación del asiento: " + nombre_entrada + "\u001B[31m");
                            System.out.println("\u001B[34m Tarifa: " + nombre_tarifa + "\u001B[31m");
                            System.out.println("\u001B[34m Precio Base entrada: " + (int) precio + "\u001B[31m");
                            System.out.println("\u001B[34m --------------------------------- \u001B[31m");
                            System.out.println("\u001B[34m *** EL VALOR FINAL INCLUYE: *** \u001B[31m");
                            if (tipo_tarifa == 1) {
                                System.out.println("\u001B[34m Descuento aplicado del 10%: $" + (int) descuento + "\u001B[31m");
                            }
                            if (tipo_tarifa == 3) {
                                System.out.println("\u001B[34m Descuento aplicado del 15%: $" + (int) descuento + "\u001B[31m");
                            }
                            System.out.println("\u001B[34m IVA incluido (19%): $" + (int) iva + "\u001B[31m");
                            System.out.println("\u001B[34m --------------------------------- \u001B[31m");
                            System.out.println("\u001B[34m Total a pagar: $" + (int) total + "\u001B[31m");
                            System.out.println("\u001B[34m --------------------------------- \u001B[31m");
                            System.out.println("\u001B[34m Cantidad Total de Entradas Vendidas:" + (int) contadorEntradas + "\u001B[31m");
                            System.out.println("\u001B[34m Total a Pagar Final:" + (int) acumuladorPrecioEntradas + "\u001B[31m");
                            System.out.println("\u001B[34m --------------------------------- \u001B[31m");
                            System.out.println("\u001B[34m *** Gracias por su compra, disfrute la función *** \u001B[31m");
                            muestraMenu = true;

                        }
                    }

                    case 2 -> {
                        System.out.println(" ***has elegido la opcion 2: SALIR DEL SISTEMA*** ");
                        muestraMenu = false;
                        break;
                    }
                    default -> {
                        System.out.println(" ***opcion invalida. Por favor,intenta nuevamente*** ");
                        break;
                    }

                }

            }

        }

    }

}
