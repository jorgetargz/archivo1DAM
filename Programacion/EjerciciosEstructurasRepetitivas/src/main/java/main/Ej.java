package main;

import java.util.Random;
import java.util.Scanner;

public class Ej {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valores = 10;
        for (int i = 0; i < valores ; i++) {
            System.out.println(i);
            for (int j = i; j < valores+i; j++) {
                System.out.println(j%valores);
            }
        }
    }
}
