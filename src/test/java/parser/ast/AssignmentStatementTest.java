package parser.ast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AssignmentStatementTest {

    @Test
    public void testSimilarAssignmentStatementsShouldMatch() {
        IntegerLiteral integerLiteral = new IntegerLiteral();
        integerLiteral.value = 1;

        AssignmentStatement assignmentStatement = new AssignmentStatement("a", integerLiteral);
        assertEquals(assignmentStatement, new AssignmentStatement("a", integerLiteral));
    }

    @Test
    public void testDifferentAssignmentStatementsShouldNotMatch() {
        IntegerLiteral integerLiteral = new IntegerLiteral();
        integerLiteral.value = 1;
        IntegerLiteral differIntegerLiteral = new IntegerLiteral();
        differIntegerLiteral.value = 2;

        AssignmentStatement assignmentStatement = new AssignmentStatement("a", integerLiteral);
        AssignmentStatement differentAssignmentStatement = new AssignmentStatement("a", differIntegerLiteral);

        assertNotEquals(assignmentStatement, differentAssignmentStatement);
    }

}
