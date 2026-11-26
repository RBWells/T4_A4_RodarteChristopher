public class GrafoAdcia {//GRAFO CON LISTAS DE ADYACENCIA
      int numVerts;
    static int maxVerts = 20;
    VerticeAdy[] tablAdc;

    public GrafoAdcia(int max) {
        maxVerts = max;
        numVerts = 0;
        tablAdc = new VerticeAdy[max];
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public int numVertice(String nombre) {
        for (int i = 0; i < numVerts; i++) {
            if (tablAdc[i].nombre.equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevoVertice(String nombre) throws Exception {
        if (numVertice(nombre) != -1) {
            throw new Exception("El vertice ya existe.");
        }

        if (numVerts >= maxVerts) {
            throw new Exception("Se alcanzo la capacidad maxima.");
        }

        tablAdc[numVerts] = new VerticeAdy(nombre);
        tablAdc[numVerts].numVertice = numVerts;
        numVerts++;
    }

    public boolean adyacente(int origen, int destino) {
        Arco buscado = new Arco(destino);
        return tablAdc[origen].lad.buscarLista(buscado) != null;
    }

    public boolean adyacente(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        return adyacente(v, w);
    }

    public void nuevoArco(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        if (!adyacente(v, w)) {
            tablAdc[v].lad.insertarCabezaLista(new Arco(w));
        }
    }

    public void borrarArco(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        tablAdc[v].lad.eliminar(new Arco(w));
    }

    public void borrarVertice(String nombre) throws Exception {
        int v = numVertice(nombre);

        if (v == -1) {
            throw new Exception("El vertice no existe.");
        }

        // Eliminar la lista de adyacencia del vertice
        tablAdc[v].lad = new Lista();

        // Eliminar arcos que apuntan al vertice
        for (int i = 0; i < numVerts; i++) {
            tablAdc[i].lad.eliminar(new Arco(v));
        }

        // Desplazar la tabla de vertices
        for (int i = v; i < numVerts - 1; i++) {
            tablAdc[i] = tablAdc[i + 1];
            tablAdc[i].numVertice = i;
        }

        tablAdc[numVerts - 1] = null;
        numVerts--;

        // Ajustar los destinos de los arcos que estaban
        // despues del vertice eliminado
        for (int i = 0; i < numVerts; i++) {
            Lista nueva = new Lista();
            ListaIterator it = new ListaIterator(tablAdc[i].lad);

            Object dato;

            while ((dato = it.siguiente()) != null) {
                Arco a = (Arco) dato;

                if (a.destino > v) {
                    nueva.insertarCabezaLista(
                        new Arco(a.destino - 1, a.peso)
                    );
                } else {
                    nueva.insertarCabezaLista(
                        new Arco(a.destino, a.peso)
                    );
                }
            }

            tablAdc[i].lad = nueva;
        }
    }

    public void mostrarGrafo() {
        System.out.println("\nLISTAS DE ADYACENCIA:");

        for (int i = 0; i < numVerts; i++) {
            System.out.print(tablAdc[i].nombre + " -> ");

            ListaIterator it =new ListaIterator(tablAdc[i].lad);

            Object dato;

            while ((dato = it.siguiente()) != null) {
                Arco a = (Arco) dato;
                System.out.print(
                    tablAdc[a.destino].nombre + " "
                );
            }

            System.out.println();
        }
    }
}
