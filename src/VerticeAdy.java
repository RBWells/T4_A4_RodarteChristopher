public class VerticeAdy {//Vertice con lista de adyacencia
    String nombre;
    int numVertice;
    Lista lad;

    public VerticeAdy(String nombre) {
        this.nombre = nombre;
        numVertice = -1;
        lad = new Lista();
    }

    public String toString() {
        return nombre;
    }
}
