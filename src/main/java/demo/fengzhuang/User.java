package demo.fengzhuang;

public class User extends BaseUser {

    private static final int MAX_AGE = 120;
    private static final int MIN_AGE = 0;

    private int age;
    private String birthday;

    public User(String name, int age, String birthday) {
        super(name);
        if(!Utils.isAgeAndBirthYearMatch(age, birthday)){
            throw new IllegalArgumentException("age and birthday are not match");
        }
        this.setAge(age);
        this.setBirthday(birthday);
    }

    public String getName() {
//        return super.name;
        return super.getName();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        super.setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Age must between 0 and 120");
        }
        this.age = age;
        // 计算生日
        this.birthday = Utils.getBirthYear(age);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        // 这里还可以有其他校验，比如出生日期格式是否正确，是否在当前日期之前等。。。
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday must not be null");
        }
        this.birthday = birthday;
        // 计算年龄
        this.age = Utils.getAge(birthday);
    }

    public void introduce() {
        System.out.println("Hello, my name is " + super.getName() + " and I was born on " + birthday + " and I am " + age + " years old.");
    }
}
