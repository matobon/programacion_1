public class ejercicio2 {
    import java.util.Scanner;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacidadMaxima = 80;
        int pasajerosActuales = 0;
        int totalSubieron = 0;
        int totalBajaron = 0;
        int paradasRecorridas = 0;
        int paradasConAforo = 0;
        int parada = 1;
        boolean rutaActiva = true;

        while (parada <= 25 && rutaActiva) {

            System.out.println("\n=== PARADA " + parada + " ===");
            System.out.println("Pasajeros actuales: " + pasajerosActuales);

            System.out.print("Suben (-1 para terminar): ");
            int suben = sc.nextInt();

            if (suben == -1) {
                rutaActiva = false;
            } else {
                System.out.print("Bajan: ");
                int bajan = sc.nextInt();

                if (bajan > pasajerosActuales) {
                    bajan = pasajerosActuales;
                }

                if (pasajerosActuales + suben - bajan > capacidadMaxima) {
                    suben = capacidadMaxima - pasajerosActuales + bajan;
                }

                pasajerosActuales = pasajerosActuales + suben - bajan;

                totalSubieron += suben;
                totalBajaron += bajan;

                if (pasajerosActuales == 80) {
                    paradasConAforo++;
                }

                double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;

                if (pasajerosActuales == 80) {
                    System.out.println("AFORO MAXIMO");
                } else if (porcentaje >= 60) {
                    System.out.println("BUS LLENO");
                } else {
                    System.out.println("NORMAL");
                }

                parada++;
                paradasRecorridas++;
            }
        }

        System.out.println("\nRESUMEN");
        System.out.println("Paradas: " + paradasRecorridas);
        System.out.println("Subieron: " + totalSubieron);
        System.out.println("Bajaron: " + totalBajaron);
        System.out.println("Final: " + pasajerosActuales);
        System.out.println("Aforo max: " + paradasConAforo);
    }
}
}
