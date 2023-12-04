package com.restwebservice.RestWebService.HelloWorld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {
    private final MessageSource messageSource;
    public HelloWorld(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }
    @GetMapping("/hello/i18n")
    public String sayHelloInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.night.message", null,  "default Message", locale);
    }
}
