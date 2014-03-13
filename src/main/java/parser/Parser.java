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

                    currentIndex = currentIndex + 4;
                    if(tokens.get(currentIndex + 4).equals(";") || tokens.get(currentIndex).equals("\n")){
                        try{
                            Integer integer = Integer.parseInt(tokenAfterEqualsWithOutQoutes);
                            abstractSyntaxTree = new AssignmentStatement(nextToken, new IntegerLiteral(integer));
                        }catch(Exception e){
                            abstractSyntaxTree = new AssignmentStatement(nextToken, new StringLiteral(tokenAfterEquals));
                        }
                    }else {
                        nextToken = tokens.get(currentIndex);
                        List<String> operands = new ArrayList<String>();
                        while(!nextToken.equals(";") && !nextToken.equals("\n")){
                            operands.add(nextToken);
                            nextToken = tokens.get(currentIndex ++);
                        }


                        IntegerLiteral leftOperand = new IntegerLiteral(Integer.parseInt(operands.get(0).replace("^\" | $\"", "")));

                        BinaryOperator operator = BinaryOperator.Add;

                        IntegerLiteral rightOperand = new IntegerLiteral(Integer.parseInt(operands.get(2).replace("^\" | $\"", "")));
                        BinaryExpression binaryExpression = new BinaryExpression(leftOperand, operator, rightOperand);
                        abstractSyntaxTree = new AssignmentStatement(tokenAfterEquals, binaryExpression);
                    }
                }
            } catch (IndexOutOfBoundsException aie) {
                break;
            }
        }
        return abstractSyntaxTree;
    }

}
