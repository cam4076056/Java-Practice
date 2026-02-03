/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * Clase arbol
 * Implementa un Árbol Binario de Búsqueda (ABB) con operaciones básicas:
 * insertar, eliminar, buscar y recorridos (preorden, inorden y posorden).
 *
 * @author Sala_04
 */
public class arbol {

    /**
     * Clase interna Nodo
     * Representa un nodo del árbol binario.
     * Contiene un valor entero y referencias a los hijos izquierdo y derecho.
     */
    class Nodo {
        int info;      // Valor almacenado en el nodo
        Nodo izq;      // Referencia al hijo izquierdo
        Nodo der;      // Referencia al hijo derecho
    }

    /**
     * Raíz del árbol binario.
     */
    static Nodo raiz;

    /**
     * Constructor de la clase arbol.
     * Inicializa la raíz como nula.
     */
    public arbol() {
        raiz = null;
    }

    /**
     * Inserta un valor entero en el árbol binario de búsqueda.
     *
     * @param x Valor a insertar en el árbol
     */
    public void insertar(int x) {
        if (raiz == null) {
            raiz.info = x;
            raiz.izq = null;
            raiz.der = null;
        } else {
            Nodo reco = raiz;
            while (reco.izq != null || reco.der != null) {
                if (x < reco.info) {
                    reco = reco.izq;
                } else if (x > reco.info) {
                    reco = reco.der;
                }
            }
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.izq = null;
            nuevo.der = null;
            if (x > reco.info) {
                reco.der = nuevo;
            } else if (x < reco.info) {
                reco.izq = nuevo;
            }
        }
    }

    /**
     * Elimina un valor del árbol binario de búsqueda.
     * Considera los distintos casos de eliminación:
     * nodo hoja, nodo con un hijo y nodo con dos hijos.
     *
     * @param x Valor a eliminar
     */
    public void eliminar(int x) {
        Nodo reco = raiz;
        while ((reco.izq.info != x && reco.der.info != x) && (reco.izq != null || reco.der != null)) {
            if (x < reco.info) {
                reco = reco.izq;
            } else if (x > reco.info) {
                reco = reco.der;
            }
        }
        if (raiz.izq == null && raiz.der == null && raiz.info == x) {
            raiz = null;
        } else if (reco.izq.info == x) {
            Nodo p = reco.izq;
            if (p.izq == null && p.der == null) {
                reco.izq = null;
            } else if (p.izq != null && p.der == null) {
                if (p.izq.izq == null && p.izq.der == null) {
                    reco.izq = p.izq;
                } else if (p.izq.der != null) {
                    Nodo t = p.izq;
                    while (t.der.der != null) {
                        t = t.der;
                    }
                    int i = t.der.info;
                    t.der = null;
                    p.info = i;
                } else {
                    Nodo t = p.izq;
                    boolean r = false;
                    while (r == false && t.izq.izq != null) {
                        t = t.izq;
                        if (t.izq.der != null) {
                            Nodo u = t.izq;
                            while (u.der.der != null) {
                                u = u.der;
                            }
                            int i = u.der.info;
                            u.der = null;
                            p.info = i;
                            r = true;
                        }
                    }
                    if (r == false) {
                        p.izq = t.izq;
                    }
                }
            }
        } else if (reco.der.info == x) {
            Nodo p = reco.der;
            if (p.izq == null && p.der == null) {
                reco.der = null;
            }
        } else {
            System.out.println("\nNo se encontró el valor\n");
        }
    }

    /**
     * Recorre el árbol en preorden.
     *
     * @param n Nodo actual del recorrido
     */
    public void preorden(Nodo n) {
        if (n != null) {
            System.out.println(n.info + " ");
            preorden(n.izq);
            preorden(n.der);
        }
    }

    /**
     * Recorre el árbol en inorden.
     *
     * @param n Nodo actual del recorrido
     */
    public void inorden(Nodo n) {
        if (n != null) {
            inorden(n.izq);
            System.out.println(n.info + " ");
            inorden(n.der);
        }
    }

    /**
     * Recorre el árbol en posorden.
     *
     * @param n Nodo actual del recorrido
     */
    public void posorden(Nodo n) {
        if (n != null) {
            posorden(n.izq);
            posorden(n.der);
            System.out.println(n.info + " ");
        }
    }

    /**
     * Busca un valor dentro del árbol.
     *
     * @param x Valor a buscar
     */
    public void buscar(int x) {
        Nodo reco = raiz;
        while ((reco.izq.info != x && reco.der.info != x) && (reco.izq != null || reco.der != null)) {
            if (x < reco.info) {
                reco = reco.izq;
            } else if (x > reco.info) {
                reco = reco.der;
            }
        }
        if (reco.izq.info == x || reco.der.info == x) {
            System.out.println("\nValor encontrado\n");
        } else {
            System.out.println("\nValor no encontrado\n");
        }
    }

    /**
     * Método principal.
     * Inicia la ejecución del programa.
     */
    public static void main(String args[]) {
        arbol a = new arbol();
        a.start();
    }

    /**
     * Muestra el menú de opciones y controla la interacción con el usuario.
     */
    public void start() {
        boolean exception;
        boolean ok;
        int continuar = 1;
        while (continuar == 1) {
            int opcion = 0;
            exception = false;
            ok = false;
            System.out.println("\n1.Insertar\n");
            System.out.println("\n2.Eliminar\n");
            System.out.println("\n3.Buscar\n");
            System.out.println("\n4.Salir\n");
            Scanner sc = new Scanner(System.in);
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\nOpción no válida\n");
                exception = true;
            } finally {
                if (exception == false) {
                    ok = true;
                }
            }
            if (ok = true) {
                if (opcion < 1 || opcion > 4) {
                    System.out.println("\nOpción no válida, intente nuevamente\n");
                } else if (opcion == 1) {
                    System.out.println("\nInserte el número\n");
                    Scanner a = new Scanner(System.in);
                    int num = a.nextInt();
                    insertar(num);
                    imprimir();
                } else if (opcion == 2) {
                    System.out.println("\nInserte el número\n");
                    Scanner a = new Scanner(System.in);
                    int num = a.nextInt();
                    eliminar(num);
                    imprimir();
                } else if (opcion == 3) {
                    System.out.println("\nInserte el número\n");
                    Scanner a = new Scanner(System.in);
                    int num = a.nextInt();
                    buscar(num);
                    imprimir();
                } else {
                    continuar = 2;
                }
            }
        }
    }

    /**
     * Imprime los recorridos del árbol:
     * preorden, inorden y posorden.
     */
    public void imprimir() {
        System.out.println("\nPreorden\n");
        preorden(raiz);
        System.out.println("\nInorden\n");
        inorden(raiz);
        System.out.println("\nPosorden\n");
        posorden(raiz);
    }
}
