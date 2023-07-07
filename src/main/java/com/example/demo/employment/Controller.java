package com.example.demo.employment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class Controller  {
   // One syntax to implement a
    // GET method
    @GetMapping("/")
    public String home()
    {
        String str
                = "<html><body><font color=\"green\">"
                + "<h1>WELCOME TEST WWW</h1>"
                + "</font></body></html>";
        return str;
    }

    // Another syntax to implement a
    // GET method
    @RequestMapping(
            method = { RequestMethod.GET },
            value = { "/info1" })

    public String info()
    {
        String str2
                = "<html><body><font color=\"green\">"
                + "<h2>SPRING BOOT RUN"+
                "</h2></font></body></html>";
        return str2;
    }
}
