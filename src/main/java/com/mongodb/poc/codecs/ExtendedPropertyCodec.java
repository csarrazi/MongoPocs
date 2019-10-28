package com.mongodb.poc.codecs;

import com.mongodb.poc.models.ExtendedProperty;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ExtendedPropertyCodec implements Codec<ExtendedProperty> {
    @Override
    public void encode(final BsonWriter writer, final ExtendedProperty prop, final EncoderContext context) {
        if (prop.getValue() instanceof Double) {
            writer.writeDouble((Double) prop.getValue());
        } else if (prop.getValue() instanceof String) {
            writer.writeString((String) prop.getValue());
        } else if (prop.getValue() == null) {
            writer.writeNull();
        }
    }

    @Override
    public ExtendedProperty decode(BsonReader reader, DecoderContext context) {
        ExtendedProperty prop = new ExtendedProperty();

        if (BsonType.STRING.equals(reader.getCurrentBsonType())) {
            prop.setValue(reader.readString());
        } else if (BsonType.INT64.equals(reader.getCurrentBsonType())) {
            prop.setValue(reader.readInt64());
        } else if (BsonType.NULL.equals(reader.getCurrentBsonType())) {
            prop.setValue(null);
            reader.readNull();
        }

        return prop;
    }

    @Override
    public Class<ExtendedProperty> getEncoderClass() {
        return ExtendedProperty.class;
    }
}
