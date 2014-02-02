package parser;

import java.util.List;

public class Parser {
    private Statement abstractSyntaxTree;

    public Parser(List<String> tokens) {

    }

    public Statement abstractSyntaxTree() {
        abstractSyntaxTree = new PrintStatement(new StringLiteral("Hello World"));
        return abstractSyntaxTree;
    }

}
