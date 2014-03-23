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
                String tokenAfterEquals = tokens.get(currentIndex + 3);
                String identifier = tokens.get(1);

                parseAssignmentStatementWith(identifier, tokenAfterEquals);
                break;
            }
        }
        return abstractSyntaxTree;
    }

    private void parseAssignmentStatementWith(String identifier, String tokenAfterEquals) {
        try {
            parseIntegerAssignmentWith(identifier, tokenAfterEquals);
        } catch (NumberFormatException nfe) {
            abstractSyntaxTree = new AssignmentStatement(identifier, new StringLiteral(tokenAfterEquals));
        }
    }

    private void parseIntegerAssignmentWith(String identifier, String tokenAfterEquals) {
        Integer number = Integer.parseInt(tokenAfterEquals);
        abstractSyntaxTree = new AssignmentStatement(identifier, new IntegerLiteral(number));
    }

    private void parsePrintStatementAt(int currentIndex) {
        String expressionToPrint = tokens.get(currentIndex + 1);
        abstractSyntaxTree = new PrintStatement(new StringLiteral(expressionToPrint));
    }

}
