package parser.ast;

import parser.BinaryOperator;

public abstract class Expression {
}

class Variable extends Expression {
    String identifier;
}

class BinaryOperation extends Expression {
    Expression leftOperand;
    BinaryOperator binaryOperator;
    Expression rightOperand;
}