import javax.json.JsonObjectBuilder;

public class MsgDouble extends MsgField {
    public MsgDouble(String name, int idx) {
        super(name, idx);
    }

    private Double handle(String value) {
        return Double.parseDouble(value);
    }

    public void addJson(String value, JsonObjectBuilder builder) {
        builder.add(this.getName(), this.handle(value));
    }
}
