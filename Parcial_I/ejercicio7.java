package Parcial_I;

import java.util.Scanner;

public class ejercicio7 {
     public static void main(String[] args) {
        Scanner (entrada) = new Scanner(System.in);
        
        System.out.println("Seleccione el electrodoméstico:");
        System.out.println("1. Nevera ($1,200,000)");
        System.out.println("2. Lavadora ($790,000)");
        System.out.println("3. Calentador ($480,000)");
        System.out.println("4. Aire Acondicionado ($1,000,000)");
        int opcion = entrada.nextInt();
        
        System.out.print("Ingrese la cantidad de unidades: ");
        int cantidad = entrada.nextInt();
        
        double precioUnitario = 0;
        double transporte = 0;
        
        // Asignación de valores según la tabla proporcionada
        switch (opcion) {
            case 1: precioUnitario = 1200000; transporte = 15000; break;
            case 2: precioUnitario = 790000;  transporte = 10000; break;
            case 3: precioUnitario = 480000;  transporte = 5000;  break;
            case 4: precioUnitario = 1000000; transporte = 7000;  break;
            default:
                System.out.println("Opción inválida.");
                return;
        }
        
        double subtotal = precioUnitario * cantidad;
        double iva = subtotal * 0.20; // IVA del 20%
        double totalPagar = subtotal + iva + transporte;
        
        System.out.println("\n--- Resumen de Compra ---");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (20%): $" + iva);
        System.out.println("Transporte: $" + transporte);
        System.out.println("TOTAL A PAGAR: $" + totalPagar);
    }
}

