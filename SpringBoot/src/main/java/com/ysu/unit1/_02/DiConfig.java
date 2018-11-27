package com.ysu.unit1._02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bing57592
 * @Date 2018-11-27 13:36
 */
@Configuration
public class DiConfig {
    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    FunctionServiceUser functionServiceUser() {
        FunctionServiceUser user = new FunctionServiceUser();
        user.setFunctionService(functionService());
        return user;
    }

//    /**
////     * 与上面相比, 这里是另一种Bean注入的方式, FunctionService作为形参.
////     * 只要IOC容器中存在这个类的对象, 则会在方法的声明中注入这个bean.
////     * 如果形参锁表示的类型, 没有被Spring接管的话. 编译不通过. NoSuchBean-EmptyService
////     *
////     * @param functionService 与这个Bean有依赖关系的(其他的)Bean
////     * @return
////     */
////    @Bean
////    FunctionServiceUser functionServiceUser(FunctionService functionService, EmptyService emptyService) {
////        System.out.println(emptyService);
////        FunctionServiceUser user = new FunctionServiceUser();
////        user.setFunctionService(functionService);
////        return user;
////    }


}
