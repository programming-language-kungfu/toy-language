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
    public void testShouldParseBasicStringAssignmentStatement() {
        sourceCode = "var a = \"This is a string\"";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        AssignmentStatement basicStringAssignment = new AssignmentStatement("a", new StringLiteral("This is a string"));
        assertEquals(parser.abstractSyntaxTree(), basicStringAssignment);
    }

    @Test
    public void testShouldParseBasicIntegerAssignmentStatement() {
        sourceCode = "var a = 1";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        AssignmentStatement basicIntegerAssignment = new AssignmentStatement("a", new IntegerLiteral(1));
        assertEquals(parser.abstractSyntaxTree(), basicIntegerAssignment);
    }

    @Ignore
    @Test
    public void testShouldParseAssignmentStatementWithBinaryExpression(){
        sourceCode = "var a = 1 + 1";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        BinaryExpression binaryExpression = new BinaryExpression(integerLiteral, BinaryOperator.Add, integerLiteral);
        assertEquals(parser.abstractSyntaxTree(), new AssignmentStatement("a", binaryExpression));
    }

    @Ignore
    @Test
    public void testShouldParsePrintWithExpression(){
        sourceCode = "var number = 1 + 1; print number";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        BinaryExpression binaryExpression = new BinaryExpression(new IntegerLiteral(1), BinaryOperator.Add, new IntegerLiteral(1));
        PrintStatement printStatement = new PrintStatement(binaryExpression);
        assertEquals(parser.abstractSyntaxTree(), printStatement);
    }

}
