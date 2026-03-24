import java.util.Scanner; // importo el escanner para poder usarlo

public class parentesis  {
    public static void main(String[] args) {
        int tope = -1; // declaro e inicializo el tope en -1 para indicar que la pila está vacía
        Scanner in = new Scanner(System.in); // declaro el escaner para leer la entrada del usuario
        String cadena = in.next();  // leo la cadena de paréntesis que el usuario ingresa
        
        char[] simbolos = new char[cadena.length()];  //creo el arreglo con la longitud de la cadena para usarlo como pila
        for (int i = 0; i < cadena.length(); i++) { //recorro la cadena caracter por caracter
            char actual = cadena.charAt(i);  // obtengo el caracter actual de la cadena para procesarlo

            if (actual == '(' || actual == '[' || actual == '{') { // si el caracter es un paréntesis de apertura, 
                 tope = PUSH(simbolos, tope, actual);//  lo agrego a la pila usando el método PUSH y actualizo el tope

            } 
                
                 else {
               
            if (tope == -1) {
                System.out.println("No");
                return; 
             }     
            

        char ultimoAbierto = simbolos[tope]; // obtengo el último paréntesis de apertura que se agregó a 
        // la pila para compararlo con el actual

            if (sonPareja(ultimoAbierto, actual)) { // si el último paréntesis de apertura y 
                                    // el actual forman una pareja, entonces los elimino de la pila usando el método POP y actualizo el tope
                tope = POP(tope); 
            } else { // si no imprimo "No" y termino el programa porque la cadena no es válida
                     System.out.println("No"); 
                    return;
        }
         }
        if (tope == -1) { // si al final del proceso el tope es -1, 
        // significa que todos los paréntesis se emparejaron correctamente y la pila quedó vacía, por lo tanto imprimo "Si"
            System.out.println("Si");
        } else { // si el tope no es -1, significa que quedaron paréntesis de apertura sin emparejar, por lo tanto imprimo "No"
            System.out.println("No");
        }
    }
    }

// 1. Método para comparar si los paréntesis coinciden
    public static boolean sonPareja(char apertura, char cierre) {
        if (apertura == '(' && cierre == ')') return true;
        if (apertura == '[' && cierre == ']') return true;
        if (apertura == '{' && cierre == '}') return true;
        return false;
    }

    // 2. Método PUSH para agregar un elemento a la pila, incrementamos el tope y colocamos el nuevo elemento en esa posición
    public static int PUSH(char[] simbolos, int tope, char actual) {
        tope++; 
        simbolos[tope] = actual; 
        return tope; 
    }

    // 3. Método POP para eliminar el último elemento agregado a la pila, simplemente decrementamos el tope
    public static int POP(int tope) {
        return tope - 1;
    }



}