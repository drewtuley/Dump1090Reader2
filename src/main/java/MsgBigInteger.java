import org.jetbrains.annotations.NotNull;

import javax.json.JsonObjectBuilder;
import java.math.BigInteger;

public class MsgBigInteger extends MsgField {

    public MsgBigInteger(String name, int index) {
        super(name, index);
    }

    @NotNull
    private BigInteger handle(String integer) {
        return new BigInteger(integer);
    }

    public void addJson(String value, @NotNull JsonObjectBuilder builder) {
        builder.add(this.getName(), this.handle(value));
    }

}