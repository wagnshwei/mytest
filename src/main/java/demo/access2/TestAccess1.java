package demo.access2;

import demo.access.AccessModifier;

public class TestAccess1 {

    public void test() {
        AccessModifier am = new AccessModifier();
        am.publicField = "public";
//        am.protectedField = "protected";
//        am.privateField = "private";
//        am.defaultField = "default";
    }

}
