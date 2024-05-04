package com.example.testspringapr24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AppController {

    @Autowired
    CredentialRepository credentialRepository;

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody Credential credential){
        credentialRepository.save(credential);
        return ResponseEntity.ok("New user signup");
    }
}
