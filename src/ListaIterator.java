public class ListaIterator {
     private Nodo actual;

    public ListaIterator(Lista lista) {
        actual = lista.primero;
    }

    public Object siguiente() {
        if (actual == null) {
            return null;
        }

        Object dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}
