package jacksonexample.mapkeys;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MapKey.class, name = "MapKey"),
        @JsonSubTypes.Type(value = ExtendedMapKey.class, name = "ExtendedMapKey")
})
public interface IMapKey {

}
