package com.yao.admin.web_admin.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by yaozwsq on 2019/12/5 16:47.
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
            converters.add(gsonConverter);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.of(30, DataUnit.MEGABYTES)); //MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(30720,DataUnit.KILOBYTES));//KB
        return factory.createMultipartConfig();
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/admin/login/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

//    @Bean
//    public AdminInterceptor adminInterceptor(){
//        return new AdminInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(adminInterceptor())
//                .excludePathPatterns("/admin/login/**")
//                .excludePathPatterns("/admin/utils/**")
//                .excludePathPatterns("/admin/error/**")
//                .excludePathPatterns("/admin/test/**")
//                .excludePathPatterns("/admin/custinfo/**")
//                .addPathPatterns("/admin/**");
//        super.addInterceptors(registry);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /*@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        return resolver;
    }*/

}
