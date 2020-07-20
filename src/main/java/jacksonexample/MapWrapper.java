package jacksonexample;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jacksonexample.mapkeys.ExtendedMapKey;
import jacksonexample.mapkeys.IMapKey;
import jacksonexample.mapkeys.MapKey;
import jacksonexample.mapvalues.ExtendedMapValue;
import jacksonexample.mapvalues.IMapValue;
import jacksonexample.mapvalues.MapValue;
import jacksonexample.serialization.MapKeyDeserializer;
import jacksonexample.serialization.MapKeySerializer;

import java.util.HashMap;
import java.util.Map;

public class MapWrapper {

    @JsonSerialize(keyUsing = MapKeySerializer.class)
    @JsonDeserialize(keyUsing = MapKeyDeserializer.class)
    final Map<IMapKey, IMapValue> map;

    public MapWrapper(@JsonProperty("map") final Map<IMapKey, IMapValue> map) {
        this.map = map;
    }

    public static MapWrapper getMapWrapperFromString(final String mapWrapperString) throws JsonProcessingException {
        return new ObjectMapper().readValue(mapWrapperString, MapWrapper.class);
    }

    public static String mapWrapperToString(final MapWrapper mapWrapper) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(mapWrapper);
    }

    public static void main(final String[] args) throws JsonProcessingException {
        final Map<IMapKey, IMapValue> map = new HashMap<>();
        map.put(new MapKey(0, 0), new MapValue("zero"));
        map.put(new ExtendedMapKey(1, 0, 1), new ExtendedMapValue("one", "zero", new ExtendedMapValue.Inner(3.14)));
        final MapWrapper mapWrapper = new MapWrapper(map);
        final String wrapper = mapWrapperToString(mapWrapper);
        System.out.println(wrapper);
        final MapWrapper mapWrapperFromString = getMapWrapperFromString(wrapper);
        for (final Map.Entry<IMapKey, IMapValue> mapKeyMapValueEntry : mapWrapperFromString.map.entrySet()) {
            System.out.println(mapKeyMapValueEntry.getKey() + " -> " + mapKeyMapValueEntry.getValue());
        }
    }
}