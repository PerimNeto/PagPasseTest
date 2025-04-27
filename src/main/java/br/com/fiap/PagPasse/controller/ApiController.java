package br.com.fiap.PagPasse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello from a public endpoint!";
    }

    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello from a private endpoint!";
    }
}
