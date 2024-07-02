package com.alurachallenges.forohub.forumengineapi.Domain.user.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOUser(
        @NotBlank (message = "Su nombre de usuario es su dirección de correo electrónico")
        String username,

        @NotBlank(message = "Su contraseña debe tener entre 10 y 15 caracteres.") @Pattern(regexp = "\\d{10,15}")
        String password) {}