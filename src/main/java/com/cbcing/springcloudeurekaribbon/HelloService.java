package com.cbcing.springcloudeurekaribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        return restTemplate.getForEntity("http://TEST-EUREKA-SERVICE-PROVIDER/hello", String.class).getBody();
    }

    public String helloFallback() {
        return "Error.";
    }

}
