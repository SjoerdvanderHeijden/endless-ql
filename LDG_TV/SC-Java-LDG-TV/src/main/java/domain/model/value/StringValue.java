package domain.model.value;

public class StringValue extends Value<String>{
    private String value;

    public StringValue(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(String s) throws Exception {
        this.value = s;
    }
}
