import java.util.Scanner;




public class negativo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // 1. Lectura de N con validación de restricciones
        if (!in.hasNextInt()) return;
        int N = in.nextInt();
        while (N < 3 || N > 100000) {
            N = in.nextInt();
        }

        // 2. Inicialización de la Pila y el Contador Eficiente
        int[] pila = new int[N];
        int tope = -1;
        int contNegativos = 0; // Contador eficiente de números negativos en la pila

        // 3. Bucle principal de operaciones
        for (int i = 0; i < N; i++) {
            String operacion = in.next();

            if (operacion.equals("PUSH")) {
                int x = in.nextInt();
                // Validación del rango de x (-10000 a 10000)
                while (x < -10000 || x > 10000) {
                    x = in.nextInt();
                }

                // Si entra un negativo, sumamos al contador
                if (x < 0) {
                    contNegativos++;
                }
                tope = PUSH(pila, tope, x);

            } else if (operacion.equals("POP")) {
                // Si el que vamos a sacar es negativo, restamos del contador
                // El enunciado garantiza que la pila no estará vacía en un POP
                if (pila[tope] < 0) {
                    contNegativos--;
                }
                tope = POP(tope);

            } else if (operacion.equals("NEG")) {
                // Operación O(1): respuesta instantánea sin usar un bucle 'for'
                NEG(contNegativos);
            }
        }
        in.close();
    }

    // --- MÉTODOS DEL TAD PILA ---

    public static int PUSH(int[] pila, int tope, int valor) { // El método PUSH ahora recibe el arreglo de la pila para 
    // modificarlo
        tope++;
        pila[tope] = valor;
        return tope;
    }

    public static int POP(int tope) { // El método POP ahora solo necesita el tope para devolver el nuevo tope
        return tope - 1;
    }

    public static void NEG(int cantidad) { // El método NEG ahora recibe el contador de negativos para determinar la respuesta
        if (cantidad > 0) {
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }
}