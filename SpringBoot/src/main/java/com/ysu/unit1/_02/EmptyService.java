package com.ysu.unit1._02;

/**不被容器接管的Bean, 作为形参传入配置类中, 是否会发生异常情况
 * @Author bing57592
 * @Date 2018-11-27 13:43
 */
public class EmptyService {
    public EmptyService() {
        System.out.println("init EmptyService");
    }
}
