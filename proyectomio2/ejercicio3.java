import java.util.Scanner;

public class ejercicio3 {
    public class Fase3_Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n1. Tarifa");
            System.out.println("2. Ruta");
            System.out.println("3. Reporte");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ir a Fase 1");
                    break;
                case 2:
                    System.out.println("Ir a Fase 2");
                    break;
                case 3:
                    System.out.println("Disponible en Fase 4");
                    break;
                case 0:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
}
