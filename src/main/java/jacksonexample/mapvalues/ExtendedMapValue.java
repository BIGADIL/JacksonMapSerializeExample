package jacksonexample.mapvalues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedMapValue extends MapValue {
    @JsonProperty
    final String secondName;

    @JsonProperty
    final Inner inner;

    @JsonCreator
    public ExtendedMapValue(@JsonProperty("firstName") final String firstName,
                     @JsonProperty("secondName") final String secondName,
                     @JsonProperty("Inner") final Inner inner) {
        super(firstName);
        this.secondName = secondName;
        this.inner = inner;
    }

    @Override
    public String toString() {
        return super.toString() + ", secondName=" + secondName + ", inner.i=" + inner.i;
    }

    public static class Inner {
        @JsonProperty
        final double i;

        public Inner(@JsonProperty("Inner") final double i) {
            this.i = i;
        }
    }
}
