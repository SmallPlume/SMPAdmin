package cn.smp.support;

import cn.smp.support.interceptor.MyInterceptor;
import cn.smp.support.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author XIAOYU.FANG
 * @date 2018/06/08
 */
@Configuration
public class WebHandler extends WebMvcConfigurationSupport {

    @Bean
    public HandlerInterceptor getTokenInterceptor() {
        return new TokenInterceptor();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // super.addInterceptors(registry);
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getTokenInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        // 排除拦截
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/login", "/logout");
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("index").setViewName("home/index");
    }
}
