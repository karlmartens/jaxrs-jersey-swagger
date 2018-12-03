package net.karlmartens.data;

public class BooleanAttributeValue extends AttributeValue {

    private final boolean _value;

    BooleanAttributeValue(boolean value) {
        _value = value;
    }

    @Override
    public <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T {
        return visitor.accept(_value);
    }
}
