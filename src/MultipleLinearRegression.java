public class MultipleLinearRegression {

    private double[][] X;
    private double[] y;
    private double[] coefficients;

    public MultipleLinearRegression(double[][] X, double[] y) {
        this.X = X;
        this.y = y;
    }

    public void calcularCoeficientes() {
        int n = X.length; // Número de observaciones
        int m = X[0].length; // Número de variables exógenas

        // Calcular (X^T X)
        double[][] xtx = AlgebraLineal.multiplicarMatrices(AlgebraLineal.transponer(X), X);

        // Calcular (X^T X)^-1 usando el método de Gauss-Jordan
        double[][] inverseXTX = MatematicasDiscretas.invertirMatriz(xtx);

        // Verificar si la inversa es nula (matriz singular)
        if (inverseXTX == null) {
            System.out.println("La matriz X^T X es singular. No se pueden calcular los coeficientes.");
            return;
        }

        // Calcular X^T y
        double[] xtY = AlgebraLineal.multiplicarMatrizVector(AlgebraLineal.transponer(X), y);

        // Calcular coeficientes B = (X^T X)^-1 X^T y
        coefficients = AlgebraLineal.multiplicarMatrizVector(inverseXTX, xtY);

        // Imprimir coeficientes para verificar
        System.out.println("Coeficientes calculados:");
        for (double coef : coefficients) {
            System.out.println(coef);
        }
    }

    public double[] obtenerCoeficientes() {
        return coefficients;
    }
}