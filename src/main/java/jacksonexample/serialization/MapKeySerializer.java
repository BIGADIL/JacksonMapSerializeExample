package jacksonexample.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import jacksonexample.mapkeys.IMapKey;

import java.io.IOException;

public class MapKeySerializer extends JsonSerializer<IMapKey> {

    @Override
    public void serialize(final IMapKey value,
                          final JsonGenerator gen,
                          final SerializerProvider serializers) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        gen.writeFieldName(mapper.writeValueAsString(value));
    }
}