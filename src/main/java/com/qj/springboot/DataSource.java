package com.qj.springboot;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ToString
//@Component
@ConfigurationProperties(prefix = "db")
public class DataSource {
    private String username;
    private String password;
    private String url;
    private String driverClassName;
}
