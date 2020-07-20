package jacksonexample.mapvalues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MapValue.class, name = "MapValue"),
        @JsonSubTypes.Type(value = ExtendedMapValue.class, name = "ExtendedMapValue"),
}
)
public interface IMapValue {

}