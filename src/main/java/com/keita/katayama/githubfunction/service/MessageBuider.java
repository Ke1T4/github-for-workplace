package com.keita.katayama.githubfunction.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

@Component
public class MessageBuider {

    public String createMessage(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        StringBuilder stringBuilder = new StringBuilder();

        if (Objects.nonNull(node.get("commit"))) {
            stringBuilder.append(node.get("commits").get(0).get("committer").get("username") + "さんがコミットしました\n");
            stringBuilder.append("コメント：" + node.get("commits").get(0).get("message") + "\n");
            stringBuilder.append(URLEncoder.encode("URL：" + node.get("commits").get(0).get("url").toString(), "UTF-8"));
        }

        return stringBuilder.toString();
    }
}