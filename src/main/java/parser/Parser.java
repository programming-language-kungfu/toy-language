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
                    String substring = nextToken.replaceAll("^\" | $\"", "");
                    if (substring instanceof String) {
                        abstractSyntaxTree = new PrintStatement(new StringLiteral(nextToken));
                    }
                } else if (token.equals("var")) {
                    String tokenAfterEquals = tokens.get(currentIndex + 3);
                    String tokenAfterEqualsWithOutQoutes = tokenAfterEquals.replaceAll("^\" | $\" ", "");

                    try{
                        Integer integer = Integer.parseInt(tokenAfterEqualsWithOutQoutes);
                        abstractSyntaxTree = new AssignmentStatement(nextToken, new IntegerLiteral(integer));
                    }catch(Exception e){
                        abstractSyntaxTree = new AssignmentStatement(nextToken, new StringLiteral(tokenAfterEquals));
                    }
                }
            } catch (IndexOutOfBoundsException aie) {
                break;
            }
        }
        return abstractSyntaxTree;
    }

}
