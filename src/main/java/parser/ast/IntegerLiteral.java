package parser.ast;

public class IntegerLiteral extends Expression {
    private int value;

    public IntegerLiteral(int i) {
        value = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerLiteral that = (IntegerLiteral) o;

        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
