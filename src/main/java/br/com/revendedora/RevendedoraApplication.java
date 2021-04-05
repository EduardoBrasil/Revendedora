package br.com.revendedora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan({"br.com.revendedora.controller"})
@EntityScan("br.com.revendedora.model")
@SpringBootApplication
public class RevendedoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevendedoraApplication.class, args);
    }

}
