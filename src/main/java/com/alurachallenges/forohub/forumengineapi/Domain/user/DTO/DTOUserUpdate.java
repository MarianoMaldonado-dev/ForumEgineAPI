package com.alurachallenges.forohub.forumengineapi.Domain.user.DTO;

import jakarta.validation.constraints.NotNull;

public record DTOUserUpdate(
        @NotNull Long id,
        String name) {}