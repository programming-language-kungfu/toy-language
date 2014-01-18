package scanner;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScannerTest {

    private Scanner scanner;

    @Test
    public void shouldReturnTokensFromPrintStatement() throws IOException {

        String sourceCode = "print \"Hello World\"";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("Hello World"));
        assertTrue(tokens.contains("print"));
        assertEquals(2, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromAssignmentStatement(){
        String sourceCode = "var a = 12";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("12"));
        assertEquals(4, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromAdditionExpression(){
        String sourceCode = "var a = 1 + 2";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("1"));
        assertTrue(tokens.contains("+"));
        assertTrue(tokens.contains("2"));
        assertEquals(6, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromSubtractionExpression(){
        String sourceCode = "var a = 1 - 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("1"));
        assertTrue(tokens.contains("-"));
        assertTrue(tokens.contains("1"));
        assertEquals(6, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromMultipleExpression(){
        String sourceCode = "var a = 1 * 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("1"));
        assertTrue(tokens.contains("*"));
        assertTrue(tokens.contains("1"));
        assertEquals(6, tokens.size());

    }

    @Test
    public void shouldReturnTokensFromDivisionExpression(){
        String sourceCode = "var a = 1 / 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("1"));
        assertTrue(tokens.contains("/"));
        assertTrue(tokens.contains("1"));
        assertEquals(6, tokens.size());

    }

    @Ignore
    @Test
    public void shouldGetTokensWithOutWhiteSpaceInSourceCode(){
        String sourceCode = "var a=12";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertTrue(tokens.contains("var"));
        assertTrue(tokens.contains("a"));
        assertTrue(tokens.contains("="));
        assertTrue(tokens.contains("12"));
        assertEquals(4, tokens.size());
    }

}
