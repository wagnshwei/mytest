package demo.staticblock;

public class Test {

    private static String name;

    static {
        System.out.println("static block");
        name = "Test";
    }

    public Test() {
        System.out.println("constructor");
    }

    {
        System.out.println("instance block");
    }

    public static void main(String[] args) {
        new Test();
        System.out.println("-----------------");
        new Test();
        System.out.println("-----------------");
        new Test();
    }

}
