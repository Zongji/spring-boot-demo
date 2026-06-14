package com.demo.boot3;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    public String test(HttpServletRequest httpRequest) {
        log.info(httpRequest.toString());
        log.info("djiedjiejdiejidjei");
        return "ok," + LocalDateTime.now().toString();
    }

    @GetMapping("test3")
    public String test3() {
        String url = "http://localhost:8083/demo-boot3/test";
        String result = restTemplate.getForObject(url, String.class);
        log.info("调用外部接口返回结果: {}", result);
        return result;
    }
}
