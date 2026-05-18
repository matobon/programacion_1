import java.util.ArrayList;

public class Actividad {
    private String idAct;
    private String nombre;
    private String area; // Deporte, Cultura, Salud
    private int cupos;
    private int bloqueHorario; // Entero para simplificar cruces (Requerimiento 5)
    private boolean esAltoImpacto; // Requerimiento 8
    private int horasValor;

    // Listas para manejar el flujo del taller
    private ArrayList<Estudiante> matriculados;
    private ArrayList<Estudiante> filaEspera;
    private ArrayList<Integer> notas;

    public Actividad(String idAct, String nombre, String area, int cupos, int bloqueHorario, boolean esAltoImpacto, int horasValor) {
        this.idAct = idAct;
        this.nombre = nombre;
        this.area = area;
        this.cupos = cupos;
        this.bloqueHorario = bloqueHorario;
        this.esAltoImpacto = esAltoImpacto;
        this.horasValor = horasValor;
        this.matriculados = new ArrayList<>();
        this.filaEspera = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getIdAct() { return idAct; }
    public String getNombre() { return nombre; }
    public String getArea() { return area; }
    public int getCupos() { return cupos; }
    public int getBloqueHorario() { return bloqueHorario; }
    public boolean isEsAltoImpacto() { return esAltoImpacto; }
    public int getHorasValor() { return horasValor; }
    
    public ArrayList<Estudiante> getMatriculados() { return matriculados; }
    public ArrayList<Estudiante> getFilaEspera() { return filaEspera; }
    public ArrayList<Integer> getNotas() { return notas; }
}