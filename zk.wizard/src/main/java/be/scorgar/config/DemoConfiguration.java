package be.scorgar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { HsqlDataConfigiuration.class, WebConfiguration.class,JpaConfiguration.class })
@ComponentScan("be.scorgar.demo")
public class DemoConfiguration {

}
