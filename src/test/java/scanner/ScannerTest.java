package scanner;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ScannerTest {

    private Scanner scanner;

    @Test
    public void shouldReturnTokensFromPrintStatement() throws IOException {
        String sourceCode = "print \"Hello World\"";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "print", "Hello World");
        assertEquals(2, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromAssignmentStatement() {
        String sourceCode = "var a = 12";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "12");
        assertEquals(4, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromAdditionExpression() {
        String sourceCode = "var a = 1 + 2";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "1", "+", "1");
        assertEquals(6, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromSubtractionExpression() {
        String sourceCode = "var a = 1 - 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "1", "-", "1");
        assertEquals(6, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromMultipleExpression() {
        String sourceCode = "var a = 1 * 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "1", "*", "1");
        assertEquals(6, tokens.size());
    }

    @Test
    public void shouldReturnTokensFromDivisionExpression() {
        String sourceCode = "var a = 1 / 1";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "1", "/", "1");
        assertEquals(6, tokens.size());
    }

    @Test
    public void testAssignmentOfStringsToVariables() {
        String sourceCode = "var a = \"This is a string\"";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "This is a string");
        assertEquals(4, tokens.size());
    }

    @Test
    public void testNumericAssignmentWithOutWhiteSpace() {
        String sourceCode = "var a=12";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();

        assertListContains(tokens, "var", "a", "=", "12");
        assertEquals(4, tokens.size());
    }

    @Test
    public void testStringAssignmentWithoutWhiteSpace(){
        String sourceCode = "var a=\"This is a string\"";
        scanner = new Scanner(sourceCode);

        List<String> tokens = scanner.getTokens();
        assertListContains(tokens, "var", "a", "=", "This is a string");
        assertEquals(4, tokens.size());
    }

    @Ignore
    @Test
    public void testAnTerminatedStringShouldBeInvalidSyntax(){
        String sourceCode = "print \"This is a string";
        scanner = new Scanner(sourceCode);

        scanner.getTokens();
    }

    private void assertListContains(List<String> tokens, String... expectedTokens) {
        assertThat(tokens, hasItems(expectedTokens));
    }

}

//TODO=>  test for incorrectly string eg "this is a string which is not terminated.