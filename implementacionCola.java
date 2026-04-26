import java.util.*;
public class implementacionCola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) return;
        
        int N = input.nextInt();
        
        // Creamos la cola con el máximo permitido por el TAD (100.000)
        // No usamos N porque N son operaciones, no capacidad.
        Cola c = new Cola(100000); 
        
        leerOperaciones(input, N, c);
    }

    public static void leerOperaciones(Scanner input, int N, Cola c) {
        for (int i = 0; i < N; i++) {
            if (!input.hasNext()) break;
            String operacion = input.next().toUpperCase();
            
            switch (operacion) {
                case "PUSH":
                    c.push(input.next());
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

class Cola {
    private String[] elementos;
    private int frente;
    private int fin;
    private int cantidad;
    private int capacidad;

    public Cola(int N) {
        this.capacidad = N;
        this.elementos = new String[N];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

    public void push(String s) {
        // Lógica circular: (fin + 1) % capacidad
        fin = (fin + 1) % capacidad;
        elementos[fin] = s;
        cantidad++;
    }

    public void pop() {
        // Lógica circular: (frente + 1) % capacidad
        frente = (frente + 1) % capacidad;
        cantidad--;
    }

    public String top() {
        return elementos[frente];
    }

    public boolean empty() {
        return cantidad == 0;
    }

    public int size() {
        return cantidad;
    }
}