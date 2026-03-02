package Parcial_I;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de camisas compradas: ");
        int cantidad = entrada.nextInt();
        System.out.print("Ingrese el precio total de la compra sin descuento: ");
        double totalCompra = entrada.nextDouble();
        
        double descuento;
        // Si se compran 3 camisas o más, descuento del 20%
        if (cantidad >= 3) {
            descuento = totalCompra * 0.20;
        } else {
            // Si son menos de 3, descuento del 10%
            descuento = totalCompra * 0.10;
        }
        
        double totalPagar = totalCompra - descuento;
        
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total final a pagar: $" + totalPagar);
    }
}

