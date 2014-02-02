package parser.ast;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringLiteralTest {

    @Test
    public void shouldMatchStringLiteralWithSameValue(){
        StringLiteral expected = new StringLiteral("Hello World");
        StringLiteral actual = new StringLiteral(("Hello World"));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchStringLiteralWithDifferentValue(){
        StringLiteral expected = new StringLiteral("Hello World");
        StringLiteral actual = new StringLiteral(("Hello"));

        assertNotEquals(expected, actual);
    }
}
