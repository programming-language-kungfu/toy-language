package parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testShouldParsePrintSatement() {
        String sourceCode = "print \"Hello World\"";
        Scanner scanner = new Scanner(sourceCode);

        Parser parser = new Parser(scanner.getTokens());

        PrintStatement printStatement = new PrintStatement(new StringLiteral("Hello World"));
        assertEquals(parser.abstractSyntaxTree(), printStatement);
    }
}
