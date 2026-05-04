import java.util.*;

public class implementacionListaEnlazada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // cantidad de operaciones
        sc.nextLine();

        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(" ");
            int x;
            switch (s[0]) {
                case "PUSH_FRONT":
                    x = Integer.parseInt(s[1]);
                    lista.push_front(x); // insertar al inicio
                    break;
                case "PUSH_BACK":
                    x = Integer.parseInt(s[1]);
                    lista.push_back(x); // insertar al final
                    break;
                case "INSERT":
                    x = Integer.parseInt(s[1]);
                    lista.insert(x); // insertar después del cursor
                    break;
                case "POP_FRONT":
                    lista.pop_front(); // eliminar primer elemento
                    break;
                case "POP_BACK":
                    lista.pop_back(); // eliminar último elemento
                    break;
                case "DELETE":
                    x = Integer.parseInt(s[1]);
                    lista.delete(x); // eliminar primer nodo con valor x
                    break;
                case "ERASE":
                    lista.erase(); // eliminar nodo donde está el cursor
                    break;
                case "TOP":
                    lista.top(); // mover cursor al inicio
                    break;
                case "MOVE":
                    lista.move(); // avanzar cursor una posición
                    break;
                case "END":
                    boolean fin = lista.end(); // ¿cursor más allá del final?
                    System.out.println(fin ? 1 : 0);
                    break;
                case "PRINT":
                    lista.print(); // imprimir valor en cursor
                    break;
                case "PRINT_ALL":
                    lista.print_all(); // imprimir toda la lista
                    break;
            }
        }
    }
}

class ListaDobleEnlazada {

    // Clase interna Nodo: cada elemento guarda un dato y referencias
    class Nodo {
        int dato;
        Nodo anterior, siguiente;

        public Nodo(int valor) {
            dato = valor;
            anterior = null;
            siguiente = null;
        }
    }

    private Nodo cabeza, cola; // extremos de la lista
    private Nodo cursor;       // posición actual de navegación

    public ListaDobleEnlazada() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    // Inserta al inicio
    public void push_front(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) { // lista vacía
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
    }

    // Inserta al final
    public void push_back(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cola == null) { // lista vacía
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Inserta después del cursor
    public void insert(int valor) {
        if (cursor == null) return; // si cursor está fuera, no hace nada
        Nodo nuevo = new Nodo(valor);
        nuevo.anterior = cursor;
        nuevo.siguiente = cursor.siguiente;
        if (cursor.siguiente != null) {
            cursor.siguiente.anterior = nuevo;
        } else {
            cola = nuevo; // si cursor estaba en el último nodo
        }
        cursor.siguiente = nuevo;
    }

    // Elimina el último
    public void pop_back() {
        if (cola == null) return;
        cola = cola.anterior;
        if (cola != null) cola.siguiente = null;
        else cabeza = null; // lista quedó vacía
    }

    // Elimina el primero
    public void pop_front() {
        if (cabeza == null) return;
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        else cola = null; // lista quedó vacía
    }

    // Elimina el primer nodo con valor x
    public void delete(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                if (actual == cabeza) cabeza = actual.siguiente;
                if (actual == cola) cola = actual.anterior;
                if (actual.anterior != null) actual.anterior.siguiente = actual.siguiente;
                if (actual.siguiente != null) actual.siguiente.anterior = actual.anterior;
                cursor = actual.siguiente; // cursor pasa al siguiente
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Elimina el nodo donde está el cursor
    public void erase() {
        if (cursor == null) return;
        if (cursor == cola) cola = cursor.anterior;
        if (cursor == cabeza) cabeza = cursor.siguiente;
        if (cursor.anterior != null) cursor.anterior.siguiente = cursor.siguiente;
        if (cursor.siguiente != null) cursor.siguiente.anterior = cursor.anterior;
        cursor = cursor.siguiente; // cursor avanza
    }

    // Mueve cursor al inicio
    public void top() {
        cursor = cabeza;
    }

    // Avanza cursor una posición
    public void move() {
        if (cursor != null) cursor = cursor.siguiente;
    }

    // ¿Cursor más allá del final?
    public boolean end() {
        return cursor == null;
    }

    // Imprime toda la lista
    public void print_all() {
        Nodo actual = cabeza;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(" ");
            actual = actual.siguiente;
        }
        System.out.println(sb.toString());
    }

    // Imprime valor en cursor
    public void print() {
        if (cursor != null) {
            System.out.println(cursor.dato);
        }
    }
}
