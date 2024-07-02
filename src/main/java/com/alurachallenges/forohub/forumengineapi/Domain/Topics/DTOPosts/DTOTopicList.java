package com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;

import java.time.LocalDateTime;

public record DTOTopicList(
        Long id,
        String title,
        String message,
        Status status,
        Long usuario_Id,
        String curso,
        LocalDateTime date
) {
    public DTOTopicLists dtoTopicLists (Topico topico){
        this(
                topico.getId(),
                topico.getTitle(),
                topico.getMessage(),
                topico.getStatus(),
                topico.getAuthor().getId(),
                topico.getCourse(),
                topico.getDate());

    }
}