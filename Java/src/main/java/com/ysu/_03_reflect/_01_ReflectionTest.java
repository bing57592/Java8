package com.ysu._03_reflect;

import com.ysu._00_common.bean.Person;
import com.ysu._00_common.bean.RiskParam;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * created by bing57592
 * 2018-10-20 22:10
 */
public class _01_ReflectionTest {
    private static String CLASS_NAME = "com.ysu._00_bean.Person";


    private static String LOCAL_CLASS = "com.ysu._03_reflect.bean.Person";


    /**
     * 创建运行时类的对象
     */
    @Test
    public void test6() throws Exception {
        Class<Person> clazz = (Class<Person>) Class.forName(CLASS_NAME);
        clazz.newInstance();// 本质上就是调用空参构造器
    }

    /**
     * 如何获取Class的实例
     * 获取Class实例的四种方式
     */
    @Test
    public void test5() throws Exception {
        Class class1 = Person.class;

        Person person = new Person();
        Class<? extends Person> class2 = person.getClass();

        Class<?> class3 = Class.forName(CLASS_NAME);

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> class4 = classLoader.loadClass(CLASS_NAME);
    }

    /**
     * 使用类加载器获取配置文件信息
     */
    @Test
    public void test4() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = _01_ReflectionTest.class.getClassLoader().
                getResourceAsStream("properties/jdbc.properties");// jdbc.properties默认读取根目录下
        properties.load(resourceAsStream);
        String name = properties.getProperty("name");
        String cup = properties.getProperty("cup");
        System.out.println(name + " " + cup);
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
     * 没有使用反射的时候.
     */
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.name = "HRR";
        p1.show();
    }


}
