package Parcial_I;

import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {

        final int CLAVE = 1234;
        final int SALDO_INICIAL = 800000;

        Scanner sc = new Scanner(System.in);
        int saldo = SALDO_INICIAL;

        System.out.print("Ingrese su clave: ");
        int claveUsuario = sc.nextInt();

        if (claveUsuario != CLAVE) {
            System.out.println("Clave incorrecta. Intente nuevamente.");
        } else {

            System.out.println("Bienvenido al cajero Uniajc");
            System.out.print("Digite la cantidad a retirar: ");
            int retiro = sc.nextInt();

            // Comisión si retira más de 200000
            if (retiro > 200000) {
                retiro += 2000;
            }

            if (retiro <= saldo) {
                saldo -= retiro;
                System.out.println("Retiro exitoso.");
                System.out.println("Su saldo actual es: " + saldo);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }

        sc.close();
    }
}