public class Main {

    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        double[][] X = dataSet.obtenerMatrizX();
        double[] y = dataSet.obtenerVectorY();

        MultipleLinearRegression regression = new MultipleLinearRegression(X, y);
        regression.calcularCoeficientes();
        double[] coeficientes = regression.obtenerCoeficientes();

        // Imprime los coeficientes de regresión
        System.out.println("Formula Implementada: B=(X^T X)^-1 X^T y");
        System.out.println("Coeficientes de Regresión:");
        for (double coef : coeficientes) {
            System.out.println(coef);
        }

        // Realiza predicciones con nuevos valores
        double[][] nuevosValoresX = {
                {56.7, 31.5},
                {47.9, 30.7},
                {63.5, 31.9},
                {45.6, 21.8},
                {43.9, 12.4}
        };

        System.out.println("Predicciones:");
        for (double[] input : nuevosValoresX) {
            double prediccion = 0;
            for (int i = 0; i < coeficientes.length; i++) {
                prediccion += coeficientes[i] * input[i];
            }
            // Imprime la predicción
            System.out.println("Yield predicho para nuevos valores: " + prediccion);
        }
    }
}