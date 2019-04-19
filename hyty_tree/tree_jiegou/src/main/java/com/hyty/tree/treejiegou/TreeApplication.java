package com.hyty.tree.treejiegou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by czy on 2019/3/22.
 */
@SpringBootApplication
@EnableSwagger2
public class TreeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TreeApplication.class, args);
        System.out.println("success!!!!已启动项目！！！！");
        System.out.println("/******************************************************************************************************************************************************************************/");
    }

//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//                .maxAge(3600);
//    }
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hyty.tree.treejiegou.controller")) //自己的包名
//                .paths(PathSelectors.any())
//                .build();
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("集团组织人员架构权限")
//                .description("restful风格")
//                .termsOfServiceUrl("")
//                .version("1.0")
//                .build();
//    }
}
