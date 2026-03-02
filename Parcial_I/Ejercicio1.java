package Parcial_I;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor de las ventas: ");
        double ventas = sc.nextDouble();

        double comision = 0;

        if (ventas > 1000000) {
            comision = ventas * 0.05;
        }

        System.out.println("Comisión: $" + comision);

        sc.close();
    }
}