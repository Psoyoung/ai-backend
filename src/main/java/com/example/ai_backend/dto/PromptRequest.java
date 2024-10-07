package com.example.ai_backend.dto;

import lombok.Data;

@Data
public class PromptRequest {
    private String prompt;
    private Integer maxTokens;
    private Double temperature;
}
