package parser.ast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PrintStatementTest {

    @Test
    public void shouldMatchOtherStatementWithSameExpression(){
        StringLiteral stringLiteral = new StringLiteral("Hello World");
        PrintStatement printStatement = new PrintStatement(stringLiteral);

        assertEquals(printStatement, new PrintStatement(stringLiteral));
    }

    @Test
    public void shouldNotMatchOtherStatementWithDifferentExpression() {
        StringLiteral stringLiteral = new StringLiteral("This is a string literal");
        PrintStatement printStatement = new PrintStatement(stringLiteral);

        assertNotEquals(printStatement, new PrintStatement(new StringLiteral("Hello World")));
    }
}
