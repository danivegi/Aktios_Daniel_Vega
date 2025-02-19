package modelo;
import java.util.Arrays;

public class Ej_Multi {

    public static int multiplicar(int num1, int num2) {
        String strNum1 = Integer.toString(num1);
        String strNum2 = Integer.toString(num2);
        int filas = strNum2.length();
        int columnas = strNum1.length() + filas;
        int[][] matriz = new int[filas][columnas];

        for (int i = filas - 1; i >= 0; i--) {
            int digito2 = Character.getNumericValue(strNum2.charAt(i));
            int acarreo = 0;
            int filaActual = filas - 1 - i;
            int columna = columnas - 1 - filaActual;

            for (int j = strNum1.length() - 1; j >= 0; j--) {
                int digito1 = Character.getNumericValue(strNum1.charAt(j));
                int producto = digito1 * digito2 + acarreo;
                matriz[filaActual][columna] = producto % 10;
                acarreo = producto / 10;
                columna--;
            }
            if (acarreo > 0) {
                matriz[filaActual][columna] = acarreo;
            }
        }
        return sumarMatriz(matriz);
    }

    private static int sumarMatriz(int[][] matriz) {
        int sumaFinal = 0;
        int acarreo = 0;
        int columnas = matriz[0].length;

        for (int j = columnas - 1; j >= 0; j--) {
            int sumaColumna = acarreo;
            for (int[] fila : matriz) {
                sumaColumna += fila[j];
            }
            sumaFinal = sumaColumna % 10 + sumaFinal * 10;
            acarreo = sumaColumna / 10;
        }
        return sumaFinal;
    }

    public static void main(String[] args) {
        int num1 = 4103;
        int num2 = 254;
        System.out.println("Resultado: " + multiplicar(num1, num2));
    }

}
