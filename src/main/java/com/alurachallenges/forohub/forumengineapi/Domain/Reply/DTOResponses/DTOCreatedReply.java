package com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.Reply;

import java.time.LocalDateTime;

public record DTOCreatedReply(
        Long id,
        String solution,
        Long usuario_Id,
        Long topico_Id,
        LocalDateTime creationDate
) {
    public DTOCreatedReply(Reply rVerified) {
        this(rVerified.getId(),rVerified.getSolution(),rVerified.getAuthor().getId(),rVerified.getTopico().getId(),rVerified.getCreationDate());
    }
}