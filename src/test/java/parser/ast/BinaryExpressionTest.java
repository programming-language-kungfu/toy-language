package parser.ast;

import org.junit.Test;
import parser.BinaryOperator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BinaryExpressionTest {

    @Test
    public void testSimilarBinaryOperationsShouldMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        BinaryExpression binaryExpression = new BinaryExpression(integerLiteral, BinaryOperator.Add, integerLiteral);

        assertEquals(binaryExpression, new BinaryExpression(integerLiteral, BinaryOperator.Add, integerLiteral));
    }

    @Test
    public void testDifferentBinaryOperationsShouldNotMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        IntegerLiteral secondIntegerLiteral = new IntegerLiteral(2);
        BinaryExpression binaryExpression = new BinaryExpression(integerLiteral, BinaryOperator.Add, integerLiteral);

        assertNotEquals(binaryExpression, new BinaryExpression(integerLiteral, BinaryOperator.Add, secondIntegerLiteral));
    }
}
