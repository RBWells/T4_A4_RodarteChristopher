public class GrafoMatriz { // Matriz de ADYACENCIA
    int numVerts;
    static final int CLAVE = 0;
    Vertice[] verts;
    int[][] matAd;

    public GrafoMatriz(int maxVerts) {
        numVerts = 0;
        verts = new Vertice[maxVerts];
        matAd = new int[maxVerts][maxVerts];
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public int numVertice(String nombre) {
        for (int i = 0; i < numVerts; i++) {
            if (verts[i].nombre.equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevoVertice(String nombre) throws Exception {
        if (numVertice(nombre) != -1) {
            throw new Exception("El vertice ya existe.");
        }

        if (numVerts >= verts.length) {
            throw new Exception("Se alcanzo la capacidad maxima.");
        }

        verts[numVerts] = new Vertice(nombre);
        verts[numVerts].numVertice = numVerts;
        numVerts++;
    }

    public void nuevoArco(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        matAd[v][w] = 1;
    }

    public void borrarArco(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        matAd[v][w] = 0;
    }

    public boolean adyacente(String origen, String destino)
            throws Exception {

        int v = numVertice(origen);
        int w = numVertice(destino);

        if (v == -1 || w == -1) {
            throw new Exception("Uno de los vertices no existe.");
        }

        return matAd[v][w] == 1;
    }

    public void borrarVertice(String nombre) throws Exception {
        int v = numVertice(nombre);

        if (v == -1) {
            throw new Exception("El vertice no existe.");
        }

        // Desplazar los vertices posteriores
        for (int i = v; i < numVerts - 1; i++) {
            verts[i] = verts[i + 1];
            verts[i].numVertice = i;
        }

        verts[numVerts - 1] = null;

        // Desplazar filas de la matriz
        for (int i = v; i < numVerts - 1; i++) {
            for (int j = 0; j < numVerts; j++) {
                matAd[i][j] = matAd[i + 1][j];
            }
        }

        // Desplazar columnas de la matriz
        for (int i = 0; i < numVerts - 1; i++) {
            for (int j = v; j < numVerts - 1; j++) {
                matAd[i][j] = matAd[i][j + 1];
            }
        }

        numVerts--;

        // Limpiar ultima fila y columna disponibles
        for (int i = 0; i < verts.length; i++) {
            matAd[numVerts][i] = 0;
            matAd[i][numVerts] = 0;
        }
    }

    public void mostrarGrafo() {
        System.out.println("\nMATRIZ DE ADYACENCIA:");

        System.out.print("    ");
        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%5s", verts[i].nombre);
        }
        System.out.println();

        for (int i = 0; i < numVerts; i++) {
            System.out.printf("%4s", verts[i].nombre);

            for (int j = 0; j < numVerts; j++) {
                System.out.printf("%5d", matAd[i][j]);
            }

            System.out.println();
        }
    }
}
