/*
Desarrollar una aplicación en Java que permita ingresar información de varios padres de familia. La información que se necesita por cada padre de familia es:

Nombres y apellidos del padre de familia.
Sueldo semanal del padre de familia.
Número de hijos del padre de familia
Por cada hijo se debe preguntar el gasto semanal que tienen para: pasajes, bar, salidas

El usuario decidirá cuando termina el ingreso de información:

Al final se debe generar un reporte demo
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Invocamos el obj. Scanner para la entrada de datos
        Scanner entrada = new Scanner(System.in);

        // Declaracion e inicializacion de variables int numReportes, numTotalHijos
        int numReportes = 0;
        int numTotalHijos = 0;

        // Consultar sobre el numero de familias que ingresaran la informacion, que sera igual al tamano de los arrays y por lo tanto del numReportes
        System.out.println("Cuantos padres de familia ingresaran informacion?");
        numReportes = entrada.nextInt();

        // Declaracion de los arrays: nombres, apellidos, sueldoSemanal, gastosTotalesSalidas, gastosTotalesBar, gastosTotalesPasajes
        String [] nombres               = new String [numReportes];
        String [] apellidos             = new String [numReportes];
        Double [] sueldoSemanal         = new Double [numReportes];
        int    [] numHijos              = new int    [numReportes];
        double [] gastosTotalesSalidas  = new double [numReportes];
        double [] gastosTotalesBar      = new double [numReportes];
        double [] gastosTotalesPasajes  = new double [numReportes];

        // El array idFamilia identificara a que familia/reporte pertence ese hijo en concreto

        // Con un for, que iniciara en 0, ira rellenando cada posicion del array hasta llegar a numReportes
        for (int contador=0; contador<numReportes; contador++){
            // Rellena nombres[i]:
            System.out.println("Ingrese los nombres del padre # " + (contador+1) + ":");      // (contador+1) evita que el user se confunda al ingresar datos de un padre # 0
            nombres[contador] = entrada.next();         //Dice que no existe la

            // Rellena apellidos[i]:
            System.out.println("Ingrese los apellidos del padre # " + (contador+1) + ":");
            apellidos[contador] = entrada.next();

            // Rellena sueldoSemanal[i]:
            System.out.println("Ingrese el sueldo semanal del padre # " + (contador+1) + ":");
            sueldoSemanal[contador] = entrada.nextDouble();

            // Rellena numHijos[i]:
            System.out.println("Ingrese el # de hijos del padre # " + (contador+1) + ":");
            numHijos[contador] = entrada.nextInt();

            // Si el user ya relleno la ultima posicion, este if evita que le pregunte si quiere seuir rellenando
            if (contador != (numReportes-1)){
                // Consultar si desea seguir rellenando las posiciones
                System.out.println("Desea seguir rellenado mas padres de familia? SI/NO");

                // Si ingresa "NO" establecer al contador con un valor fuera de rango para salir del for
                if (entrada.next().equalsIgnoreCase("no")){
                    contador = numReportes;
                }
            }
        }

        // En este punto cuando ya se el numero de hijos que hay en total de todas las familias

        // Con un for que llegue hasta numHijos[numReporte] se ira sumando el # de hijos a la variable numTotalHijos
        for (int contador = 0; contador<numReportes; contador++){
            numTotalHijos += numHijos[contador];
        }

        // Declarar idFamilia, gastosPasajes, gastosBar, gastosSalidas y gastosTotales con un tamano de [numTotalHijos]
        int [] idFamilia = new int[numTotalHijos];

        double [] gastosPasajes = new double[numTotalHijos];        // Almacenan el gasto de cada hijo
        double [] gastosBar     = new double[numTotalHijos];
        double [] gastosSalidas = new double[numTotalHijos];
        double [] gastosTotales = new double[numTotalHijos];        // Almacena la suma de los 3 gastos de todos los hijos

        // Con el primer for se recorre las familias - con el segundo los hijos

        for(int contFamiIngresadas = 0; contFamiIngresadas < numReportes; contFamiIngresadas++){

            // Le asigna un valor incial a los arrays que guardan los valores totales:
            gastosTotalesBar[contFamiIngresadas] = 0;       // Asi podremos agregar valores
            gastosTotalesSalidas[contFamiIngresadas] = 0;
            gastosTotalesPasajes[contFamiIngresadas] = 0;

            for (int contHijosIngresados = 0; contHijosIngresados < numHijos[contFamiIngresadas]; contHijosIngresados++){
                System.out.println("Se procede a ingresar los hijos de " + nombres[contFamiIngresadas] + " :");

                idFamilia[contHijosIngresados] = contFamiIngresadas;    // Se identifica a ese hijo con esa familia

                // Ingresar gastosPasajes[contHijosIngresados]
                System.out.println("Ingrese los gastos en pasajes del hijo # " + (contHijosIngresados+1) + " :");
                gastosPasajes[contHijosIngresados] = entrada.nextDouble();    // (contHijosIngresados+1) para que comienza a contar desde 1

                // Ingresar gastosBar[contHijosIngresados]
                System.out.println("Ingrese los gastos en bares del hijo # " + (contHijosIngresados+1) + " :");
                gastosBar[contHijosIngresados] = entrada.nextDouble();

                // Ingresar gastosSalidas[contHijosIngresados]
                System.out.println("Ingrese los gastos en salidas del hijo # " + (contHijosIngresados+1) + " :");
                gastosSalidas[contHijosIngresados] = entrada.nextDouble();

                // Suma los los gastos a los valores totales
                gastosTotalesBar[contFamiIngresadas]        += gastosBar[contHijosIngresados];      // TODO: NO esta sumando correctamente
                gastosTotalesPasajes[contFamiIngresadas]    += gastosPasajes[contHijosIngresados];
                gastosTotalesSalidas[contFamiIngresadas]    += gastosSalidas[contHijosIngresados];
            }

            // Calcula el gasto final
            gastosTotales[contFamiIngresadas] = gastosTotalesBar[contFamiIngresadas] + gastosTotalesPasajes[contFamiIngresadas] + gastosTotalesSalidas[contFamiIngresadas];
        }

        // Imprimir el reporte

        // Con el primer for se recorre las familias - con el segundo los hijos
        for(int contFamiIngresadas = 0; contFamiIngresadas < numReportes; contFamiIngresadas++){
            System.out.println( "Reporte " + (contFamiIngresadas+1) + "\n \n" +
                                "Nombre del Padre de Familia: " + nombres[contFamiIngresadas] + " " + apellidos[contFamiIngresadas] + "\n" +
                                "Número de Hijos: " + numHijos[contFamiIngresadas] + "");

            System.out.println("Reporte de gastos:");
            System.out.println("Persona" + "\t\t" + "Pasaje" + "\t\t" + "Bar" + "\t\t" + "Salidas");

            for (int contHijosIngresados = 0; contHijosIngresados < numHijos[contFamiIngresadas]; contHijosIngresados++){
                System.out.println( "Hijo " + (contHijosIngresados+1) + "\t\t" + gastosPasajes[contHijosIngresados] + "\t\t" + gastosBar[contHijosIngresados] + "\t\t" +gastosSalidas[contHijosIngresados]);
            }
            // TODO: Cambiar a printf para poder ajustar el # de decimales, ademas hacer 2 tabulaciones
            System.out.printf("Totales:\t\t%.2f\t\t%.2f\t\t%.2f\n", gastosTotalesPasajes[contFamiIngresadas], gastosTotalesBar[contFamiIngresadas], gastosTotalesSalidas[contFamiIngresadas]);
            // System.out.println("Totales" + "\t" + gastosTotalesPasajes[contFamiIngresadas] + "\t" + gastosTotalesBar[contFamiIngresadas] + gastosTotalesSalidas[contFamiIngresadas]);

            // calcula el balance ingresos/gastos
            double balance = sueldoSemanal[contFamiIngresadas] - gastosTotales[contFamiIngresadas];

            // Imprime el texto especifico para cada caso
            if (gastosTotales[contFamiIngresadas] > sueldoSemanal[contFamiIngresadas]){         // Si los gastos son mayores que los ingresos
                // TODO: Cambiar a printf para poder ajustar el # de decimales en las 3 condiciones
                System.out.printf("El padre de familia %s le faltan %.2f$ para sus gastos.", nombres[contFamiIngresadas], balance);
                //System.out.println("El padre de familia " + nombres[contFamiIngresadas] + " le falta " + balance + "$ para sus gastos.");
            }else if (gastosTotales[contFamiIngresadas] < sueldoSemanal[contFamiIngresadas]){   // Si los ingresos son mayores que los gastos
                System.out.printf("El padre de familia %s puede cubrir sus gastos y le sobran %.2f$.", nombres[contFamiIngresadas], balance);
                //System.out.println("El padre de familia " + nombres[contFamiIngresadas] + " , puede cubrir sus gastos y le sobran " + balance + " $.");
            }else{      // Si no significa que los gastos son iguales que los ingresos, por lo tanto...
                System.out.printf("El padre de familia tiene los ingresos justos para cubrir sus gastos");
                //System.out.println("El padre de familia " + nombres[contFamiIngresadas] + " tienen los ingresos justos para cubrir sus gastos. ");
            }

            System.out.println("Fin del reporte " + (contFamiIngresadas+1) + "\n\n");
        }
        // TODO: Revisar si esta haciendo bien los calculos totales

    }
}
