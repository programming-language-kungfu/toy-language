package parser.ast;

public abstract class Statement {
}

class StatementSequence extends Statement {

}

class VariableDeclaration extends Statement {
    String identifier;
    Expression expression;
}

