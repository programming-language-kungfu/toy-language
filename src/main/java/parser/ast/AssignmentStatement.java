package parser.ast;

public class AssignmentStatement extends Statement {
    private String identifier;
    private Expression expression;

    public AssignmentStatement(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignmentStatement that = (AssignmentStatement) o;

        if (!expression.equals(that.expression)) return false;
        if (!identifier.equals(that.identifier)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + expression.hashCode();
        return result;
    }
}
