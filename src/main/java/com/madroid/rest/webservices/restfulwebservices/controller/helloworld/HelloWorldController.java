package com.madroid.rest.webservices.restfulwebservices.controller.helloworld;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorld(){
        return "Hello WORLD !";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello WORLD !1");
    }

    @GetMapping(path = "/hello-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(
                String.format("Hello WORLD %s", name));
    }

}
