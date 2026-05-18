import java.util.Scanner;
import java.util.ArrayList;

public class BienestarUNIAJC {
    
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Actividad> actividades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        // Datos de prueba iniciales para que el sistema funcione de una vez
        estudiantes.add(new Estudiante("1001", "Megan Tobon", 4.2));
        estudiantes.add(new Estudiante("1002", "Pedro Gomez", 3.8));
        
        actividades.add(new Actividad("A1", "Torneo Futbol", "Deporte", 2, 1, false, 4));
        actividades.add(new Actividad("A2", "Clase Danzas", "Cultura", 10, 2, false, 5));
        actividades.add(new Actividad("A3", "Charla Nutricion", "Salud", 12, 1, true, 6));

        int opc = 0;
        do {
            System.out.println("\n--- BIENESTAR INSTITUCIONAL UNIAJC ---");
            System.out.println("1. Registrar estudiante a una actividad");
            System.out.println("2. Cancelar inscripcion");
            System.out.println("3. Calificar una actividad");
            System.out.println("4. Revisar estado para graduacion");
            System.out.println("5. Ver listado de actividades");
            System.out.println("6. Salir del programa");
            System.out.print("Seleccione una opcion: ");
            opc = entrada.nextInt();
            entrada.nextLine(); // Limpiar el salto de linea del Scanner

            switch(opc) {
                case 1:
                    registrarAlumno(entrada);
                    break;
                case 2:
                    cancelarCupo(entrada);
                    break;
                case 3:
                    calificarActo(entrada);
                    break;
                case 4:
                    evaluarGraduacion(entrada);
                    break;
                case 5:
                    mostrarResumen();
                    break;
                case 6:
                    System.out.println("Cerrando el sistema de bienestar...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while(opc != 6);
    }

    private static void registrarAlumno(Scanner entrada) {
        System.out.print("Ingrese documento del alumno: ");
        String doc = entrada.nextLine();
        Estudiante e = buscarEstudiante(doc);
        
        if (e == null) {
            System.out.println("El estudiante no se encuentra registrado.");
            return;
        }

        System.out.print("Ingrese codigo de la actividad: ");
        String cod = entrada.nextLine();
        Actividad a = buscarActividad(cod);

        if (a == null) {
            System.out.println("La actividad no existe.");
            return;
        }

        // Requerimiento 8: Restriccion por Promedio
        if (a.isEsAltoImpacto() && e.getPromedio() < 4.0) {
            System.out.println("Rechazado: Promedio insuficiente para eventos de alto impacto.");
            return;
        }

        // Requerimiento 5: Validacion de cruce de horario
        for (int i = 0; i < actividades.size(); i++) {
            Actividad aux = actividades.get(i);
            if (aux.getMatriculados().contains(e) && aux.getBloqueHorario() == a.getBloqueHorario()) {
                System.out.println("Rechazado: Ya tiene otra actividad en este mismo bloque horario.");
                return;
            }
        }

        if (a.getMatriculados().contains(e) || a.getFilaEspera().contains(e)) {
            System.out.println("El alumno ya esta registrado en este taller.");
            return;
        }

        // Requerimiento 3 y 4: Manejo de Cupos Dinamicos y Cola de Espera
        if (a.getMatriculados().size() < a.getCupos()) {
            a.getMatriculados().add(e);
            System.out.println("Inscripcion confirmada.");
            sumarHoras(e, a.getArea(), a.getHorasValor());
            evaluarBono(e, a.getArea());
        } else {
            a.getFilaEspera().add(e);
            System.out.println("Cupo agotado. El estudiante paso a la lista de espera.");
        }
    }

    private static void cancelarCupo(Scanner entrada) {
        System.out.print("Ingrese documento del alumno: ");
        String doc = entrada.nextLine();
        Estudiante e = buscarEstudiante(doc);

        System.out.print("Ingrese codigo de la actividad: ");
        String cod = entrada.nextLine();
        Actividad a = buscarActividad(cod);

        if (e == null || a == null) {
            System.out.println("Datos incorrectos de busqueda.");
            return;
        }

        if (a.getMatriculados().contains(e)) {
            a.getMatriculados().remove(e);
            System.out.print("¿Cancela a ultima hora? (si/no): ");
            String res = entrada.nextLine();
            
            // Requerimiento 6: Penalizaciones
            if (res.equalsIgnoreCase("si")) {
                restarHoras(e, a.getArea(), 2);
                System.out.println("Cancelado. Penalizacion aplicada de -2 horas por aviso tardio.");
            } else {
                restarHoras(e, a.getArea(), a.getHorasValor());
                System.out.println("Cancelado de manera exitosa.");
            }

            // Requerimiento 4: Movimiento automatico desde la lista de espera (FIFO)
            if (a.getFilaEspera().size() > 0) {
                Estudiante sgte = a.getFilaEspera().remove(0); // Saca al primero de la lista
                a.getMatriculados().add(sgte);
                sumarHoras(sgte, a.getArea(), a.getHorasValor());
                evaluarBono(sgte, a.getArea());
                System.out.println("El alumno " + sgte.getNombre() + " tomo el cupo libre desde la lista de espera.");
            }
        } else if (a.getFilaEspera().contains(e)) {
            a.getFilaEspera().remove(e);
            System.out.println("Removido de la lista de espera.");
        } else {
            System.out.println("El alumno no pertenece a este taller.");
        }
    }

    private static void calificarActo(Scanner entrada) {
        System.out.print("Codigo de la actividad: ");
        String cod = entrada.nextLine();
        Actividad a = buscarActividad(cod);

        if (a == null) {
            System.out.println("Taller no encontrado.");
            return;
        }

        System.out.print("Califique la actividad de 1 a 5: ");
        int pts = entrada.nextInt();
        if (pts >= 1 && pts <= 5) {
            a.getNotas().add(pts);
            System.out.println("Calificacion guardada con exito.");
        } else {
            System.out.println("Valor fuera del rango permitido.");
        }
    }

    private static void evaluarGraduacion(Scanner entrada) {
        System.out.print("Ingrese documento del alumno: ");
        String doc = entrada.nextLine();
        Estudiante e = buscarEstudiante(doc);

        if (e == null) return;

        System.out.println("\n--- CERTIFICACION DE BIENESTAR ---");
        System.out.println("Alumno: " + e.getNombre());
        System.out.println("Horas en Deportes: " + e.getHDeporte() + " / 10");
        System.out.println("Horas en Cultura: " + e.getHCultura() + " / 10");
        System.out.println("Horas en Salud: " + e.getHSalud() + " / 10");

        // Requerimiento 2 y 10: Validar de forma independiente las 10 horas de cada area
        if (e.getHDeporte() >= 10 && e.getHCultura() >= 10 && e.getHSalud() >= 10) {
            System.out.println("ESTADO: >> APTO PARA GRADUACION <<");
        } else {
            System.out.println("ESTADO: >> NO APTO (Faltan horas obligatorias) <<");
        }
    }

    private static void mostrarResumen() {
        System.out.println("\n--- LISTADO GENERAL ---");
        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            double suma = 0, prom = 0;
            
            // Requerimiento 9: Metricas de satisfaccion calculadas manualmente
            for (int j = 0; j < act.getNotas().size(); j++) {
                suma += act.getNotas().get(j);
            }
            if (act.getNotas().size() > 0) {
                prom = suma / act.getNotas().size();
            }
            
            System.out.println("Taller: " + act.getNombre() + " [" + act.getArea() + "]");
            System.out.println("  Cupos: " + act.getMatriculados().size() + "/" + act.getCupos() + " | Espera: " + act.getFilaEspera().size());
            System.out.println("  Satisfaccion Promedio: " + prom + " / 5.0");
            System.out.println("----------------------------------------");
        }
    }

    // Busquedas basicas secuenciales manuales
    private static Estudiante buscarEstudiante(String id) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getDocumento().equals(id)) return estudiantes.get(i);
        }
        return null;
    }

    private static Actividad buscarActividad(String id) {
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getIdAct().equalsIgnoreCase(id)) return actividades.get(i);
        }
        return null;
    }

    private static void sumarHoras(Estudiante e, String area, int cant) {
        if (area.equalsIgnoreCase("Deporte")) e.setHDeporte(e.getHDeporte() + cant);
        if (area.equalsIgnoreCase("Cultura")) e.setHCultura(e.getHCultura() + cant);
        if (area.equalsIgnoreCase("Salud")) e.setHSalud(e.getHSalud() + cant);
    }

    private static void tratarDeRestar(Estudiante e, String area, int cant) {
        if (area.equalsIgnoreCase("Deporte")) e.setHDeporte(Math.max(0, e.getHDeporte() - cant));
        if (area.equalsIgnoreCase("Cultura")) e.setHCultura(Math.max(0, e.getHCultura() - cant));
        if (area.equalsIgnoreCase("Salud")) e.setHSalud(Math.max(0, e.getHSalud() - cant));
    }

    // Requerimiento 7: Lógica del Bono de Rendimiento UNIAJC
    private static void evaluarBono(Estudiante e, String areaActual) {
        if (e.getUltimaArea().equals(areaActual)) {
            e.setRacha(e.getRacha() + 1);
        } else {
            e.setRacha(1);
            e.setUltimaArea(areaActual);
        }

        if (e.getRacha() == 3) {
            sumarHoras(e, areaActual, 5);
            System.out.println("¡Bono Aplicado! +5 horas extras en " + areaActual + " por consistencia.");
            e.setRacha(0); // Reiniciar el ciclo
        }
    }
}