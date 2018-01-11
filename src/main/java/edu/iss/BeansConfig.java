package edu.iss;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"edu.iss.repository", "edu.iss.service"})
public class BeansConfig {
}
