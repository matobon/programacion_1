import java.util.Scanner;

public class ejercicio4 {
    public class Fase4_Reporte {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalPasajeros = 0;
        double totalRecaudo = 0;

        for (int i = 1; i <= 3; i++) {

            String ruta = (i == 1) ? "T31" : (i == 2) ? "A10" : "P22A";

            System.out.println("\nRuta: " + ruta);

            System.out.print("Pasajeros: ");
            int pasajeros = sc.nextInt();

            System.out.print("Vueltas: ");
            int vueltas = sc.nextInt();

            System.out.print("Porcentaje normal: ");
            int pctNormal = sc.nextInt();

            int pctEstudiante = 100 - pctNormal;

            double recaudo = (pasajeros * pctNormal * 3000 / 100.0) +
                             (pasajeros * pctEstudiante * 1500 / 100.0);

            totalPasajeros += pasajeros;
            totalRecaudo += recaudo;

            System.out.println("Recaudo: $" + recaudo);
        }

        System.out.println("\nTOTAL PASAJEROS: " + totalPasajeros);
        System.out.println("TOTAL RECAUDO: $" + totalRecaudo);
    }
}
}
