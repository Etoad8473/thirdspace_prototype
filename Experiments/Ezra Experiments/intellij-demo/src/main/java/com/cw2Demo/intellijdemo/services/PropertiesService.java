package com.cw2Demo.intellijdemo.services;

import com.cw2Demo.intellijdemo.configuration.AppConfiguration;
import org.springframework.stereotype.Service;

@Service
public class PropertiesService
{
    AppConfiguration appConfiguration;

    public PropertiesService(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public String getProperties() {
        return appConfiguration.getIntegrationServiceUrl();
    }
}
