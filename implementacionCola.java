
import java.util.*;

/*Escriba un programa que implemente un TAD Cola de cadena de caracteres y que procese N operaciones.
Cada una de las operaciones a realizar corresponderá a una de las siguientes:

PUSH s: insertar el valor s en la cola
TOP: devolver el valor del primer elemento de la cola
POP: quitar el último elemento de la cola
EMPTY: indicar si la cola está vacía o no
SIZE: indicar cuántos elementos contiene la cola
Al procesar una operación TOP usted deberá imprimir en la salida estándar (stdout) el valor del último elemento agregado a la cola.

Al procesar una operación EMPTY usted deberá imprimir 1 si la cola está vacía o 0 si no lo está.

Es requisito que la capacidad máxima del TAD no supere 100000.

Input
En la primera línea recibirá el número entero N: número de operaciones a procesar.

Cada una de las siguientes N líneas contendrá una operación. Cada operación estará identificada por su nombre en letras mayúsculas: PUSH, TOP, POP, EMPTY o SIZE.

En el caso de que la operación sea PUSH, además del nombre de la operación, deberá leer una cadena de caracteres s a insertar en la cola (ver ejemplo).

Restricciones:

N:  1 ≤ N ≤ 150 000
s:  1 ≤  longitud(s)  ≤ 10
Las operaciones TOP y POP solo se recibirán en situaciones en las que la cola no debería estar vacía.
Se garantiza que no se recibirá una operación PUSH si hay 100 000 elementos almacenados.
Output
Deberá imprimir en la salida estándar (stdout) los resultados de las operaciones TOP, 
EMPTY y SIZE. Cada uno de esos resultados en una línea, es decir, los resultados deben estar separados por un salto de línea
*/

public class implementacionCola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //creo el escáner para leer la entrada
        int N = input.nextInt(); //leo el número de operaciones a procesar
        while ((N < 1) || (N > 100000)) { //verifico que N esté dentro de los límites establecidos
            N = input.nextInt();
        }
        cola c = new cola(N); //creo la cola con capacidad N
        leerOperaciones(input, N, c); //menu para leer las operaciones y procesarlas
    }

 
    public static void leerOperaciones (Scanner input, int N, cola c) { //método para leer las operaciones y procesarlas
        for (int i = 0; i < N; i++) { //un bucle for para leer las N operaciones
            String operacion = input.next();
            switch (operacion.toUpperCase()) { //swutch para procesar cada operación según su tipo
                case "PUSH":
                    String s = input.next();
                    c.push(s);
                    break;
                case "TOP":
                    System.out.println(c.top());
                    break;
                case "POP":
                    c.pop();
                    break;
                case "EMPTY":
                    System.out.println(c.empty() ? 1 : 0);
                    break;
                case "SIZE":
                    System.out.println(c.size());
                    break;
            }
        }
    }




    
}

class cola{ //TAD cola de cadena de caracteres
    private String[] elementos;
    private int frente;
    private int fin;
    private int cantidad;
    public cola(int N) {
        this.elementos = new String[N];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }
    public void push(String s) {
        fin++;
        elementos[fin] = s;
        cantidad++;
    }
    public String pop() {
        String valor = elementos[frente];
        frente++;
        cantidad--;
        return valor;
    }
    public String top() { // retorno el valor del frente
        return elementos[frente];
    }
    public boolean empty() { // retorna true si la cola está vacía, false en caso contrario
        return cantidad == 0;
    }
    public int size() { // retorna la cantidad de elementos en la cola
        return cantidad;
    }

}
