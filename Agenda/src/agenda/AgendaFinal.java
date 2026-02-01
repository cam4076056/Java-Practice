/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 * Clase principal que implementa una agenda
 * usando una lista doblemente enlazada
 */
public class AgendaFinal {

    /**
     * Nodo de la lista doblemente enlazada
     * Representa una persona
     */
    class Nodo {
        String id;
        String nombre;
        double peso;
        double estatura;
        double imc;
        Nodo sig;
        Nodo ant;
    }

    private Nodo raiz;
    private Scanner sc = new Scanner(System.in);

    /**
     * Inserta una persona al final de la lista
     */
    public void insertarFinal(String id, String nombre, double peso, double estatura) {
        Nodo nuevo = new Nodo();
        nuevo.id = id;
        nuevo.nombre = nombre;
        nuevo.peso = peso;
        nuevo.estatura = estatura;
        nuevo.imc = peso / (estatura * estatura);

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
     * Busca una persona por su ID
     * @return true si se encuentra
     */
    public boolean buscarPorId(String id) {
        Nodo aux = raiz;
        while (aux != null) {
            if (aux.id.equals(id)) {
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    /**
     * Elimina una persona por ID
     * @return true si se eliminó
     */
    public boolean eliminarPorId(String id) {
        Nodo aux = raiz;

        while (aux != null) {
            if (aux.id.equals(id)) {

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
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    /**
     * Muestra todas las personas registradas
     */
    public void mostrar() {
        if (raiz == null) {
            System.out.println("La agenda está vacía.");
            return;
        }

        Nodo aux = raiz;
        while (aux != null) {
            System.out.println("---------------------------");
            System.out.println("ID: " + aux.id);
            System.out.println("Nombre: " + aux.nombre);
            System.out.println("Peso: " + aux.peso);
            System.out.println("Estatura: " + aux.estatura);
            System.out.println("IMC: " + String.format("%.2f", aux.imc));
            aux = aux.sig;
        }
        System.out.println("---------------------------");
    }

    /**
     * Menú principal
     */
    public void menu() {
        int op;

        do {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Insertar persona");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Eliminar por ID");
            System.out.println("4. Mostrar agenda");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            op = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (op) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Peso (kg): ");
                    double peso = sc.nextDouble();
                    System.out.print("Estatura (m): ");
                    double estatura = sc.nextDouble();

                    insertarFinal(id, nombre, peso, estatura);
                    System.out.println("Persona agregada.");
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    id = sc.nextLine();
                    System.out.println(
                        buscarPorId(id) ? "Persona encontrada." : "No existe."
                    );
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    id = sc.nextLine();
                    System.out.println(
                        eliminarPorId(id) ? "Persona eliminada." : "No encontrada."
                    );
                    break;

                case 4:
                    mostrar();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 5);
    }

    public static void main(String[] args) {
        AgendaFinal a = new AgendaFinal();
        a.menu();
    }
}
