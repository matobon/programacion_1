import java.util.Scanner;

public class ejercicio5 {
    public class Fase5_Alertas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int alertas = 0;

        for (int i = 1; i <= 3; i++) {

            String ruta = (i == 1) ? "T31" : (i == 2) ? "A10" : "P22A";

            System.out.println("\nRuta: " + ruta);

            System.out.print("Pasajeros: ");
            int p = sc.nextInt();

            System.out.print("Vueltas: ");
            int v = sc.nextInt();

            System.out.print("Retraso: ");
            int r = sc.nextInt();

            System.out.print("Recaudo: ");
            double rec = sc.nextDouble();

            boolean alerta = (p < 500 || v > 20 || r > 90 || rec < p * 1500 * 0.7);

            if (alerta) {
                alertas++;
                System.out.println("ALERTA");
            } else {
                System.out.println("OK");
            }
        }

        if (alertas == 0) System.out.println("NORMAL");
        else if (alertas == 1) System.out.println("REVISION MENOR");
        else if (alertas == 2) System.out.println("REVISION URGENTE");
        else System.out.println("CRITICA");
    }
}
}
