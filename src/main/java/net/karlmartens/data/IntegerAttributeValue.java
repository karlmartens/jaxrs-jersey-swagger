package net.karlmartens.data;

public class IntegerAttributeValue extends AttributeValue {

    private final int _value;

    IntegerAttributeValue(int value) {
        _value = value;
    }

    @Override
    public <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T {
        return visitor.accept(_value);
    }
}
