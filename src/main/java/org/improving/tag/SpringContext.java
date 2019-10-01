package org.improving.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

/*
Created a new class called Spring that will alow us to figure the spring framework
 */
@Configuration // this class will be configuration for spring
@ComponentScan("org.improving.tag")
public class SpringContext {
    @Bean
    public Random getRandom() {
        return new Random();
    }
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

}
