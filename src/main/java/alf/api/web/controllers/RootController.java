package alf.api.web.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RootController {
    @GetMapping("/")
    public String getRoot() {
        return "<h1> Hello , This app for service only ... </h1>";
    }
}
