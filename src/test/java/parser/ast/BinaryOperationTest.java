package parser.ast;

import org.junit.Test;
import parser.BinaryOperator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BinaryOperationTest {

    @Test
    public void testSimilarBinaryOperationsShouldMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        BinaryOperation binaryOperation = new BinaryOperation(integerLiteral, BinaryOperator.Add, integerLiteral);

        assertEquals(binaryOperation, new BinaryOperation(integerLiteral, BinaryOperator.Add, integerLiteral));
    }

    @Test
    public void testDifferentBinaryOperationsShouldNotMatch(){
        IntegerLiteral integerLiteral = new IntegerLiteral(1);
        IntegerLiteral secondIntegerLiteral = new IntegerLiteral(2);
        BinaryOperation binaryOperation = new BinaryOperation(integerLiteral, BinaryOperator.Add, integerLiteral);

        assertNotEquals(binaryOperation, new BinaryOperation(integerLiteral, BinaryOperator.Add, secondIntegerLiteral));
    }
}
