public class Vertice {
     String nombre;
    int numVertice;

    public Vertice(String nombre) {
        this.nombre = nombre;
        numVertice = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vertice) {
            Vertice v = (Vertice) obj;
            return nombre.equals(v.nombre);
        }
        return false;
    }

    public String toString() {
        return nombre;
    }
}
