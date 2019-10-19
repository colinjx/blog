package cn.jx.blog.config;


import cn.jx.blog.common.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig {

    @Value("${my.interceptor.flag}")
    private boolean interceptor_flag;

    @Bean
    public WebMvcConfigurer myWebMvcConfig(){
        return new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("redirect:/manager");
                registry.addViewController("/manager").setViewName("/manager/login");
                registry.addViewController("/manager/empty").setViewName("/manager/empty");
                registry.addViewController("/manager/unicode").setViewName("/manager/unicode");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                if(interceptor_flag){
                    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/manager/**")
                            .excludePathPatterns("/manager/login","/manager");
                }
            }
        };


    }
}
