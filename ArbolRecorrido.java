import java.util.*;
/*
Dado un árbol con N nodos cuya raíz es el nodo 1, informe las 4 posibles secuencias de nodos que se
 obtienen al realizar los recorridos: preorden, inorden, postorden y por niveles.

Los hijos de un dado nodo se ordenan de izquierda a derecha por orden numérico creciente. 
Por ejemplo, si el nodo 5 tiene como hijos a los nodos 3, 6 y 7, el 3 será el de más a la
 izquierda, el 6 el del centro y el 7 el de la derecha.

Input
En la primera línea recibirá el número de nodos N.

En la segunda línea recibirá N - 1 números enteros separados por espacio:
 (p2, p3,..., pN). El primer número (p2) indica quién es el padre del nodo 2
 , el segundo (p3) indica quién es el padre del nodo 3 y así sucesivamente.
  Obviamente, en este listado no se informa el padre del nodo 1 ya que no tiene por ser la raíz del árbol.

Restricciones:

N: 2 ≤ N ≤ 105
pi: 1 ≤ pi ≤ N
Está garantizado que las conexiones forman un árbol con raíz en el nodo 1.
Output
Imprima 4 líneas de números enteros separados por espacios:

El listado de nodos de acuerdo al orden que se los visita en el recorrido preorden.
El listado de nodos de acuerdo al orden que se los visita en el recorrido inorden.
El listado de nodos de acuerdo al orden que se los visita en el recorrido postorden.
El listado de nodos de acuerdo al orden que se los visita en el recorrido por niveles.

*/

public class ArbolRecorrido {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Arbol arbol = new Arbol(N);
        leerPadres(arbol, N, input);
        arbol.ordenarHijos();

        // Ejecutar los recorridos empezando desde la raíz (nodo 1)
        ArrayList<Integer> listaPre = new ArrayList<>();
        ArrayList<Integer> listaIn = new ArrayList<>();
        ArrayList<Integer> listaPost = new ArrayList<>();
        ArrayList<Integer> listaNiveles = new ArrayList<>();
        arbol.preOrden(1, listaPre);
        arbol.inOrden(1, listaIn);
        arbol.postorden(1, listaPost);
        arbol.porNiveles(1, listaNiveles);

// Imprimir los resultados en consola
        imprimirLista(listaPre);
        imprimirLista(listaIn);
        imprimirLista(listaPost);
        imprimirLista(listaNiveles);;
    }
    public static void leerPadres(Arbol arbol, int N, Scanner input){
        for(int i=2; i<=N; i++){
            int padre = input.nextInt();
            arbol.agregarPadre(i, padre);
        }
    }
    public static void imprimirLista(ArrayList<Integer> lista){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lista.size(); i++){
            sb.append(lista.get(i)).append(" ");
        }
        System.out.println(sb.toString().trim()); // .trim() saca el espacio del final
}


}

class Arbol{ 
    private ArrayList<Integer>[] hijos;
    private int N;
    public Arbol(int N){
        this.N = N;
        hijos = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            hijos[i] = new ArrayList<Integer>();
        }
    }

    public void agregarPadre (int hijo, int padre){
        this.hijos[padre].add(hijo);
        
    }
    public void ordenarHijos(){
        for(int i=0; i<=N; i++){
            Collections.sort(this.hijos[i]);
        }
    }
    public void preOrden(int nodo, ArrayList<Integer> lista){
        lista.add(nodo);
        for (int hijo : hijos[nodo]) {
            preOrden(hijo, lista); // Llamada recursiva
        }
        
        
    }
    public void inOrden(int nodo, ArrayList<Integer> lista){
        if (hijos[nodo].size() > 0) {
            inOrden(hijos[nodo].get(0), lista); // Visitar el primer hijo

        }
        lista.add(nodo); //procesar la raiz después de visitar el primer hijo
        for (int hijo : hijos[nodo]) {
            if (hijo != hijos[nodo].get(0)) { // Evitar visitar el primer hijo nuevamente
                inOrden(hijo, lista); // Llamada recursiva para los demás hijos
            }
        } 
        
    }
     public void postorden(int nodo, ArrayList<Integer> lista){
        for (int hijo : hijos[nodo]) {
            postorden(hijo, lista); // Llamada recursiva
        }
        lista.add(nodo);
        
    }
     public void porNiveles(int raiz, ArrayList<Integer> lista){
        Queue<Integer> cola = new ArrayDeque<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            int nodoActual = cola.poll();
            lista.add(nodoActual);
            for (int hijo : hijos[nodoActual]) {
                cola.add(hijo); // Agregar los hijos a la cola
            }
        }
        
    }


}
