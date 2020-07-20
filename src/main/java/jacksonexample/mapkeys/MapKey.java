package jacksonexample.mapkeys;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MapKey implements IMapKey {
    @JsonProperty
    final int x;
    @JsonProperty
    final int y;

    @JsonCreator
    public MapKey(@JsonProperty("x") final int x,
           @JsonProperty("y") final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

