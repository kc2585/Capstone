package gihoLee.Capstone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/community").setViewName("community");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/major").setViewName("major");
        registry.addViewController("/major-details").setViewName("major-details");
        registry.addViewController("/license").setViewName("license");
        registry.addViewController("/license-details").setViewName("license-details");
        registry.addViewController("/job").setViewName("job");
        registry.addViewController("/job-details").setViewName("job-details");
        registry.addViewController("/mypage").setViewName("mypage");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/signup").setViewName("signup");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/img/**",
                        "/css/**",
                        "/vendor/**",
                        "/js/**",
                        "/xml/**")
                .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/vendor/",
                        "classpath:/static/js/",
                        "classpath:/static/xml/");
    }
}
