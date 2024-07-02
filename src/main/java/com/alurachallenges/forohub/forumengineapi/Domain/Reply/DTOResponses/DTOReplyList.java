package com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.Reply;

import java.time.LocalDateTime;

public record DTOReplyList(Long id,
                           String solution,
                           Long usuario_Id,
                           Long topico_Id,
                           LocalDateTime creationDate) {
    public DTOReplyList(Reply reply){
        this(reply.getId(),
                reply.getSolution(),
                reply.getTopic().getId(),
                reply.getAuthor().getId(),
                reply.getCreationDate());
    }
}