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
        for (String token : tokens) {
            try {
                int currentIndex = tokens.indexOf(token);
                String nextToken = tokens.get(currentIndex + 1);

                if (token.equals("print")) {
                    String substring = nextToken.substring(1, nextToken.length() - 1);
                    if (substring instanceof String) {
                        abstractSyntaxTree = new PrintStatement(new StringLiteral(nextToken));
                    }
                } else if (token.equals("var")) {
                    String variableName = nextToken;
                    String tokenAfterEquals = tokens.get(currentIndex + 2);
                    String tokenAfterEqualsWithOutQuotes = tokenAfterEquals.substring(1, tokenAfterEquals.length() - 1);

                    if(tokenAfterEqualsWithOutQuotes instanceof String){
                        abstractSyntaxTree = new AssignmentStatement(variableName,
                                new StringLiteral(tokenAfterEqualsWithOutQuotes));
                    }
                }
            } catch (IndexOutOfBoundsException aie) {
                break;
            }
        }
        return abstractSyntaxTree;
    }

}
