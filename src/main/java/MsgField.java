import javax.json.JsonObjectBuilder;

public abstract class MsgField {
    private int index;
    private String name;


    public MsgField(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "index=" + this.index + " name=" + this.name;
    }

    public abstract void addJson(String value, JsonObjectBuilder oBuilder);
}
