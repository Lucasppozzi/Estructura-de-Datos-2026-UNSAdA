import java.util.Scanner; // importo el escanner para poder usarlo
public class invertirOrden {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // declaro el escaner para leer la entrada del usuario
        int N = in.nextInt(); // leo el número de elementos que el usuario ingresar
        while (N < 2 || N > 5000) {  // verifico que N esta cumpla las restricciones
             N = in.nextInt(); // si no lo coumple vuelvo a leer N
        }   
        int tope = -1; // inicializo el tope de la pila

        int[] pila = new int[N]; // creo un arreglo de enteros con el tamaño de N para usarlo como pila

        for (int i = 0; i < pila.length; i++) { // recorro el número de elementos que el usuario ingresó
            int actual = in.nextInt(); // leo el siguiente número que el usuario ingresa
            tope = PUSH(pila, tope, actual); // agrego el número a la pila usando el método PUSH y actualizo el tope
        }
        imprimirPila(pila, tope); // llamo al metodo imprimirPila para mostrar los elementos de la pila en orden inverso
        in.close(); // cierro el escaner para liberar recursos
    }
     public static int PUSH(int[] pila, int tope, int actual) {
        tope++; 
        pila[tope] = actual; 
        return tope; 
    }
    public static int POP(int[] pila, int tope) { // método POP para eliminar un elemento de la pila, s
                                // implemente decrementamos el tope y retornamos el nuevo valor del tope
       return tope -1;
    }
    public static void imprimirPila(int[] pila, int tope) {
        while ( tope != -1) {
            System.out.print(pila[tope] + " "); // imprimo el elemento en la posición del tope seguido de un espacio
            tope = POP(pila, tope); // elimino el elemento de la pila usando el método POP y actualizo el tope
        }
    }
}
