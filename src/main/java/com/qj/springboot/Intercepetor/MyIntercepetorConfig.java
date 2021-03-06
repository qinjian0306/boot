package com.qj.springboot.Intercepetor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyIntercepetorConfig extends WebMvcConfigurerAdapter {

    protected static final Logger logger = LoggerFactory.getLogger(MyIntercepetorConfig.class);

    /**
     * 注入自定义的拦截器对象
     * @return
     */
    @Bean
    public MyIntercepetor getMyIntercepetor(){
        return new MyIntercepetor();
    }

    /**
     * 静态资源放行
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/**");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/**");
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/**");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/**");
        super.addResourceHandlers(registry);
    }

    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(getMyIntercepetor());

        // 排除配置
        interceptor.excludePathPatterns("/login");
        interceptor.excludePathPatterns("/register");

        // 拦截配置
        interceptor.addPathPatterns("/*");
    }
}