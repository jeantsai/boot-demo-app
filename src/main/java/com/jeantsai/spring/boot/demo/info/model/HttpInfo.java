package com.jeantsai.spring.boot.demo.info.model;

import org.springframework.hateoas.ResourceSupport;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class HttpInfo extends ResourceSupport {

    private static final String MSG_UNKNOWN_LOCAL_HOST = "Unknown local host";

    private String localhost;

    private String localAddr;
    private String localName;
    private int localPort;

    private String remoteAddr;
    private String remoteHost;
    private int remotePort;

    private Map<String, String> requestHeaders;
    private Map<String,String> requestParameters;

    public HttpInfo(
            HttpServletRequest request,
            Map<String, String> headers,
            Map<String,String> parameters
    ) {
        try {
            this.localhost = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            this.localhost = MSG_UNKNOWN_LOCAL_HOST;
        }

        this.localAddr = request.getLocalAddr();
        this.localName = request.getLocalName();
        this.localPort = request.getLocalPort();

        this.remoteAddr = request.getRemoteAddr();
        this.remoteHost = request.getRemoteHost();
        this.remotePort = request.getRemotePort();
        this.requestHeaders = headers;
        this.requestParameters = parameters;
    }


    public String getLocalhost() {
        return localhost;
    }

    public String getLocalAddr() {
        return localAddr;
    }

    public String getLocalName() {
        return localName;
    }

    public int getLocalPort() {
        return localPort;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public Map<String, String> getRequestParameters() {
        return requestParameters;
    }
}
