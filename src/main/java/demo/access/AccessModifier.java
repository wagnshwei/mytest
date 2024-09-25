package demo.access;

public class AccessModifier {

    private String privateField;

    protected String protectedField;

    String defaultField;

    public String publicField;

    public void test() {
        this.privateField = "private";
        this.protectedField = "protected";
        this.privateField = "private";
        this.defaultField = "default";
    }

}
