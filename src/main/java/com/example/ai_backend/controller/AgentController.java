package com.example.ai_backend.controller;


import com.example.ai_backend.dto.GeneratedResponse;
import com.example.ai_backend.dto.PromptRequest;
import com.example.ai_backend.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/generate")
    public ResponseEntity<GeneratedResponse> generateText(@RequestBody PromptRequest promptRequest) {
        GeneratedResponse response = agentService.generateText(promptRequest);
        return ResponseEntity.ok(response);
    }
}
