package net.karlmartens.data;

import java.util.Objects;

public class StringAttributeValue extends AttributeValue {

    private final String _value;

    StringAttributeValue(String value) {
        _value = Objects.requireNonNull(value);
    }

    @Override
    public <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T {
        return visitor.accept(_value);
    }
}
