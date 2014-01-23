package parser;

public abstract class Expression {}

class StringLiteral extends Expression {
    String value;
}

class IntegerLiteral extends Expression{
    int value;
}

class Variable extends Expression{
    String identifier;
}

class BinaryOperation extends Expression {
    Expression leftOperand;
    BinaryOperator binaryOperator;
    Expression rightOperand;
}