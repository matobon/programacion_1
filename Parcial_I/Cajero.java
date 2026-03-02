package Parcial_I;

import java.util.Scanner;

public class Cajero {
    public static void main(String[] args) {
        
        // Constantes 
         int CLAVE = 1234;
         int SALDOINICIAL = 800000;

        //Variables
        int claveUsuario;
        int retiro;
        int nuevosaldo;

        Scanner sc = new Scanner(System.in);

        // Leer clave
        System.out.print("Ingrese su clave: ");
        claveUsuario = sc.nextInt();

        if (CLAVE == claveUsuario ){

            System.out.print("Bienvenidos al cajero uniajc");
            System.out.print("digite la cantidad a retirar: ");
            retiro = sc.nextInt();
            //si el retiro es mayor a 200000 se cobra 2000
            if(retiro > 200000)  {
                retiro = retiro + 2000;

                SALDOINICIAL)  { 
                      nuevoSaldo = 
            


            }

        }


    }
}
