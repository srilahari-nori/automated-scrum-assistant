package org.example.service;

import org.example.entity.TechnicalDebt;
import org.example.repository.TechnicalDebtRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrumAssistantService {
    private final ChatClient chatClient;
    private final TechnicalDebtRepository repository;

    public ScrumAssistantService(ChatClient.Builder builder, TechnicalDebtRepository repository) {
        this.chatClient = builder.build();
        this.repository = repository;
    }

    public String analyzeDebt(String userQuery) {
        // NORMAL SQL: This is equivalent to 'SELECT * FROM technical_debt'
        List<TechnicalDebt> allDebt = repository.findAll();

        // Convert the SQL rows into a string context
        String context = allDebt.stream()
                .map(debt -> String.format("- %s (%s): %s",
                        debt.getIssueType(), debt.getSeverity(), debt.getDescription()))
                .collect(Collectors.joining("\n"));

        // Ask the AI to respond using the SQL context
        return chatClient.prompt()
                .system("You are a Scrum Assistant. Here is our current technical debt context:\n" + context)
                .user(userQuery)
                .call()
                .content();
    }
}