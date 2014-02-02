package parser;

public abstract class Statement {
}

class StatementSequence extends Statement {

}

class VariableDeclaration extends Statement {
    String identifier;
    Expression expression;
}

class PrintStatement extends Statement {
    Expression expression;

    PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrintStatement that = (PrintStatement) o;

        if (!expression.equals(that.expression)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return expression.hashCode();
    }
}

class AssignmentStatement extends Statement {
    String identifier;
    Expression expression;
}
