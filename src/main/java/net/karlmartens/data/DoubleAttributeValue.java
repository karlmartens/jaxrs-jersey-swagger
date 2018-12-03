package net.karlmartens.data;

public class DoubleAttributeValue extends AttributeValue {

    private final double _value;

    DoubleAttributeValue(double value) {
        _value = value;
    }

    @Override
    public <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T {
        return visitor.accept(_value);
    }
}
