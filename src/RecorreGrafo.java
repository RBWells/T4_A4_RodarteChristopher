public class RecorreGrafo { 
     static final int CLAVE = -1;

    // RECORRIDO EN ANCHURA: MATRIZ DE ADYACENCIA    
    public static int[] recorrerAnchura(
            GrafoMatriz g, String org) throws Exception {

        int w, v;
        int[] m;

        v = g.numVertice(org);

        if (v < 0) {
            throw new Exception("Vertice origen no existe.");
        }

        ColaLista cola = new ColaLista();

        m = new int[g.numeroDeVertices()];

        for (int i = 0; i < g.numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }

        m[v] = 0;
        cola.insertar(Integer.valueOf(v));

        System.out.println("\nRECORRIDO EN ANCHURA:");

        while (!cola.colaVacia()) {
            Integer cw = (Integer) cola.quitar();
            w = cw.intValue();

            System.out.print(g.verts[w].nombre + " ");

            for (int u = 0; u < g.numeroDeVertices(); u++) {
                if (g.matAd[w][u] == 1 && m[u] == CLAVE) {
                    m[u] = m[w] + 1;
                    cola.insertar(Integer.valueOf(u));
                }
            }
        }

        System.out.println();
        return m;
    }

    // RECORRIDO EN PROFUNDIDAD: LISTAS DE ADYACENCIA
    public static int[] recorrerProf(
            GrafoAdcia g, String org) throws Exception {

        int v, w;
        int[] m;

        PilaLista pila = new PilaLista();

        m = new int[g.numeroDeVertices()];

        v = g.numVertice(org);

        if (v < 0) {
            throw new Exception("Vertice origen no existe.");
        }

        for (int i = 0; i < g.numeroDeVertices(); i++) {
            m[i] = CLAVE;
        }

        m[v] = 0;
        pila.insertar(Integer.valueOf(v));

        System.out.println("\nRECORRIDO EN PROFUNDIDAD:");

        while (!pila.pilaVacia()) {
            Integer cw = (Integer) pila.quitar();
            w = cw.intValue();

            System.out.print(g.tablAdc[w].nombre + " ");

            ListaIterator list =new ListaIterator(g.tablAdc[w].lad);

            Arco ck;

            while ((ck = (Arco) list.siguiente()) != null) {
                int k = ck.getDestino();

                if (m[k] == CLAVE) {
                    pila.insertar(Integer.valueOf(k));
                    m[k] = 1;
                }
            }
        }

        System.out.println();
        return m;
    }

    // RECORRIDO EN PROFUNDIDAD: MATRIZ
    public static int[] recorrerProf(
            GrafoMatriz g, String org) throws Exception {

        int v, w;
        int[] m;
        PilaLista pila = new PilaLista();

        v = g.numVertice(org);

        if (v < 0) {
            throw new Exception("Vertice origen no existe.");
        }

        m = new int[g.numeroDeVertices()];

        for (int i = 0; i < m.length; i++) {
            m[i] = CLAVE;
        }

        m[v] = 0;
        pila.insertar(Integer.valueOf(v));

        System.out.println("\nRECORRIDO EN PROFUNDIDAD:");

        while (!pila.pilaVacia()) {
            Integer cw = (Integer) pila.quitar();
            w = cw.intValue();

            System.out.print(g.verts[w].nombre + " ");

            for (int k = 0; k < g.numeroDeVertices(); k++) {
                if (g.matAd[w][k] == 1 && m[k] == CLAVE) {
                    pila.insertar(Integer.valueOf(k));
                    m[k] = 1;
                }
            }
        }

        System.out.println();
        return m;
    }

    // RECORRIDO EN ANCHURA: LISTAS DE ADYACENCIA
    public static int[] recorrerAnchura(
            GrafoAdcia g, String org) throws Exception {

        int v, w;
        int[] m;
        ColaLista cola = new ColaLista();

        v = g.numVertice(org);

        if (v < 0) {
            throw new Exception("Vertice origen no existe.");
        }

        m = new int[g.numeroDeVertices()];

        for (int i = 0; i < m.length; i++) {
            m[i] = CLAVE;
        }

        m[v] = 0;
        cola.insertar(Integer.valueOf(v));

        System.out.println("\nRECORRIDO EN ANCHURA:");

        while (!cola.colaVacia()) {
            Integer cw = (Integer) cola.quitar();
            w = cw.intValue();

            System.out.print(g.tablAdc[w].nombre + " ");

            ListaIterator it =
                new ListaIterator(g.tablAdc[w].lad);

            Arco a;

            while ((a = (Arco) it.siguiente()) != null) {
                int k = a.getDestino();

                if (m[k] == CLAVE) {
                    m[k] = m[w] + 1;
                    cola.insertar(Integer.valueOf(k));
                }
            }
        }

        System.out.println();
        return m;
    }

}
