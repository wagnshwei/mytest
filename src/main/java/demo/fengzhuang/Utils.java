package demo.fengzhuang;

import java.time.Year;

public class Utils {

    /**
     * 根据年龄计算出生年份。
     *
     * @param age 年龄
     * @return 出生年份（字符串格式，如"2000"）
     */
    public static String getBirthYear(int age) {
        int currentYear = Year.now().getValue();
        int birthYear = currentYear - age;
        return String.valueOf(birthYear);
    }

    /**
     * 根据出生年份计算年龄。
     *
     * @param birthYear 出生年份（字符串格式，如"2000"）
     * @return 年龄
     */
    public static int getAge(String birthYear) {
        int birthYearInt = Integer.parseInt(birthYear);
        int currentYear = Year.now().getValue();
        return currentYear - birthYearInt;
    }

    /**
     * 校验年龄和生日是否匹配。
     *
     * @param age 年龄
     * @param birthYear 出生年份（字符串格式，如"2000"）
     * @return 如果年龄和生日匹配，则返回true；否则返回false
     */
    public static boolean isAgeAndBirthYearMatch(int age, String birthYear) {
        int calculatedAge = getAge(birthYear);
        return calculatedAge == age;
    }

}
