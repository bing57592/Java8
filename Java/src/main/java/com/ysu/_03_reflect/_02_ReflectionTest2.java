package com.ysu._03_reflect;

import com.ysu._03_reflect.bean.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * created by bing57592
 * 2018-10-21 02:16
 */
public class _02_ReflectionTest2 {


    /**
     * 获取构造器
     *
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
        //注意: int.class != Integer.class
        constructor.setAccessible(true);
        Person hello = constructor.newInstance("hello", 123);
        System.out.println(hello);
    }

    /**
     * 通过反射调取对象指定的方法
     *
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        Class<Person> personClass = Person.class;
        Field nationField = personClass.getField("name");
        Person person = personClass.newInstance();
        nationField.set(person, "日本");

        Method display = personClass.getDeclaredMethod("display", String.class);
        display.setAccessible(true);
        String result = (String) display.invoke(person, "中国");
        System.out.println(result);

    }

    //获取运行时类所实现的接口
    @Test
    public void test5() {
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }
    }


    @Test
    public void testGetSuperClassGenericParam() throws Exception {
        String className = "com.atguigu.java1.Person";
        className = "com.atguigu.java2.CustomerDAO";
        className = "com.atguigu.java2.OrderDAO";
        String superClassGenericParam = getSuperClassGenericParam(className);
        System.out.println(superClassGenericParam);
    }

    //体会反射的动态性
    public String getSuperClassGenericParam(String className) throws Exception {

        Class clazz = Class.forName(className);
        Type genericSuperClass = clazz.getGenericSuperclass();
        ParameterizedType paramsType = (ParameterizedType) genericSuperClass;
        Type[] arguments = paramsType.getActualTypeArguments();
        return ((Class) arguments[0]).getName();

    }

    //获取运行时类的带泛型的父类的泛型
    //逻辑性代码     功能性代码
    @Test
    public void test_generic_superclass2() {
        Class clazz = Person.class;

        Type genericSuperClass = clazz.getGenericSuperclass();
        ParameterizedType paramsType = (ParameterizedType) genericSuperClass;
        Type[] arguments = paramsType.getActualTypeArguments();
        System.out.println(((Class) arguments[0]).getName());

    }

    //获取运行时类的带泛型的父类
    @Test
    public void test_generic_superclass1() {
        Class clazz = Person.class;

        Type genericSuperClass = clazz.getGenericSuperclass();
        System.out.println(genericSuperClass);
    }

    //获取运行时类的父类
    @Test
    public void test_superclass() {
        Class clazz = Person.class;

        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        Class superClass1 = superClass.getSuperclass();
        System.out.println(superClass1);
    }

    //获取运行时类所属的包
    @Test
    public void test_package() {
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /**
     * @throws Exception
     */
    @Test
    public void test_constructors() throws Exception {
        Class clazz = Person.class;

        //getConstructors():获取运行时类中声明为public权限的构造器
        Constructor[] cons = clazz.getConstructors();
        for (Constructor c : cons) {
            System.out.println(c);
        }

        System.out.println("*********************");
        //getDeclaredConstructors():获取运行时类中所有的构造器，不论权限大小
        Constructor[] cons1 = clazz.getDeclaredConstructors();
        for (Constructor c : cons1) {
            System.out.println(c);
        }

    }

    /**
     * 注解
     * 权限修饰符 返回值类型 方法名(参数类型1 参数名1,参数类型2 参数名2,...) throws 异常类型1,异常类型2,...{}
     */
    @Test
    public void test_methods2() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);

        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // 1.注解
            Annotation[] annos = m.getAnnotations();
            for (Annotation a : annos) {
                System.out.println(a);
            }
            // 2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            // 3. 返回值类型
            Class returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            // 4.方法名
            System.out.print(m.getName() + "(");

            // 5.(形参类型 变量名,....)
            Class[] paras = m.getParameterTypes();
            for (int i = 0; i < paras.length; i++) {
                if (i == paras.length - 1) {
                    System.out.print(paras[i].getName() + " args_" + i);
                    break;
                }
                System.out.print(paras[i].getName() + " args_" + i + ",");
            }

            System.out.print(")");

            // 6. 异常类型
            Class[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length != 0) {
                System.out.print(" throws ");
            }

            for (Class c : exceptionTypes) {
                System.out.print(c.getName() + "\t");
            }

            System.out.println();
        }
    }

    /**
     * 获取运行时类的所有方法
     */
    @Test
    public void test_methods1() throws Exception {

        Class clazz = Person.class;

        // getMethods():获取当前运行时类，及其所有的父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("*********************");
        // getDeclaredMethods():获取当前运行时类中声明的所有的方法，不论权限的大小
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m);
        }
    }

    /**
     * 获取运行时类的属性
     *
     * @throws Exception
     */
    @Test
    public void test_fields() throws Exception {
        Class<com.ysu._03_reflect.bean.Person> clazz = com.ysu._03_reflect.bean.Person.class;
        Field[] fields1 = clazz.getFields(); // 获取运行时类及其父类中声明为public的属性
        for (Field field : fields1) {
            System.out.println(field.getType()); // java.lang.String
            System.out.println(field.getName()); // name
        }
        System.out.println("-------");
        Field[] fields2 = clazz.getDeclaredFields(); // 获取运行时类中声明的所有属性, 不论权限大小
        for (Field field : fields2) {
            System.out.println(field);
        }
    }
}
