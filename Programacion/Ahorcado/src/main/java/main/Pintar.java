package main;

public class Pintar {
    public void dibujarAhorcado(int intentos) {
        switch (intentos) {
            case 9:
                System.out.println("   +---+");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 9 intentos.");
                break;
            case 8:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 8 intentos.");
                break;
            case 7:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 7 intentos.");
                break;
            case 6:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("   |   |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 6 intentos.");
                break;
            case 5:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("  (|   |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 5 intentos.");
                break;
            case 4:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("  (|)  |");
                System.out.println("       |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 4 intentos.");
                break;
            case 3:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("  (|)  |");
                System.out.println("   |   |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 3 intentos.");
                break;
            case 2:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("  (|)  |");
                System.out.println("  (|   |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 2 intentos.");
                break;
            case 1:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("   0   |");
                System.out.println("  (|)  |");
                System.out.println("  (|)  |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Tienes 1 intento.");
                break;
            case -1:
            case 0:
                System.out.println("   +---+");
                System.out.println("   |   |");
                System.out.println("  x x  |");
                System.out.println("  (|)  |");
                System.out.println("  (|)  |");
                System.out.println("       |");
                System.out.println("=========");
                System.out.println("Game over.");
                break;
            case 10:
                System.out.println("   +---+");
                System.out.println("       |");
                System.out.println(" $ $   |");
                System.out.println("  |    |");
                System.out.println(" (|)   |");
                System.out.println(" (|)   |");
                System.out.println("=========");
                System.out.println("Enhorabuena has ganado.");
                break;
        }
    }
}
