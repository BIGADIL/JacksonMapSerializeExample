package jacksonexample.mapkeys;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedMapKey extends MapKey {
    @JsonProperty
    final int z;

    @JsonCreator
    public ExtendedMapKey(@JsonProperty("x") final int x,
                          @JsonProperty("y") final int y,
                          @JsonProperty("z") final int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }
}