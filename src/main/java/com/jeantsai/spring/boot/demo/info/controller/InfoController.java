package com.jeantsai.spring.boot.demo.info.controller;

import com.jeantsai.spring.boot.demo.info.model.AppInfo;
import com.jeantsai.spring.boot.demo.info.model.HttpInfo;
import com.jeantsai.spring.boot.demo.info.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class InfoController {

    @Autowired
    private AppInfo appInfo;



    /* """
    console.log("Received request from " + req.connection.remoteAddress)
    rsp.setHeader('Content-Type', 'text/plain; charset=utf-8')
    rsp.writeHead(200)
    rsp.end(prompt + "\n===============================" +
        "\nVersion: " + demoVersion +
        "\nLocal Host: " +  os.hostname +
        "\nRemote Address: " + req.connection.remoteAddress +
        "\nX-Forwarded-Host: " + req.headers['x-forwarded-host'] +
        "\nX-Forwarded-For: " + req.headers['x-forwarded-for'] +
        "\nX-Real-IP: " + req.headers['x-real-ip']
    """ */

    @RequestMapping("/info")
    public HttpEntity<Info> info(
            HttpServletRequest request,
            @RequestHeader Map<String, String> headers,
            @RequestParam Map<String,String> parameters
    ) {
        HttpInfo httpInfo = new HttpInfo(request, headers, parameters);
        Info info = new Info(appInfo, httpInfo);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
