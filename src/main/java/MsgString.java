import javax.json.JsonObjectBuilder;

public class MsgString extends MsgField {

    public MsgString(String name, int index) {
        super(name, index);
    }

    private String handle(String value) {
        return value;
    }

    public void addJson(String value, JsonObjectBuilder builder) {
        builder.add(this.getName(), this.handle(value));
    }
}
