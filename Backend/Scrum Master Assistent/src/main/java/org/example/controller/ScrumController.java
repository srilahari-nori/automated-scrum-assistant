package org.example.controller;

import org.example.service.ScrumAssistantService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/scrum")
@CrossOrigin(origins = "http://localhost:3000")
public class ScrumController {
    private final ScrumAssistantService service;

    public ScrumController(ScrumAssistantService service) {
        this.service = service;
    }

    @GetMapping("/chat")
    public Map<String, String> chat(@RequestParam String message) {
        return Map.of("reply", service.analyzeDebt(message));
    }
}