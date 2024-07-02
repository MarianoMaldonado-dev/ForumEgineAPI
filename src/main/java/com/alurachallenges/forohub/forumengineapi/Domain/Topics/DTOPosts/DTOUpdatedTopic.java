package com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations.Status;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DTOUpdatedTopic(
        @NotNull Long id,
        String title,
        String message,
        Status status,
        @NotNull Long usuario_Id,
        String curso,
        LocalDateTime date
) {
}