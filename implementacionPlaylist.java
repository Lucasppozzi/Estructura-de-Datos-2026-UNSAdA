import java.util.*;

public class implementacionPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // cantidad de operaciones
        sc.nextLine();

        Playlist lista = new Playlist();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(" ");
            switch (s[0]) {
                case "PUSH_BACK":
                    int idBack = Integer.parseInt(s[1]);
                    String nombreBack = s[2];
                    lista.push_back(idBack, nombreBack);
                    break;
                case "PUSH_FRONT":
                    int idFront = Integer.parseInt(s[1]);
                    String nombreFront = s[2];
                    lista.push_front(idFront, nombreFront);
                    break;
                case "INSERT":
                    int idIns = Integer.parseInt(s[1]);
                    String nombreIns = s[2];
                    lista.insert(idIns, nombreIns);
                    break;
                case "DELETE":
                    int idDel = Integer.parseInt(s[1]);
                    lista.delete(idDel);
                    break;
                case "NEXT":
                    lista.next();
                    break;
                case "PREV":
                    lista.prev();
                    break;
                case "PLAY":
                    lista.play();
                    break;
                case "PRINT_ALL":
                    lista.print_all();
                    break;
            }
        }
    }
}

class Playlist {

    class Nodo {
        int id;
        String nombre;
        Nodo anterior, siguiente;

        public Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            anterior = null;
            siguiente = null;
        }
    }

    private Nodo cabeza, cola;
    private Nodo cursor;

    public Playlist() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    // Agregar al final y posicionarse en esa canción
    public void push_back(int id, String nombre) {
        Nodo nuevo = new Nodo(id, nombre);
        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        cursor = nuevo;
    }

    // Agregar al inicio y posicionarse en esa canción
    public void push_front(int id, String nombre) {
        Nodo nuevo = new Nodo(id, nombre);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        cursor = nuevo;
    }

    // Insertar antes de la canción actual y posicionarse en la nueva
    public void insert(int id, String nombre) {
        if (cursor == null) return;
        Nodo nuevo = new Nodo(id, nombre);
        nuevo.siguiente = cursor;
        nuevo.anterior = cursor.anterior;
        if (cursor.anterior != null) {
            cursor.anterior.siguiente = nuevo;
        } else {
            cabeza = nuevo;
        }
        cursor.anterior = nuevo;
        cursor = nuevo; // posicionarse en la nueva canción
    }

    // Eliminar por Id y posicionarse en la siguiente (o primera si era la última)
    public void delete(int id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.id == id) {
                if (actual == cabeza) cabeza = actual.siguiente;
                if (actual == cola) cola = actual.anterior;
                if (actual.anterior != null) actual.anterior.siguiente = actual.siguiente;
                if (actual.siguiente != null) actual.siguiente.anterior = actual.anterior;

                // mover cursor
                if (actual.siguiente != null) {
                    cursor = actual.siguiente;
                } else {
                    cursor = cabeza; // si era la última, ir al inicio
                }
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Avanzar a la siguiente canción (o volver al inicio si estaba en la última)
    public void next() {
        if (cursor == null) return;
        if (cursor.siguiente != null) {
            cursor = cursor.siguiente;
        } else {
            cursor = cabeza; // volver al inicio
        }
    }

    // Retroceder a la canción anterior (o ir a la última si estaba en la primera)
    public void prev() {
        if (cursor == null) return;
        if (cursor.anterior != null) {
            cursor = cursor.anterior;
        } else {
            cursor = cola; // ir a la última
        }
    }

    // Imprimir nombre de la canción actual
    public void play() {
        if (cursor != null) {
            System.out.println(cursor.nombre);
        }
    }

    // Imprimir toda la lista de canciones
    public void print_all() {
        Nodo actual = cabeza;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.nombre);
            if (actual.siguiente != null) sb.append(" ");
            actual = actual.siguiente;
        }
        System.out.println(sb.toString());
    }
}
