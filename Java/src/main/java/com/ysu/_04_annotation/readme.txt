如何自定义注解:
参照@SuppressWarnings
1. 自定义注解: public @interface MyAnnotation {
   }

2. 元注解: 用于修饰现有注解的注解.
    Retention:  指明所修饰的注解的生命周期.
        Retention.SOURCE    :   编译的时候被抛弃
        Retention.CLASS     :   被保留在class文件中, 但不会在运行的时候保留(默认是这个)
        Retention.RUNTIME   :   在字节码文件中有, 同时在运行的时候也会加载到内存中. 只有这种情况, 才会被反射读取.
    Target:     指定注解可以修饰的结构.
        TYPE                :   类型
        FIELD               :   属性
        METHOD              :   方法
        PARAMETER           :   形参
        CONSTRUCTOR         :   构造器
        LOCAL_VARIABLE      :   局部变量

    Documented: 所修饰的注解是否可以被javadoc所解析.

    Inherited:: 指明所修饰的注解是否具有继承性.