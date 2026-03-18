import java.util.Scanner;

public class introduccion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        
        if (in.hasNextInt()) {
            int N = in.nextInt();
            while ((N > 10) || (N < 1)) {
                N = in.nextInt();
            }

          
            String[] palabras = new String[N];
            
           
            cargarPalabras(in, N, palabras);
            mostrarPalabras(palabras, N);
        }
        
        in.close();
    }

   
    public static void cargarPalabras(Scanner in, int N, String[] palabras) {
        for (int i = 0; i < N; i++) {
            palabras[i] = in.next();
        }
    }

  
    public static void mostrarPalabras(String[] palabras, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(palabras[i]);
            
       
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
      
        System.out.println();
    }
}