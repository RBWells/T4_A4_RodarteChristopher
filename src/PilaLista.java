public class PilaLista { //Pila enlazada
    private Nodo cima;

    public PilaLista() {
        cima = null;
    }

    public boolean pilaVacia() {
        return cima == null;
    }

    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Object quitar() {
        if (pilaVacia()) {
            return null;
        }

        Object dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }
}
