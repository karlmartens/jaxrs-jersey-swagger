package net.karlmartens.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.karlmartens.ser.AttributeValueDeserializer;
import net.karlmartens.ser.AttributeValueSerializer;

@JsonSerialize(using = AttributeValueSerializer.class)
@JsonDeserialize(using = AttributeValueDeserializer.class)
public abstract class AttributeValue {

    public abstract <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T;

    public static final AttributeValue NULL = new AttributeValue() {
        @Override
        public <R, T extends Throwable> R visit(AttributeValueVisitor<R, T> visitor) throws T {
            return visitor.acceptNull();
        }
    };

    public static AttributeValue nullValue() {
        return NULL;
    }

    public static AttributeValue create(String value) {
        if (value == null)
            return nullValue();

        return new StringAttributeValue(value);
    }

    public static AttributeValue create(double value) {
        return new DoubleAttributeValue(value);
    }

    public static AttributeValue create(int value) {
        return new IntegerAttributeValue(value);
    }

    public static AttributeValue create(boolean value) {
        return new BooleanAttributeValue(value);
    }

}
