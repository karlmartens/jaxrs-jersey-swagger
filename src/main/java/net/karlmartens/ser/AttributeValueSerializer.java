package net.karlmartens.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import net.karlmartens.data.*;

import java.io.IOException;

public class AttributeValueSerializer extends StdSerializer<AttributeValue> {

    public AttributeValueSerializer() {
        super(AttributeValue.class);
    }

    @Override
    public void serialize(AttributeValue value, final JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value == null)
            return;

        value.visit(new AttributeValueVisitor<Void, IOException>() {
           @Override
           public Void accept(boolean v) throws IOException {
               jsonGenerator.writeBoolean(v);
               return null;
           }

           @Override
           public Void accept(String v) throws IOException {
               jsonGenerator.writeString(v);
               return null;
           }

            @Override
           public Void accept(int v) throws IOException {
               jsonGenerator.writeNumber(v);
               return null;
           }

            @Override
           public Void accept(double v) throws IOException {
               jsonGenerator.writeNumber(v);
                return null;
           }

           @Override
            public Void acceptNull() throws IOException {
               jsonGenerator.writeNull();
               return null;
           }

        });
    }
}
