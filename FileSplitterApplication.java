package com.filesplitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Split Archivos!
 */
@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class FileSplitterApplication implements WebMvcConfigurer
{
    public static void main( String[] args )
    {
        SpringApplication.run(FileSplitterApplication.class,args);
        System.out.println( "Split Archivos!" );
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

    }
}
