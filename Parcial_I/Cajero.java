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

            System.out.print("Bienvenidos al cajero Uniajc");
            System.out.print("digite la cantidad a retirar: ");
            retiro = sc.nextInt();
            //si el retiro es mayor a 200000 se cobra 2000
            if(retiro > 200000)  {
                retiro = retiro + 2000;

                 if ( retiro <= SALDOINICIAL)  { 
                      if nuevoSaldo = SALDOINICIAL - retiro;
                      System.out.print( "Su saldo actual es:" + nuevoSaldo + " Muchas Gracias!!!!");
                 } else { 
            System.out.print("El valor solicitado mas el costo de la transaccion es mayor al saldo");
             }
               } else { 
                if(retiro <= SALDOINICIAL)  {
                    nuevoSaldo = SALDOINICIAL - retiro;
                    System.out.println( "su saldo actual es: " + nuevoSaldo + Muchas Gracias!!!!");
                     } else { 
                    System.out.println( "El valor solicitado es mayor al saldo actual.... ");
                 }

                    }
                  } else { 
                System.out.println ("Su clave no es correcta...intenta nuevamente....");
             }
                sc.close();


                



            }

        


    }

