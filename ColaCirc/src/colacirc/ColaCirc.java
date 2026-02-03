/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colacirc;

import java.util.Scanner;

/**
 * Clase ColaCirc
 * 
 * Implementa una Cola Circular utilizando un arreglo de tamaño fijo.
 * Permite realizar operaciones como:
 * - Adicionar elementos
 * - Eliminar elementos
 * - Buscar elementos
 * - Contar posiciones ocupadas
 * 
 * La cola se maneja mediante dos índices:
 * cab (cabeza) y col (cola).
 * 
 * @author Christian Mendez
 */
public class ColaCirc {

    /**
     * Opción seleccionada por el usuario en el menú.
     */
    int opcion;

    /**
     * Índice de la cabeza de la cola.
     * Inicializado en -1 para indicar cola vacía.
     */
    int cab = -1;

    /**
     * Índice de la cola.
     * Inicializado en -1 para indicar cola vacía.
     */
    int col = -1;

    /**
     * Tamaño máximo de la cola circular.
     */
    int n = 5;

    /**
     * Arreglo que almacena los elementos de la cola.
     */
    int[] f;

    /**
     * Indica si la opción ingresada es válida.
     */
    boolean valido;

    /**
     * Indica si ocurrió una excepción al ingresar datos.
     */
    boolean exception;

