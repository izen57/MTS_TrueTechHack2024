package org.glabs.accessibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessibilityApplication {
    public static void main(String[] args) {
        // перейдите на http://localhost:8080/h2-console, чтоб управлять БД "H2"
        SpringApplication.run(AccessibilityApplication.class, args);
    }
}
