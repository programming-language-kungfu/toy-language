package parser;

import org.junit.Ignore;
import org.junit.Test;
import parser.ast.*;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private String sourceCode;
    private Scanner scanner;
    private Parser parser;

    @Test
    public void testShouldParsePrintStatementWithStringLiteral() {
        sourceCode = "print \"Hello World\"";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        PrintStatement printStatement = new PrintStatement(new StringLiteral("Hello World"));
        assertEquals(parser.abstractSyntaxTree(), printStatement);
    }

    @Test
    public void testShouldParseBasicAssignmentStatement() {
        sourceCode = "var a = 1";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        AssignmentStatement basicAssignment = new AssignmentStatement("a", new IntegerLiteral(1));
        assertEquals(parser.abstractSyntaxTree(), basicAssignment);
    }

    @Ignore
    @Test
    public void testShouldParseAssignmentStatementWithBinaryExpression(){
        sourceCode = "var a = 1 + 1";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        BinaryOperation binaryOperation = new BinaryOperation(integerLiteral, BinaryOperator.Add, integerLiteral);
        assertEquals(parser.abstractSyntaxTree(), new AssignmentStatement("a", binaryOperation));
    }

    @Ignore
    @Test
    public void testShouldParsePrintWithExpression(){
        sourceCode = "var number = 1 + 1; print number";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        BinaryOperation binaryOperation = new BinaryOperation(new IntegerLiteral(1), BinaryOperator.Add, new IntegerLiteral(1));
        PrintStatement printStatement = new PrintStatement(binaryOperation);
        assertEquals(parser.abstractSyntaxTree(), printStatement);
    }

}