    /**
     * Método principal.
     * Inicia la ejecución del programa.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        ColaCirc c = new ColaCirc();
        c.start();
    }

    /**
     * Controla el flujo principal del programa.
     * Muestra el menú y gestiona la interacción con el usuario.
     */
    public void start() {
        int continuar = 1;
        f = new int[n];
        while (continuar == 1) {

            valido = false;
            exception = false;

            System.out.println("\n1.Adicionar\n");
            System.out.println("2.Quitar\n");
            System.out.println("3.Buscar\n");
            System.out.println("4.Contar\n");
            System.out.println("5.Salir\n");

            Scanner sc = new Scanner(System.in);
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\nPor favor ingrese una opción valida\n");
                exception = true;
            } finally {
                if (exception == false) {
                    valido = true;
                }
                if (valido == true) {
                    if (opcion < 1 || opcion > 5) {
                        System.out.println("\nOpción no valida, intente nuevamente\n");
                    } else if (opcion == 1) {
                        adicionar(f, cab, col, n);
                    } else if (opcion == 2) {
                        eliminar(f, cab, col, n);
                    } else if (opcion == 3) {
                        buscar(f, cab, col, n);
                    } else if (opcion == 4) {
                        contar(cab, col, n);
                    } else {
                        continuar = 2;
                    }
                }
            }
        }
    }

    /**
     * Adiciona un elemento a la cola circular.
     * Verifica si la cola está llena antes de insertar.
     * 
     * @param f arreglo de la cola
     * @param ca índice de cabeza
     * @param co índice de cola
     * @param n tamaño máximo de la cola
     */
    public void adicionar(int[] f, int ca, int co, int n) {
        int dato = 0;
        boolean ex = false;
        boolean ok = false;

        // Verifica si la cola está llena
        if ((col + 1) % n == cab) {
            System.out.println("\nCola llena\n");
        } else {
            System.out.println("\nDigite el dato a adicionar\n");
            Scanner sc = new Scanner(System.in);
            try {
                dato = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\nPor favor ingrese un número\n");
                ex = true;
            } finally {
                if (ex == false) {
                    ok = true;
                }
            }

            if (ok == true) {
                co = (co + 1) % n;
                if (ca == -1) {
                    ca++;
                }
                f[co] = dato;
                imprimir(f, ca, co, n);
            }
        }
    }

    /**
     * Elimina un elemento de la cola circular.
     * Maneja los casos de cola vacía, un solo elemento o varios elementos.
     * 
     * @param f arreglo de la cola
     * @param ca índice de cabeza
     * @param co índice de cola
     * @param n tamaño máximo de la cola
     */
    public void eliminar(int[] f, int ca, int co, int n) {
        if (co == -1 && ca == -1) {
            // Cola vacía, no se elimina nada
        } else if (co == ca) {
            System.out.println("\nEl número eliminado es " + f[ca] + "\n");
            co = -1;
            ca = -1;
            imprimir(f, ca, co, n);
        } else {
            System.out.println("\nEl número eliminado es " + f[ca] + "\n");
            ca = (ca + 1) % n;
            imprimir(f, ca, co, n);
        }
    }

    /**
     * Busca un número dentro de la cola circular.
     * Muestra todas las posiciones donde se encuentra el valor.
     * 
     * @param f arreglo de la cola
     * @param ca índice de cabeza
     * @param co índice de cola
     * @param n tamaño máximo de la cola
     */
    public void buscar(int[] f, int ca, int co, int n) {
        int num = 0;
        boolean ok = false;
        boolean ex = false;
        int i;
        int j = 0;
        int encontrados = 0;
        int[] posiciones;
        posiciones = new int[n];

        if (co == -1 && ca == -1) {
            System.out.println("\nCola vacia\n");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nPor favor digite el número a encontrar:\n");
            try {
                num = sc.nextInt();
            } catch (Exception t) {
                System.out.println("\nPor favor ingrese un número\n");
                ex = true;
            } finally {
                if (ex == false) {
                    ok = true;
                }
            }

            if (ok == true) {
                for (i = 0; i <= (n - 1); i++) {
                    if (f[i] == num) {
                        encontrados++;
                        posiciones[j] = i;
                        j++;
                    }
                }

                if (encontrados >= 1) {
                    if (encontrados == 1) {
                        System.out.println("\nSe ha encontrado " + encontrados + " resultado en la posición:");
                    } else {
                        System.out.println("\nSe ha encontrado " + encontrados + " resultados en las posiciones:");
                    }
                    for (i = 0; i < encontrados; i++) {
                        System.out.println("\n" + posiciones[i] + "\n");
                    }
                    imprimir(f, ca, co, n);
                } else {
                    System.out.println("\nNo se encontraron resultados\n");
                    imprimir(f, ca, co, n);
                }
            }
        }
    }

    /**
     * Imprime el contenido actual de la cola circular.
     * Muestra las posiciones y los valores almacenados.
     * 
     * @param f arreglo de la cola
     * @param ca índice de cabeza
     * @param co índice de cola
     * @param n tamaño máximo de la cola
     */
    public void imprimir(int[] f, int ca, int co, int n) {

        int indice = 0;

        if (co == -1 && ca == -1) {
            System.out.println("\nCola Vacia\n");
        } else {
            System.out.println("\nCola:\n");

            if (ca < co) {
                System.out.println("\nPosición:    Valor:\n");
                for (indice = ca; indice <= co; indice++) {
                    System.out.println(indice + "\t\t" + f[indice] + "\n");
                }
            } else if (co < ca) {
                indice = ca;
                System.out.println("\nPosición:    Valor:\n");
                while (indice != co) {
                    System.out.println(indice + "\t\t" + f[indice] + "\n");
                    indice = (indice + 1) % n;
                }
                System.out.println(indice + "\t\t" + f[indice] + "\n");
            } else if (ca == co) {
                System.out.println("\nPosición:    Valor:\n");
                System.out.println(indice + "\t\t" + f[indice] + "\n");
            }
        }

        // Actualiza los valores reales de cabeza y cola
        cab = ca;
        col = co;
    }

    /**
     * Cuenta la cantidad de posiciones ocupadas en la cola circular.
     * 
     * @param ca índice de cabeza
     * @param co índice de cola
     * @param n tamaño máximo de la cola
     */
    void contar(int ca, int co, int n) {
        int ocupados = 0;

        if (co == -1 && ca == -1) {
            ocupados = 0;
        } else if (ca == co) {
            ocupados = 1;
        } else if ((co + 1) % n == ca) {
            ocupados = n;
        } else if (ca < co) {
            ocupados = co - ca + 1;
        } else if (co < ca) {
            ocupados = n - ca + co + 1;
        }

        System.out.println("Posiciones ocupadas: " + ocupados + "\n");
    }
}
