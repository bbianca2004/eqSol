package MathUtil;

public class MathUtil implements MathUtilInterface{
    @Override
    public QuadraticEquationSolution solveQuadraticEquation(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (delta < 0)
            return new QuadraticEquationSolution();
        else {
            double sqrt = Math.sqrt(delta);
            return new QuadraticEquationSolution((-b + sqrt) / (2 * a), (-b - sqrt) / (2 * a));
        }
    }
}
