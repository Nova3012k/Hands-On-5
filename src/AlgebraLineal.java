public class AlgebraLineal {

    public static double[][] transponer(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[][] matrizTranspuesta = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }
        return matrizTranspuesta;
    }

    public static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;
        double[][] resultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }

    public static double[] multiplicarMatrizVector(double[][] matriz, double[] vector) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[] resultado = new double[filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i] += matriz[i][j] * vector[j];
            }
        }
        return resultado;
    }
}