package com.ysu._03_reflect;

import com.ysu._00_bean.Person;
import com.ysu._00_bean.RiskParam;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * created by bing57592
 * 2018-10-20 22:10
 */
public class _01_ReflectionTest {
    /**
     * 没有使用反射的时候.
     */
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.name = "HRR";
        p1.show();
    }

    /**
     * 通过反射, 调用指定的构造器, 创建运行时类.
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class; // 运行时类
        Constructor<Person> constructor = clazz.getConstructor(String.class, Integer.class); // 调用形参为这种类型的构造器
        Person person = constructor.newInstance("12", 123);
        System.out.println(person);
    }

    /**
     * MMP, 还是用反射省事啊
     *
     * @throws IllegalAccessException
     */
    @Test
    public void test3() throws IllegalAccessException {
        RiskParam riskParam = new RiskParam();
        riskParam.setParam1("123");
        riskParam.setParam3("123");
        riskParam.setParam5("123");
        Class<RiskParam> riskParamClass = RiskParam.class;
        Field[] fields = riskParamClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (StringUtils.isBlank((String) field.get(riskParam))) {
                field.set(riskParam, "-1");
            }
        }
        System.out.println(riskParam);
    }
}
