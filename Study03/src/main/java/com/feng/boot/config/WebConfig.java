package com.feng.boot.config;

import com.feng.boot.converter.MymessageConverter;
import com.feng.boot.entity.Pet;
import com.mysql.cj.util.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类很重要，提升自己的，一定要反复看
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

//
//    //第一种
//    //开启矩阵变量
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper=new UrlPathHelper();
//        //设置为false就可以生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }


    //第二种
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper=new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //自定义请求类型转换器！！！
            //一定要记住
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String s) {
                        //   啊嘛，2----->Pet类型
                        if(!StringUtils.isNullOrEmpty(s)){
                            String[] split = s.split(",");
                            Pet pet=Pet.builder().
                                    name(split[0]).
                                    age(split[1]).
                                    build();
                            return pet;
                        }
                        return null;
                    }
                });
            }

            //自定义输出类型格式
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new MymessageConverter());
            }

            //浏览器的方式自定义接受数据类型
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypeMap=new HashMap<>();
                mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("XML",MediaType.APPLICATION_XML);
                mediaTypeMap.put("sun",MediaType.parseMediaType("application/x-sun"));

                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy=new ParameterContentNegotiationStrategy(mediaTypeMap);

                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy));

            }
        };
    }
}
