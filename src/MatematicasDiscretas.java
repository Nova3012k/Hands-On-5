public class MatematicasDiscretas {

    public static double[][] invertirMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];

        // Inicializar la matriz identidad
        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
        }

        // Transformar la matriz original en la identidad y viceversa usando Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double divisor = matriz[i][i];
            for (int j = 0; j < n; j++) {
                matriz[i][j] /= divisor;
                identidad[i][j] /= divisor;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                        identidad[k][j] -= factor * identidad[i][j];
                    }
                }
            }
        }
        return identidad;
    }
}