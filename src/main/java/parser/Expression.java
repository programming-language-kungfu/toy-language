package parser;

public abstract class Expression {
}

class StringLiteral extends Expression {
    String value;

    public StringLiteral(String stringLiteral) {
        value = stringLiteral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringLiteral that = (StringLiteral) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

class IntegerLiteral extends Expression {
    int value;
}

class Variable extends Expression {
    String identifier;
}

class BinaryOperation extends Expression {
    Expression leftOperand;
    BinaryOperator binaryOperator;
    Expression rightOperand;
}