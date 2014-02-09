package parser.ast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IntegerLiteralTest {

    @Test
    public void testSimilarIntegerLiteralsShouldMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        IntegerLiteral similarIntegerLiteral = new IntegerLiteral(1);

        assertEquals(integerLiteral, similarIntegerLiteral);
    }

    @Test
    public void testDifferentIntegerLiteralsShouldNotMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        IntegerLiteral differentIntegerLiteral = new IntegerLiteral(2);

        assertNotEquals(integerLiteral, differentIntegerLiteral);
    }
}
