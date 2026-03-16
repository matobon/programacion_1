import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int suma = 0;
        int numero;
        int contador = 0;
        System.out.println("Ingrese un numero (negativo para terminar)");
        numero = teclado.nextInt();
        while (numero >= 0) {
            suma = suma + numero;
            contador = contador + 1;
            System.out.println("Ingrese un numero (negativo para terminar");
            numero = teclado.nextInt();

        }
        System.out.println("El promedio es: " + (suma / contador));
        teclado.close();
    }
}
