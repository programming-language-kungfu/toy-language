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
        Statement result = null;

        if (tokens.size() <= tokens.indexOf(tokenAfterEquals) + 1) {
            try {
                result = parseIntegerAssignmentWith(identifier, tokenAfterEquals);
            } catch (NumberFormatException nfe) {
                result = new AssignmentStatement(identifier, new StringLiteral(tokenAfterEquals));
            }
        } else {
            int index = tokens.indexOf(tokenAfterEquals);
            String nextToken = tokens.get(index + 1);
            List<String> operands = new ArrayList<String>();

            while (!nextToken.equals(";") && !nextToken.equals("\\n")) {
                operands.add(nextToken);
                index += 1;
                nextToken = tokens.get(index);
            }

            IntegerLiteral leftOperand = new IntegerLiteral(Integer.parseInt(tokenAfterEquals));
            IntegerLiteral rightOperand = new IntegerLiteral(Integer.parseInt(operands.get(2)));
            result = new AssignmentStatement(identifier, new BinaryExpression(leftOperand, BinaryOperator.Add, rightOperand));
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
