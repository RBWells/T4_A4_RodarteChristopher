public class Arco {//Arco para listas de adyacencia
      int destino;
    double peso;

    public Arco(int destino) {
        this.destino = destino;
        peso = 1;
    }

    public Arco(int destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public int getDestino() {
        return destino;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Arco) {
            Arco a = (Arco) obj;
            return destino == a.destino;
        }
        return false;
    }

    public String toString() {
        return String.valueOf(destino);
    }
}
