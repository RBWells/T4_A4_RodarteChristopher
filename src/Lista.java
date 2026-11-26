public class Lista {
    Nodo primero;

    public Lista() {
        primero = null;
    }

    public boolean listaVacia() {
        return primero == null;
    }

    public void insertarCabezaLista(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = primero;
        primero = nuevo;
    }

    public Object buscarLista(Object dato) {
        Nodo actual = primero;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }

        return null;
    }
     public boolean eliminar(Object dato) {
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                if (anterior == null) {
                    primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    public void visualizar() {
        Nodo actual = primero;

        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
    }
}
