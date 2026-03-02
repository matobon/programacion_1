package Parcial_I;

import java.util.Scanner;

public class ejercicio4 {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el total de horas trabajadas en la semana: ");
        int horasTotales = scanner.nextInt();
        
        double salario;

        if (horasTotales <= 40) {
            // Pago normal
            salario = horasTotales * 2000;
        } else {
            // Pago con horas extras
            int horasNormales = 40;
            int horasExtras = horasTotales - 40;
            salario = (horasNormales * 2000) + (horasExtras * 2500);
        }

        System.out.println("El salario semanal total es de: $" + salario);
    }
} 

