

import java.util.Scanner;
// importo el escanner para leer la entrada del usuario

public class ImplementacionPila{
    public static void main(String[] args) {
         int tope = -1;
                                 // declaro e inicializo el tope para controlar cuantos elementos hay en la pila, el tope inicia en -1 porque la pila esta vacia
        Scanner input = new Scanner(System.in); //creo el escanner para leer por teclado
        int n = input.nextInt(); //leo el numero de operaciones a procesar
        while ((n < 1) || (n > 100000)) { //verifico las restricciones para n
            n = input.nextInt(); // leo de nuevo N en el caso de que no cumpla las restricciones
        }
        int[] pila = new int[n]; //creo la pila como un arreglo de enteros con tamaño n
        for (int i = 0; i < n; i++) {
            tope = leerOpciones(pila, tope, input);  // llamo al metodo leer operaciones. Basicamente un menu
        
        }
        input.close(); // cierro el escanner para evitar fugas de memoria
    }
        
       

        




    public static int  leerOpciones(int[] pila, int tope, Scanner input) { //paso por parametros el ecanner, la pila y el tope para poder modificarlo dentro del metodo
        
        String opcion = input.next(); //otra vez el escanner para leer la opcion del usuario
        switch (opcion){ // switch para elegir la opcion que el usuario ingreso (tambien puede ser IF-ELSE anidados)
                case "EMPTY":
                    if (EMPTY(pila, tope)) { // si la pila esta vacia devuelvo 0, sino devuelvo 1
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "PUSH": // si es PUSH, llamo al metodo correspondiente y actualizo el tope con el valor que me devuelve el metodo
                       tope = PUSH(pila, tope, input);
                    break;
                case "POP": // si es POP, llamo al metodo correspondiente y actualizo el tope con el valor que me devuelve el metodo
                    tope = POP(pila, tope); 
                    
                    break;
                case "TOP": // si es TOP, llamo al metodo correspondiente para imprimir el ultimo elemento agregado a la pila
                    TOP(pila, tope);
                    break;
                case "SIZE": // si es SIZE, llamo al metodo correspondiente para imprimir el tamaño de la pila
                    SIZE(pila, tope);
                    break;
        }
        return tope;
    }
    public static int PUSH(int[] pila, int tope, Scanner input) {
      
        int x = input.nextInt(); //leo el numero que el usuario quiere agregar a la pila

        while ((x < -1000) || (x > 1000)) { //verifico las restricciones para x
            x = input.nextInt(); //leo de vuelta si el numero no cumple las restricciones
        }
        tope++; // incremento el tope en 1
        pila[tope] = x; // agrego el numero a la pila en la posicion del tope
        return tope; // devuelvo el tope 


    }
    public static int  POP (int[] pila, int tope) { // muevo el tope hacia abajo para eliminar el ultimo elemento agregado a la pila
                                                    //, no es necesario eliminar el valor del arreglo porque el tope controla cuantos 
                                                    // elementos hay en la pila    
        return tope -1;

    }
    public static void TOP (int[] pila, int tope) {
        System.out.println(pila[tope]); // el ultimo elemento agregado a la pila es el que esta en la posicion del tope
       

    }
    public static void  SIZE (int[] pila, int tope) {
        System.out.println(tope + 1); // el tamaño de la pila es el tope + 1, porque el tope inicia en -1

    }
    
    public static boolean EMPTY (int[] pila, int tope) { // si el tope es -1, significa que la pila esta vacia
                                                         //, porque no hay elementos agregados
        return (tope == -1);

    }
}
