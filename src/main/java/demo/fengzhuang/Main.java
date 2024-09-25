package demo.fengzhuang;

public class Main {
    public static void main(String[] args) {
        User user = new User("李华",18, "2006"); // 通过年龄计算生日

        // 修改年龄
        user.setAge(20);
        user.introduce();

        // 修改生日
        user.setBirthday("1995");
        user.introduce();
//        Object

    }
}
