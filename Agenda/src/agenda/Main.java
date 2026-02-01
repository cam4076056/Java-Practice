/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author Christian M
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Agenda simple");
        System.out.println("2. Agenda final");
        System.out.print("Seleccione: ");

        int op = sc.nextInt();

        if (op == 1) {
            new Agenda().menu();
        } else if (op == 2) {
            new AgendaFinal().menu();
        } else {
            System.out.println("Opción inválida");
        }
    }
}
