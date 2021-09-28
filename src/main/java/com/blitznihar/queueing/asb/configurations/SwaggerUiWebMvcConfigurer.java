package com.blitznihar.queueing.asb.configurations;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
    private final String baseUrl;
  
    public SwaggerUiWebMvcConfigurer(String baseUrl) {
      this.baseUrl = baseUrl;
    }
  
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.
          addResourceHandler(StringUtils.trimTrailingCharacter(this.baseUrl, '/') + "/swagger-ui/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
          .resourceChain(false);
    }
  
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController(baseUrl + "/swagger-ui/")
          .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
    }
  }
