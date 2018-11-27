package com.ysu.unit1._02;

/**
 * 服务调用者
 * 没有使用@Autowired注解, 而是使用了set方法
 * 没有使用@Controller注解
 *
 * @Author bing57592
 * @Date 2018-11-27 13:33
 */
public class FunctionServiceUser {
    FunctionService functionService;

    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
