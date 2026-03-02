package Parcial_I;

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el salario mensual del trabajador: ");
        double salario = entrada.nextDouble();
        System.out.print("Ingrese los años de antigüedad en la empresa: ");
        double antiguedad = entrada.nextDouble();
        
        double porcentajeUtilidad;
        
        // Determinación del porcentaje según la tabla
        if (antiguedad < 1) {
            porcentajeUtilidad = 0.05; // Menos de 1 año: 5%
        } else if (antiguedad >= 1 && antiguedad < 2) {
            porcentajeUtilidad = 0.07; // 1 año y menos de 2: 7%
        } else if (antiguedad >= 2 && antiguedad < 5) {
            porcentajeUtilidad = 0.10; // 2 años y menos de 5: 10%
        } else if (antiguedad >= 5 && antiguedad < 10) {
            porcentajeUtilidad = 0.15; // 5 años y menos de 10: 15%
        } else {
            porcentajeUtilidad = 0.20; // 10 años o más: 20%
        }
        
        double utilidadFinal = salario * porcentajeUtilidad;
        System.out.println("Al trabajador le corresponde una utilidad de: $" + utilidadFinal);
    }
}

