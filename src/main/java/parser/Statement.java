package parser;

public abstract class Statement {}

class VariableDeclaration extends Statement {
    String identifier;
    Expression expression;
}

class PrintStatement extends Statement {
    Expression expression;
}

class AssignmentStatement extends Statement {
    String identifier;
    Expression expression;
}
