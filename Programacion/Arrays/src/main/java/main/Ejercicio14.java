package main;


public class Ejercicio14 {
    public void ejercicio14() {
        int[] valores1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] valores2 = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};

        int[] valores3 = new int[20];
        int indiceValores1 = 0;
        int indiceValores2 = 0;
        int indiceValores3 = 0;
        while (indiceValores1 < 10 && indiceValores2 < 10) {
            if (valores1[indiceValores1] < valores2[indiceValores2]) {
                valores3[indiceValores3] = valores1[indiceValores1];
                indiceValores1++;
            } else {
                valores3[indiceValores3] = valores2[indiceValores2];
                indiceValores2++;
            }
            indiceValores3++;
        }
        if (indiceValores1 == 10) {
            while (indiceValores2 < 10) {
                valores3[indiceValores3] = valores2[indiceValores2];
                indiceValores2++;
                indiceValores3++;
            }
        } else {
            while (indiceValores1 < 10) {
                valores3[indiceValores3] = valores1[indiceValores1];
                indiceValores1++;
                indiceValores3++;
            }
        }
        for (int i = 0; i < valores3.length; i++) {
            System.out.print(valores3[i] + " ");
        }
    }
}
