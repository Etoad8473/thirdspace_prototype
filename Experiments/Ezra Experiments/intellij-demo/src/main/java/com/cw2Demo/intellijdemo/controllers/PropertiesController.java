package com.cw2Demo.intellijdemo.controllers;

import com.cw2Demo.intellijdemo.services.PropertiesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PropertiesController
{
    private PropertiesService propertiesService;

    public PropertiesController(PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping(value = "/properties")
    public ResponseEntity<String> getProperties()
    {
        return new ResponseEntity<String>(propertiesService.getProperties(), HttpStatus.OK);
    }
}
