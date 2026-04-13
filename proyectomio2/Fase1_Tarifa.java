import java.util.Scanner;

public class Fase1_Tarifa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la hora (0-23): ");
        int hora = sc.nextInt();

        System.out.println("1. Normal");
        System.out.println("2. Estudiante");
        System.out.println("3. Adulto mayor");
        System.out.println("4. Discapacitado");
        System.out.print("Seleccione tipo: ");
        int tipo = sc.nextInt();

        double tarifaBase = 0;
        double descuento = 0;
        double totalPagar;
        String nombreTipo = "";

        boolean esHoraValle = (hora >= 9 && hora <= 16);

        switch (tipo) {
            case 1:
                nombreTipo = "Normal";
                tarifaBase = 3000;
                break;

            case 2:
                nombreTipo = "Estudiante";
                tarifaBase = 1500;
                if (esHoraValle) {
                    descuento = tarifaBase * 0.10;
                }
                break;

            case 3:
                nombreTipo = "Adulto mayor";
                tarifaBase = 0;
                break;

            case 4:
                nombreTipo = "Discapacitado";
                tarifaBase = 0;
                break;

            default:
                System.out.println("Tipo invalido");
                return;
        }

        totalPagar = tarifaBase - descuento;

        System.out.println("\nTIQUETE MIO - CALI");
        System.out.println("Hora: " + hora);
        System.out.println("Tipo: " + nombreTipo);
        System.out.println("Tarifa base: $" + tarifaBase);
        System.out.println("Descuento: $" + descuento);
        System.out.println("TOTAL: $" + totalPagar);
    }
}