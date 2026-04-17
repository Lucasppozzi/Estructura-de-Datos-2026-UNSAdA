/*Ud. recibirá N operaciones asociadas a un TAD Pila de números enteros y deberá procesarlas en el orden en el que las recibe.

Hay 3 tipos de operaciones: PUSH, POP y MAX. Las 2 primeras corresponden a las operaciones típicas del TAD Pila; 
la tercera operación la llamaremos MAX y corresponde a hallar el máximo valor almacenado en la Pila.

PUSH x: insertar el valor x en la pila
POP: quitar el último elemento de la pila
MAX: indicar el mayor valor almacenado en la pila.
Por cada operación MAX que ud. reciba, deberá imprimir en una nueva línea el máximo valor presente en la Pila.

Input
En la primera línea recibirá el número entero N: número de operaciones a procesar.

Cada una de las siguientes N líneas contendrá una operación. Cada operación estará identificada por su nombre en letras mayúsculas: PUSH, POP o MAX.

En el caso de que la operación sea PUSH, además del nombre de la operación, deberá leer el número entero x a insertar en la pila (ver ejemplo).

Restricciones:

N:  3 ≤ N ≤ 100 000
x:   - 10000 ≤ x ≤ 10000
Las operaciones MAX y POP solo se recibirán en situaciones en las que la Pila no debería estar vacía.
Output
Por cada operación MAX imprima una nueva línea con el máximo valor almacenado en la Pila.



*/


import java.util.*;


public class maximo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // declaramos el scanner para leer la entrada
        int N = in.nextInt(); //leo la cantidad de operaciones a procesar
        while (N < 3 || N > 100000) { // verifico las restricciones para N
            N = in.nextInt();
        }
        int[] pila = new int[N]; // creo un arreglo para simular la pila
        int[] pilaMaximos = new int[N]; // creo un arreglo para almacenar los máximos en cada posición de la pila
        int tope = -1; // inicializo el tope de la pila en -1, lo que indica que la pila está vacía
        for (int i = 0; i < N; i++) { // proceso cada una de las N operaciones
            String operacion = in.next().toLowerCase(); // leo la operación y la convierto a minúscula para facilitar la comparación
          switch (operacion) { //switch para determinar qué operación se va a realizar
              case "push": // si la operación es PUSH, leo el valor x a insertar en la pila
                  int x = in.nextInt();
                  while (x < -10000 || x > 10000) {
                      x = in.nextInt();
                  }
                  tope = push(pila, tope, x, pilaMaximos);
                  break;
              case "pop":
                  tope = pop(tope);
                  break;
              case "max":
                  max(pilaMaximos, tope);
                  break;
             
          }
        }

    
        in.close();
    }
    public static int push(int[] pila, int tope, int x, int[] pilaMaximos) {
        int nuevoTope = tope + 1;
        pila[nuevoTope] = x;
     if (tope == -1){
            pilaMaximos[nuevoTope] = x;
        } else {
            pilaMaximos[nuevoTope] = Math.max(x, pilaMaximos[tope]);
        }

        return nuevoTope;

    }
    public static int pop(int tope) {
        return tope - 1;
    }

    public static void max(int[] pilamaximos, int tope) {
        System.out.println(pilamaximos[tope]);
    }
}
