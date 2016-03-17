package com.rudyvissers.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.rudyvissers.example2.model.Greeting;

@RestController
public class HelloController {
	
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
    	Greeting greeting = this.restTemplate.getForObject("http://exampleeureka2/hello-world", Greeting.class);
    	String response = "Greetings from Spring Boot! "
    			+ (greeting == null ? "nothing was read from example 2!" : "id:" + greeting.getId() + " content:" + greeting.getContent()); 
        return response;
    }
}
