package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//Spring + aspectJ(AOP)

//hey spring i want to integrate with AspectJ

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {"com.demo"})
public class AppConfig {

}
