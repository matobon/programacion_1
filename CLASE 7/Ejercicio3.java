import java.util.Scanner;

public class Ejercicio3 {
 public static void main(String[] args) {
     
    Scanner sc = new Scanner(System.in);
    System.out.println("numero para la tabla de multiplicar ");
    int n = sc.nextInt();
    
    for (int i = 1; i <= 10; i++ ){
        System.out.println(n + "X" + i + "=" + (i * n ));
    }
            
 }   
}
