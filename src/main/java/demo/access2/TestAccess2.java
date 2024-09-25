package demo.access2;

import demo.access.AccessModifier;

public class TestAccess2 extends AccessModifier {

    public void test() {
        super.publicField = "public";
        super.protectedField = "protected";
//        super.defaultField = "default";
//        super.privateField = "private";
    }


}
