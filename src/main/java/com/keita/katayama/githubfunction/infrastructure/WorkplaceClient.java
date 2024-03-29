package com.keita.katayama.githubfunction.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class WorkplaceClient {

    @Autowired
    RestTemplate restTemplate;

    public WorkplaceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendFunction(String url) {
        restTemplate.postForEntity(URI.create(url), String.class, String.class);
    }

}
