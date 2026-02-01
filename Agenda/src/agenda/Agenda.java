/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 * Clase Agenda
 * Implementa una lista doblemente enlazada de números enteros.
 * Permite insertar, eliminar, buscar y recorrer los elementos.
 */
public class Agenda {

    /**
     * Clase Nodo
     * Representa un elemento de la lista doblemente enlazada.
     */
    class Nodo {
        int info;       // Dato almacenado
        Nodo sig;       // Referencia al siguiente nodo
        Nodo ant;       // Referencia al nodo anterior
    }

    private Nodo raiz;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor
     * Inicializa la lista vacía.
     */
    public Agenda() {
        raiz = null;
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista.
     * @param x valor entero a insertar
     */
    public void insertar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;

        if (raiz == null) {
            raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz.ant = nuevo;
            raiz = nuevo;
        }
    }

    /**
     * Inserta un nuevo nodo al final de la lista.
     * @param x valor entero a insertar
     */
    public void insertar_final(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;

        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo aux = raiz;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
            nuevo.ant = aux;
        }
    }

    /**
     * Extrae y elimina el primer elemento de la lista.
     * @return valor eliminado o Integer.MAX_VALUE si la lista está vacía
     */
    public int extraer() {
        if (raiz == null) {
            return Integer.MAX_VALUE;
        }

        int valor = raiz.info;
        raiz = raiz.sig;

        if (raiz != null) {
            raiz.ant = null;
        }
        return valor;
    }

    /**
     * Elimina el primer nodo que contenga el valor dado.
     * @param x valor a eliminar
     * @return valor eliminado o Integer.MAX_VALUE si no se encontró
     */
    public int eliminar(int x) {
        Nodo aux = raiz;

        while (aux != null) {
            if (aux.info == x) {
                if (aux == raiz) {
                    raiz = aux.sig;
                    if (raiz != null) {
                        raiz.ant = null;
                    }
                } else {
                    aux.ant.sig = aux.sig;
                    if (aux.sig != null) {
                        aux.sig.ant = aux.ant;
                    }
                }
                return x;
            }
            aux = aux.sig;
        }
        return Integer.MAX_VALUE;
    }

    /**
     * Busca un valor en la lista.
     * @param x valor a buscar
     * @return true si se encuentra, false en caso contrario
     */
    public boolean buscar(int x) {
        Nodo aux = raiz;
        while (aux != null) {
            if (aux.info == x) {
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    /**
     * Cuenta la cantidad de nodos en la lista.
     * @return número de elementos
     */
    public int contar() {
        int c = 0;
        Nodo aux = raiz;
        while (aux != null) {
            c++;
            aux = aux.sig;
        }
        return c;
    }

    /**
     * Muestra todos los elementos de la lista.
     */
    public void mostrar() {
        Nodo aux = raiz;
        while (aux != null) {
            System.out.print(aux.info + " ");
            aux = aux.sig;
        }
        System.out.println();
    }

    /**
     * Muestra el menú principal del programa.
     */
    public void menu() {
        int op;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Extraer");
            System.out.println("4. Eliminar");
            System.out.println("5. Buscar");
            System.out.println("6. Contar");
            System.out.println("7. Mostrar");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese el valor: ");
                    insertar(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Ingrese el valor: ");
                    insertar_final(sc.nextInt());
                    break;

                case 3:
                    int e = extraer();
                    if (e != Integer.MAX_VALUE) {
                        System.out.println("Extraído: " + e);
                    } else {
                        System.out.println("Lista vacía.");
                    }
                    break;

                case 4:
                    System.out.print("Valor a eliminar: ");
                    int x = sc.nextInt();
                    if (eliminar(x) != Integer.MAX_VALUE) {
                        System.out.println("Eliminado.");
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Valor a buscar: ");
                    x = sc.nextInt();
                    System.out.println(buscar(x) ? "Encontrado." : "No encontrado.");
                    break;

                case 6:
                    System.out.println("Cantidad: " + contar());
                    break;

                case 7:
                    mostrar();
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 8);
    }

    /**
     * Método principal
     */
    public static void main(String[] args) {
        Agenda a = new Agenda();
        a.menu();
    }
}
