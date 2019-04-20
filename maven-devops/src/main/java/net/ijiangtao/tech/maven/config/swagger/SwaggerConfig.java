package net.ijiangtao.tech.maven.config.swagger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
* Swagger Config
* 
* 	通过jetty插件启动web项目(jetty:run)，并通过http://localhost:{jetty插件端口号}/swagger/index.html访问swagger首页
* 
* @author jiangtao.li
*/
@EnableSwagger
public class SwaggerConfig{

   private SpringSwaggerConfig springSwaggerConfig;

   /**
    * Required to autowire SpringSwaggerConfig
    */
   @Autowired
   public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig){
       this.springSwaggerConfig = springSwaggerConfig;
   }

   /**
    * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
    * framework - allowing for multiple swagger groups i.e. same code base
    * multiple swagger resource listings.
    */
   @Bean
   public SwaggerSpringMvcPlugin customImplementation(){
       return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
   }

   /**
    * title, description, termsOfServiceUrl, contact, license, licenseUrl
    * 
    * @return
    */
   private ApiInfo apiInfo(){
       ApiInfo apiInfo = new ApiInfo("demo", "demo with swagger", "Apps API terms of service", "jiangtao@foxmail.com", "ijiangtao All Rights Reserved.", "http://ijiangtao.github.io/");
       return apiInfo;
   }
}
