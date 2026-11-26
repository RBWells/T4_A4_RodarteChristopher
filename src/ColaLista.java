public class ColaLista { //Cola enlazada
   private Nodo frente;
    private Nodo fin;

    public ColaLista() {
        frente = null;
        fin = null;
    }

    public boolean colaVacia() {
        return frente == null;
    }

    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);

        if (colaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Object quitar() {
        if (colaVacia()) {
            return null;
        }

        Object dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }
}
