package demo.testlombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends BaseUser{

    private int age;
    private int gender;



}
