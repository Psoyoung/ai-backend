package com.example.ai_backend.service;

import com.example.ai_backend.dto.GeneratedResponse;
import com.example.ai_backend.dto.PromptRequest;

public interface AgentService {
    GeneratedResponse generateText(PromptRequest promptRequest);
}
