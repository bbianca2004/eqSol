package MathUtil;

public class QuadraticEquationSolution {
    public enum SolutionType{
        INCOMPATIBLE,
        TWO_EQUAL_ROOTS,
        TWO_DISTINCT_ROOTS
    }

    SolutionType solutionType;
    Double root1;
    Double root2;

    private QuadraticEquationSolution(SolutionType solutionType, Double root1, Double root2)
    {
        this.solutionType = solutionType;
        this.root1 = root1;
        this.root2 = root2;
    }

    public QuadraticEquationSolution(double root1, double root2)
    {
        if(root1 == root2)
        {
           this.solutionType = SolutionType.TWO_EQUAL_ROOTS;
        }
        else {
            this.solutionType = SolutionType.TWO_DISTINCT_ROOTS;
        }

        if(root1 > root2)
        {
            this.root1 = root2;
            this.root2 = root1;
        }
        else {
            this.root1 = root1;
            this.root2 = root2;
        }
    }

    public QuadraticEquationSolution(double root)
    {
        this(SolutionType.TWO_EQUAL_ROOTS, root, root);
    }

    public QuadraticEquationSolution()
    {
        this(SolutionType.INCOMPATIBLE, null, null);
    }

    @Override
    public String toString() {
        return "QuadraticEquationSolution{" +
                "solutionType=" + solutionType +
                ", root1=" + root1 +
                ", root2=" + root2 +
                '}';
    }
}
