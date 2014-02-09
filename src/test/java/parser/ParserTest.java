package parser;

import org.junit.Test;
import parser.ast.IntegerLiteral;
import parser.ast.PrintStatement;
import parser.ast.StringLiteral;
import parser.ast.AssignmentStatement;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private String sourceCode;
    private Scanner scanner;
    private Parser parser;

    @Test
    public void testShouldParsePrintSatement() {
        sourceCode = "print \"Hello World\"";
        scanner = new Scanner(sourceCode);

        parser = new Parser(scanner.getTokens());

        PrintStatement printStatement = new PrintStatement(new StringLiteral("Hello World"));
        assertEquals(parser.abstractSyntaxTree(), printStatement);
    }

    @Test
    public void testShouldPrintAssignmentStatement() {
        sourceCode = "var a = 1";
        scanner = new Scanner(sourceCode);
        IntegerLiteral integerLiteral = new IntegerLiteral();
        integerLiteral.value = 1;

        parser = new Parser(scanner.getTokens());

        assertEquals(parser.abstractSyntaxTree(), new AssignmentStatement("a", integerLiteral));
    }


}
