package com.cw2Demo.intellijdemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration
{
    @Value("${server.port}")
    private String serverPort;

    public String getServerPort() {
        return serverPort;
    }

    public String getIntegrationServiceUrl() {
        return integrationServiceUrl;
    }

    @Value("${integration.service.url}")
    private String integrationServiceUrl;
}
