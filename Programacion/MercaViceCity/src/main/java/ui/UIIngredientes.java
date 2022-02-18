package ui;

import modelo.Ingrediente;
import ui.common.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIIngredientes {

    public List<Ingrediente> uiListaIngredientes(Scanner sc) {
        int op;
        List<Ingrediente> ingredientes = new ArrayList<>();
        do {
            System.out.println(Constantes.NO_ANADIR_MAS_INGREDIENTES);
            System.out.println(Constantes.ANADIR_INGREDIENTE);
            System.out.print(Constantes.INTRODUCE_UNA_OPCION);
            op = sc.nextInt();
            sc.nextLine();
            if (op == 1) {
                System.out.print(Constantes.INDICA_NOMBRE_DE_INGREDIENTE);
                ingredientes.add(new Ingrediente(sc.nextLine()));
            }
        } while (op != 0);
        return ingredientes;
    }
}
