package net.karlmartens.ser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import net.karlmartens.data.AttributeValue;

import java.io.IOException;

public class AttributeValueDeserializer extends StdDeserializer<AttributeValue> {

    public AttributeValueDeserializer() {
        super(AttributeValue.class);
    }

    @Override
    public AttributeValue deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.getCurrentToken()) {
            case VALUE_STRING:
                return AttributeValue.create(jsonParser.getValueAsString());

            case VALUE_FALSE:
            case VALUE_TRUE:
                return AttributeValue.create(jsonParser.getBooleanValue());

            case VALUE_NUMBER_FLOAT:
                return AttributeValue.create(jsonParser.getDoubleValue());

            case VALUE_NUMBER_INT:
                return AttributeValue.create(jsonParser.getIntValue());

            case VALUE_NULL:
                return AttributeValue.nullValue();

            default:
                deserializationContext.handleUnexpectedToken(AttributeValue.class, jsonParser);
        }

        throw new IllegalStateException();
    }
}
