Firma del método - signature
 
visibilidad retorno nombredelmetodo (parámetros){
 
}
 
public double convertirDolares(double monedaLocal){

    return monedaLocal / 3631.44;

}
 
public void mostrarSaludo(String nombre){

    System.out.println("Bienvenido al curso " + nombre + "...");

}
 
public int descuento(int precio){

    return precio - (precio * 0.15)

}
 
public int calcularDescuento(int precio, int descuento){

    return precio - (precio * (descuento / 100))

}
