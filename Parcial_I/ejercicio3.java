package Parcial_I;

import java.util.Scanner;

public class ejercicio3 {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de dinero en inversión: ");
        double capital = scanner.nextDouble();
        System.out.print("Ingrese el porcentaje de interés mensual (ej: 2 para 2%): ");
        double tasaInteres = scanner.nextDouble();

        // Calculamos cuánto dinero genera de interés
        double interesesGenerados = capital * (tasaInteres / 100);

        if (interesesGenerados > 50000) {
            System.out.println("Los intereses ($" + interesesGenerados + ") exceden los $50,000. Reinvirtiendo...");
            capital = capital + interesesGenerados;
        }

        System.out.println("Dinero final en la cuenta: $" + capital);
    }
}   

