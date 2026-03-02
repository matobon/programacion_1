package Parcial_I;

import java.util.Scanner;

public class ejercicio2 {
    
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        int producto = num1 * num2;

        if (producto > 30) {
            System.out.println("El producto es mayor a 30.");
            System.out.println("Números ingresados: " + num1 + " y " + num2);
            System.out.println("Resultado: " + producto);
        } else {
            System.out.println("Resultado del producto: " + producto);
        }
    }
}

