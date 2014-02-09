package parser;

import parser.ast.*;

import java.util.List;

public class Parser {
    private final List<String> tokens;
    private Statement abstractSyntaxTree;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Statement abstractSyntaxTree() {
        if(tokens.get(0).equals("print")){
            abstractSyntaxTree = new PrintStatement(new StringLiteral(tokens.get(1)));
        }else if(tokens.get(0).equals("var")){
            IntegerLiteral integerLiteral = new IntegerLiteral(Integer.parseInt(tokens.get(3)));
            abstractSyntaxTree = new AssignmentStatement(tokens.get(1), integerLiteral);
        }
        return abstractSyntaxTree;
    }

}
