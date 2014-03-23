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
                abstractSyntaxTree = parsePrintStatementAt(currentIndex);
                break;
            } else {
                String identifier = tokens.get(1);
                String tokenAfterEquals = tokens.get(currentIndex + 3);

                abstractSyntaxTree = parseAssignmentStatementWith(identifier, tokenAfterEquals);
                break;
            }
        }
        return abstractSyntaxTree;
    }

    private Statement parseAssignmentStatementWith(String identifier, String tokenAfterEquals) {
        Statement result;
        try {
            result = parseIntegerAssignmentWith(identifier, tokenAfterEquals);
        } catch (NumberFormatException nfe) {
            result = new AssignmentStatement(identifier, new StringLiteral(tokenAfterEquals));
        }
        return result;
    }

    private Statement parseIntegerAssignmentWith(String identifier, String tokenAfterEquals) {
        Integer number = Integer.parseInt(tokenAfterEquals);
        return new AssignmentStatement(identifier, new IntegerLiteral(number));
    }

    private Statement parsePrintStatementAt(int currentIndex) {
        String expressionToPrint = tokens.get(currentIndex + 1);
        return new PrintStatement(new StringLiteral(expressionToPrint));
    }

}
