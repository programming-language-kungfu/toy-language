package parser;

import parser.ast.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<String> tokens;
    private Statement abstractSyntaxTree;


    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Statement abstractSyntaxTree() {
        for (String token : tokens) {
            int currentIndex = tokens.indexOf(token);
            if (token.equals("print")) {
                parsePrintStatementAt(currentIndex);
                break;
            } else {
                try {
                    Integer number = Integer.parseInt(tokens.get(3));
                    abstractSyntaxTree = new AssignmentStatement(tokens.get(1), new IntegerLiteral(number));
                } catch (NumberFormatException nfe) {
                    abstractSyntaxTree = new AssignmentStatement(tokens.get(1), new StringLiteral(tokens.get(3)));
                }
                break;
            }
        }
        return abstractSyntaxTree;
    }

    private void parsePrintStatementAt(int currentIndex) {
        String expressionToPrint = tokens.get(currentIndex + 1);
        abstractSyntaxTree = new PrintStatement(new StringLiteral(expressionToPrint));
    }

}
