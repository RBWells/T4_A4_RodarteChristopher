
import java.util.Scanner;

public class TestGrafos {

    public static void main(String[] args) throws Exception {
        Scanner nrg = new Scanner(System.in);
        int capacidad = 20;
        int tipo;

        GrafoMatriz matriz = new GrafoMatriz(capacidad);
        GrafoAdcia listas = new GrafoAdcia(capacidad);


        do {
            System.out.println("=== IMPLEMENTACION TDA GRAFOS ===");
            System.out.println("1. Matriz de adyacencia");
            System.out.println("2. Listas de adyacencia");
            System.out.println("0. Salir...");
            tipo = nrg.nextInt();
            nrg.nextLine();

            switch (tipo) {
                case 1:
                    int opcion;
                    do {

                        System.out.println("========== MENU GRAFOS ==========");
                        System.out.println("1. Agregar vertice");
                        System.out.println("2. Agregar arco");
                        System.out.println("3. Borrar arco");
                        System.out.println("4. Consultar adyacencia");
                        System.out.println("5. Borrar vertice");
                        System.out.println("6. Mostrar grafo");
                        System.out.println("7. Recorrido en anchura");
                        System.out.println("8. Recorrido en profundidad");
                        System.out.println("0. Salir");
                        System.out.print("Selecciona una opcion: ");
                        opcion = nrg.nextInt();
                        nrg.nextLine();

                        switch (opcion) {
                            case 1:
                                System.out.print("Nombre del vertice: ");
                                String nombre = nrg.nextLine();

                            
                                    matriz.nuevoVertice(nombre);
                            

                                System.out.println("Vertice agregado.");
                                break;

                            case 2:
                                System.out.print("Vertice origen: ");
                               String origen = nrg.nextLine();

                                System.out.print("Vertice destino: ");
                                String destino = nrg.nextLine();

                                    matriz.nuevoArco(origen, destino);

                                System.out.println("Arco agregado.");
                                break;

                            case 3:
                                System.out.print("Vertice origen: ");
                                origen = nrg.nextLine();

                                System.out.print("Vertice destino: ");
                                destino = nrg.nextLine();

                                    matriz.borrarArco(origen, destino);
                

                                System.out.println("Arco eliminado.");
                                break;

                            case 4:
                                System.out.print("Primer vertice: ");
                                origen = nrg.nextLine();

                                System.out.print("Segundo vertice: ");
                                destino = nrg.nextLine();

                                   boolean existe = matriz.adyacente(origen, destino);

                                if (existe) {
                                    System.out.println("Si existe un arco entre ellos.");
                                } else {
                                    System.out.println("No existe un arco entre ellos.");
                                }
                                break;

                            case 5:
                                System.out.print("Vertice que se eliminara: ");
                                nombre = nrg.nextLine();

                       
                                    matriz.borrarVertice(nombre);
                               

                                System.out.println("Vertice eliminado.");
                                break;

                            case 6:
                            
                                    matriz.mostrarGrafo();
                               
                                break;

                            case 7:
                                System.out.print("Vertice de inicio: ");
                                nombre = nrg.nextLine();

        
                                    RecorreGrafo.recorrerAnchura(matriz, nombre);
                        
                                break;

                            case 8:
                                System.out.print("Vertice de inicio: ");
                                nombre = nrg.nextLine();

                                    RecorreGrafo.recorrerProf(matriz, nombre);
                        
                                break;

                            case 0:
                                System.out.println("Saliste....");
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                        }

                    } while (opcion != 0);
                    break;
                
                case 2:
                       int opcionl;
                    do {

                        System.out.println("========== MENU GRAFOS ==========");
                        System.out.println("1. Agregar vertice");
                        System.out.println("2. Agregar arco");
                        System.out.println("3. Borrar arco");
                        System.out.println("4. Consultar adyacencia");
                        System.out.println("5. Borrar vertice");
                        System.out.println("6. Mostrar grafo");
                        System.out.println("7. Recorrido en anchura");
                        System.out.println("8. Recorrido en profundidad");
                        System.out.println("0. Salir");
                        System.out.print("Selecciona una opcion: ");
                        opcionl = nrg.nextInt();
                        nrg.nextLine();

                        switch (opcionl) {
                            case 1:
                                System.out.print("Nombre del vertice: ");
                                String nombre = nrg.nextLine();

                            
                                    listas.nuevoVertice(nombre);
                            

                                System.out.println("Vertice agregado.");
                                break;

                            case 2:
                                System.out.print("Vertice origen: ");
                               String origen = nrg.nextLine();

                                System.out.print("Vertice destino: ");
                                String destino = nrg.nextLine();

                                    listas.nuevoArco(origen, destino);

                                System.out.println("Arco agregado.");
                                break;

                            case 3:
                                System.out.print("Vertice origen: ");
                                origen = nrg.nextLine();

                                System.out.print("Vertice destino: ");
                                destino = nrg.nextLine();

                                    listas.borrarArco(origen, destino);
                

                                System.out.println("Arco eliminado.");
                                break;

                            case 4:
                                System.out.print("Primer vertice: ");
                                origen = nrg.nextLine();

                                System.out.print("Segundo vertice: ");
                                destino = nrg.nextLine();

                                   boolean existe = listas.adyacente(origen, destino);

                                if (existe) {
                                    System.out.println("Si existe un arco entre ellos.");
                                } else {
                                    System.out.println("No existe un arco entre ellos.");
                                }
                                break;

                            case 5:
                                System.out.print("Vertice que se eliminara: ");
                                nombre = nrg.nextLine();

    
                                    listas.borrarVertice(nombre);

                                System.out.println("Vertice eliminado.");
                                break;

                            case 6:
                                    listas.mostrarGrafo();
                            
                                break;

                            case 7:
                                System.out.print("Vertice de inicio: ");
                                nombre = nrg.nextLine();

        
                                    RecorreGrafo.recorrerAnchura(listas, nombre);
                        
                                break;

                            case 8:
                                System.out.print("Vertice de inicio: ");
                                nombre = nrg.nextLine();

                                    RecorreGrafo.recorrerProf(listas, nombre);
                        
                                break;

                            case 0:
                                System.out.println("Saliste....");
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                        }

                    } while (opcionl != 0);
                    break;
                default:
                    break;
            }

        } while (tipo != 0);
        nrg.close();
    }
}
