package com.telezone.framework.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@ConfigurationProperties(prefix="com.telezone")
@PropertySource(value="classpath:resource.properties")
public class Resource implements Serializable{

    private String openpaltform;
    private String url;

    public String getOpenpaltform() {
        return openpaltform;
    }

    public void setOpenpaltform(String openpaltform) {
        this.openpaltform = openpaltform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
