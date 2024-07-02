package com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses;

import java.time.LocalDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOReply(
        @NotBlank
        String solution,

        @NotNull
        @Valid
        Long usuario_Id,

        @NotNull
        @Valid
        Long topico_Id,
        LocalDateTime creationDate) {
}