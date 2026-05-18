public class Estudiante {
    private String documento;
    private String nombre;
    private double promedio;
    
    // Horas acumuladas por cada area (Requerimiento 2)
    private int hDeporte;
    private int hCultura;
    private int hSalud;
    
    // Variables basicas para controlar el Bono (Requerimiento 7)
    private int racha;
    private String ultimaArea;

    public Estudiante(String documento, String nombre, double promedio) {
        this.documento = documento;
        this.nombre = nombre;
        this.promedio = promedio;
        this.hDeporte = 0;
        this.hCultura = 0;
        this.hSalud = 0;
        this.racha = 0;
        this.ultimaArea = "";
    }

    // Métodos de acceso estandar (Encapsulamiento)
    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    
    public int getHDeporte() { return hDeporte; }
    public void setHDeporte(int hDeporte) { this.hDeporte = hDeporte; }

    public int getHCultura() { return hCultura; }
    public void setHCultura(int hCultura) { this.hCultura = hCultura; }

    public int getHSalud() { return hSalud; }
    public void setHSalud(int hSalud) { this.hSalud = hSalud; }

    public int getRacha() { return racha; }
    public void setRacha(int racha) { this.racha = racha; }

    public String getUltimaArea() { return ultimaArea; }
    public void setUltimaArea(String ultimaArea) { this.ultimaArea = ultimaArea; }
}