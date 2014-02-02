package parser;

import parser.ast.PrintStatement;
import parser.ast.Statement;
import parser.ast.StringLiteral;

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
