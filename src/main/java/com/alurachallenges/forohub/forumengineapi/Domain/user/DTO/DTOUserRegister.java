package com.alurachallenges.forohub.forumengineapi.Domain.user.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOUserRegister(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank (message = "Su nombre de usuario es su correo electrónico con el cual se registró")
        String username,

        @NotBlank(message = "Escriba su contraseña entre 10 y 15 caracteres.") @Pattern(regexp = "\\d{10,15}")
        String password) {}