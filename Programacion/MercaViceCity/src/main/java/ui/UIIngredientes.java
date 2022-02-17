package ui;

import modelo.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIIngredientes {

    public List<Ingrediente> uiListaIngredientes(Scanner sc) {
        int op;
        List<Ingrediente> ingredientes = new ArrayList<>();
        do {
            System.out.println("0. No añadir mas ingredientes");
            System.out.println("1. Añadir otro ingrediente");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1) {
                System.out.print("Indica nombre de ingrediente: ");
                ingredientes.add(new Ingrediente(sc.nextLine()));
            }
        } while (op != 0);
        return ingredientes;
    }
}
