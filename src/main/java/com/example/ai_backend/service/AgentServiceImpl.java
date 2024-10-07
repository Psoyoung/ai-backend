package com.example.ai_backend.service;

import com.example.ai_backend.dto.GeneratedResponse;
import com.example.ai_backend.service.AgentService;
import com.example.ai_backend.dto.GeneratedResponse;
import com.example.ai_backend.dto.PromptRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentServiceImpl implements AgentService {

    private final RestTemplate restTemplate;

    @Value("${agent.url}")
    private String agentUrl;

    public AgentServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public GeneratedResponse generateText(PromptRequest promptRequest) {
        String url = agentUrl + "/generate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PromptRequest> requestEntity = new HttpEntity<>(promptRequest, headers);

        ResponseEntity<GeneratedResponse> responseEntity = restTemplate.postForEntity(
                url, requestEntity, GeneratedResponse.class);

        return responseEntity.getBody();
    }
}
