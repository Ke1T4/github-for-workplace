package com.keita.katayama.githubfunction.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keita.katayama.githubfunction.infrastructure.WorkplaceClient;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping
@RestController
public class GitHubController {
    private final WorkplaceClient workplaceClient;

    public GitHubController(WorkplaceClient workplaceClient) {
        this.workplaceClient = workplaceClient;
    }

    @PostMapping("/github")
    public void postFunction(
            @RequestBody String json,
            @RequestParam("token") String token) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);

        String url = "https://graph.facebook.com/v3.0/group/feed?messege=" + json + "&access_token=" + token;
        workplaceClient.sendFunction(url);
    }

    @GetMapping
    public String testFunction() {
        String text = "Hello World!!";
        return text;
    }

}
