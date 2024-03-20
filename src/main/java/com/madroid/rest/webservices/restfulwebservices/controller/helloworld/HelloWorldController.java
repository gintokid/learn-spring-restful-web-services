package com.madroid.rest.webservices.restfulwebservices.controller.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorld() {
        return "Hello WORLD !";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello WORLD !1");
    }

    @GetMapping(path = "/hello-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(
                String.format("Hello WORLD %s", name));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-i18n")
    public String helloWorldI18N() {

        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale.toLanguageTag());
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
    }

}
