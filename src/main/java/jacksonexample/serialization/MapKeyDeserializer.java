package jacksonexample.serialization;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import jacksonexample.mapkeys.IMapKey;

import java.io.IOException;

public class MapKeyDeserializer extends KeyDeserializer {

    @Override
    public Object deserializeKey(final String key,
                                 final DeserializationContext ctxt) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(key, IMapKey.class);
    }
}
