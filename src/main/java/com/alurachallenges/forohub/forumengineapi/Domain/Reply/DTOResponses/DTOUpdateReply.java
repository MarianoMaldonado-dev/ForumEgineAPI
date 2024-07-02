package com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DTOUpdateReply(
        @NotNull Long id,
        String solution,
        @NotNull Long usuario_Id,
        @NotNull Long topico_Id,
        LocalDateTime creationDate){}