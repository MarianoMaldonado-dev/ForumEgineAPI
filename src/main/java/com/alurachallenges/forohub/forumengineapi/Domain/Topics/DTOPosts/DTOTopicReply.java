package com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.*;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations.Status;

import java.time.LocalDateTime;

public record DTOTopicReply (
        Long id,
        String title,
        String message,
        Status status,
        Long usuario_Id,
        String curso,
        LocalDateTime date){
    public DTOTopicReply (Topico topicoId) {
        this(
                topicoId.getId(),
                topicoId.getTitle(),
                topicoId.getMessage(),
                topicoId.getStatus(),
                topicoId.getAuthor().getId(),
                topicoId.getCourse(),
                topicoId.getDate());
    }
}
