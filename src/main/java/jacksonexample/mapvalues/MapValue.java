package jacksonexample.mapvalues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapValue implements IMapValue {
    @JsonProperty
    final String firstName;

    @JsonCreator
    public MapValue(@JsonProperty("firstName") final String firstName) {
        this.firstName = firstName;
    }

    public static MapValue getMapValueFromString(final String mapValueString) throws JsonProcessingException {
        return new ObjectMapper().readValue(mapValueString, MapValue.class);
    }

    public static String mapValueString(final MapValue mapValue) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(mapValue);
    }

    @Override
    public String toString() {
        return "firstName=" + firstName;
    }
}