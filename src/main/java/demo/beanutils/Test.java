package demo.beanutils;

import org.springframework.beans.BeanUtils;

public class Test {

    public static void main(String[] args) {
        Bean0 bean0 = new Bean0();
        bean0.setName("bean0");
        bean0.setAge(null);
        Bean1 bean1 = new Bean1();
        bean1.setAge(0L);

        BeanUtils.copyProperties(bean0, bean1);

        System.out.println(bean0);
        System.out.println(bean1);
    }

}

class Bean0 {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
    public String toString(){
        return name + ":" + age;
    }
}

class Bean1 {
    private String name;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
    public String toString(){
        return name + ":" + age;
    }
}
