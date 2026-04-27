import java.util.*;

public class colaEspectaculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Cola cola = new Cola(N); // capacidad máxima N (≤100)
        
        // Leer personas y encolarlas
        for (int i = 0; i < N; i++) {
            String nombre = sc.next();
            String apellido = sc.next();
            String entrada = sc.next(); // PLATEA o PALCO
            int minutos = sc.nextInt();
            Persona p = new Persona(nombre, apellido, entrada, minutos);
            cola.push(p);
        }
        
        int tiempoTotal = 0;
        int atendidos = 0;
        
        // Simular atención
        while (!cola.empty()) {
            Persona actual = cola.top();
            if (tiempoTotal + actual.minutos > 120) {
                break;
            }
            tiempoTotal += actual.minutos;
            cola.pop();
            atendidos++;
        }
        
        int noAtendidos = N - atendidos;
        
        if (noAtendidos == 0) {
            System.out.println(0);
        } else {
            System.out.println(noAtendidos + " " + cola.top().nombre);
        }
    }
}

// Clase Persona para guardar datos
class Persona {
    String nombre;
    String apellido;
    String entrada;
    int minutos;
    
    public Persona(String nombre, String apellido, String entrada, int minutos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.entrada = entrada;
        this.minutos = minutos;
    }
}

// Implementación de Cola con objetos Persona
class Cola {
    private Persona[] elementos;
    private int frente;
    private int fin;
    private int cantidad;
    private int capacidad;

    public Cola(int N) {
        this.capacidad = N;
        this.elementos = new Persona[N];
        this.frente = 0;
        this.fin = -1;
        this.cantidad = 0;
    }

    public void push(Persona p) {
        fin = (fin + 1) % capacidad;
        elementos[fin] = p;
        cantidad++;
    }

    public void pop() {
        frente = (frente + 1) % capacidad;
        cantidad--;
    }

    public Persona top() {
        return elementos[frente];
    }

    public boolean empty() {
        return cantidad == 0;
    }

    public int size() {
        return cantidad;
    }
}
