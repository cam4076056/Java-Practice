/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 * Clase que implementa el algoritmo de Dijkstra
 * para calcular las rutas más cortas desde un nodo
 * origen hacia todos los demás nodos del grafo.
 * 
 * El grafo se representa mediante una matriz de pesos.
 * 
 * @author Sala_03
 */
public class Dijkstra {

    /**
     * Matriz de pesos del grafo.
     * 
     * Cada posición [i][j] representa el costo de ir
     * del nodo i al nodo j.
     * 
     * El valor 999 se utiliza como "infinito",
     * indicando que no existe conexión directa.
     */
    public static int peso[][] = {
        {0, 999, 999, 11, 999, 999, 14, 999, 999, 999},
        {999, 0, 15, 999, 4, 999, 999, 999, 999, 999},
        {999, 15, 0, 6, 999, 999, 999, 999, 999, 999},
        {11, 999, 6, 0, 999, 999, 9, 999, 999, 999},
        {999, 4, 999, 999, 0, 7, 999, 3, 999, 999},
        {999, 999, 999, 999, 7, 0, 999, 2, 999, 999},
        {14, 999, 999, 9, 999, 999, 0, 999, 4, 999},
        {999, 999, 999, 999, 3, 2, 999, 0, 999, 1},
        {999, 999, 999, 999, 999, 999, 4, 999, 0, 3},
        {999, 999, 999, 999, 999, 999, 999, 1, 3, 0}
    };

    /**
     * Arreglo que almacena la distancia mínima
     * desde el nodo origen hacia cada nodo.
     */
    public int distancia[] = new int[10];

    /**
     * Método que ejecuta el algoritmo de Dijkstra.
     * 
     * @param n Número total de nodos del grafo
     * @param s Nodo origen desde el cual se calculan
     *          las distancias mínimas
     */
    public void calc(int n, int s) {

        /**
         * Arreglo de control para marcar nodos visitados.
         * 0 = no visitado
         * 1 = visitado
         */
        int flag[] = new int[n + 1];

        // Variables auxiliares
        int i = 0;
        int k = 0;
        int c = 0;
        int min = 0;
        int minpos = 1;

        /**
         * Inicialización:
         * Se copian los pesos del nodo origen
         * como distancias iniciales.
         */
        for (i = 1; i <= 9; i++) {
            flag[i] = 0;
            this.distancia[i] = Dijkstra.peso[s][i];

            // Contador de nodos procesados
            c = 2;

            /**
             * Bucle principal del algoritmo de Dijkstra
             */
            while (c <= n) {
                min = 99;

                /**
                 * Se busca el nodo con la distancia mínima
                 * que aún no haya sido marcado
                 */
                for (k = 1; k <= n - 1; k++) {
                    if (this.distancia[k] < min && flag[k] != 2) {
                        min = this.distancia[i];
                        minpos = k;
                    }
                }

                // Se marca el nodo con menor distancia
                flag[minpos] = 1;
                c++;

                /**
                 * Se actualizan las distancias de los nodos
                 * adyacentes al nodo seleccionado
                 */
                for (k = 1; k <= n - 1; k++) {
                    if (this.distancia[minpos] + Dijkstra.peso[minpos][k]
                            < this.distancia[k] && flag[k] != 1) {
                        this.distancia[k] =
                                this.distancia[minpos] + Dijkstra.peso[minpos][k];
                    }
                }
            }
        }
    }

    /**
     * Método principal del programa.
     * 
     * Ejecuta el algoritmo de Dijkstra para
     * cada nodo del grafo como nodo origen
     * y muestra los resultados por consola.
     */
    public static void main(String[] args) {

        // Variables auxiliares
        int a;
        int b;
        int c = 1;
        int nodos = 10;

        // Bucles sin contenido (no afectan la ejecución)
        for (a = 0; a < nodos; a++) {

        }
        for (b = 0; b < nodos; b++) {

        }

        // Tamaño de la matriz de pesos
        String tamaño = a + "x" + b;

        int comienzo, i, j;

        // Se crea una instancia de la clase Dijkstra
        Dijkstra d = new Dijkstra();

        /**
         * Se calcula la ruta más corta desde cada nodo
         * hacia todos los demás nodos del grafo
         */
        for (comienzo = 0; comienzo <= 9; comienzo++) {
            d.calc(nodos, comienzo);
            System.out.println(
                "La ruta más corta desde el nodo \t" +
                comienzo + "\t a todos los demás es: \n"
            );

            for (i = 1; i <= nodos - 1; i++) {
                if (i != comienzo) {
                    System.out.println(
                        "Orígen: " + comienzo +
                        "\t Destino: " + i +
                        "\t Costo mínimo: " + d.distancia[i] + "\t"
                    );
                }
            }
        }

        /**
         * Impresión de la matriz de pesos
         */
        System.out.println("\nMatriz de tamaño " + tamaño + ":\n");
        for (i = 0; i <= nodos - 1; i++) {
            for (j = 0; j <= nodos - 1; j++) {
                System.out.print(peso[i][j] + "\t");
            }
            System.out.println("");
        }

        // TODO code application logic here
    }

}
