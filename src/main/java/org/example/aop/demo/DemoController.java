package org.example.aop.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    @GetMapping
    public String hello() {
        return " HELLO JAVA ";
    }

    @GetMapping("/sum/{a}/{b}")
    public Integer sum(@PathVariable("a") Integer a,
                       @PathVariable("b") Integer b) {
        return a + b;
    }
}
