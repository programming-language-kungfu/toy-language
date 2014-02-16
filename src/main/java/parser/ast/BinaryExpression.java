package parser.ast;

import parser.BinaryOperator;

public class BinaryExpression extends Expression {
    private Expression leftOperand;
    private BinaryOperator binaryOperator;
    private Expression rightOperand;

    public BinaryExpression(Expression leftOperand, BinaryOperator binaryOperator, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.binaryOperator = binaryOperator;
        this.rightOperand = rightOperand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryExpression that = (BinaryExpression) o;

        if (binaryOperator != that.binaryOperator) return false;
        if (!leftOperand.equals(that.leftOperand)) return false;
        if (!rightOperand.equals(that.rightOperand)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leftOperand.hashCode();
        result = 31 * result + binaryOperator.hashCode();
        result = 31 * result + rightOperand.hashCode();
        return result;
    }
}
