package com.jeantsai.spring.boot.demo.info.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;

public class Info extends ResourceSupport {

    private final AppInfo appInfo;

    private final HttpInfo httpInfo;

    @JsonCreator
    public Info(
            @JsonProperty AppInfo appInfo,
            @JsonProperty HttpInfo httpInfo
    ) {
        this.appInfo = appInfo;
        this.httpInfo = httpInfo;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public HttpInfo getHttpInfo() {
        return httpInfo;
    }
}
