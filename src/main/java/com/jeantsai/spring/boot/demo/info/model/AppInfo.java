package com.jeantsai.spring.boot.demo.info.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class AppInfo extends ResourceSupport {

    @Value("${app.name:Demo App Name}")
    private String name;

    @Value("${app.version:Demo App Version}")
    private String version;

    @JsonCreator
    public AppInfo() {
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
