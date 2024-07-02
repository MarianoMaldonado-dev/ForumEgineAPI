package com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations.Status;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DTOTopic(
        @NotNull(message = "El título especificado ya existe. Porfavor, ingrese otro")
        String title,

        @NotNull(message = "Sea educado y amable al escribir su mensaje. Usted dispone de 700 caracteres, mantenga el respeto hacia los demás")
        String message,

        @NotNull(message = "Seleccione estado ´ACTIVO´ o ´INACTIVO´")
        Status status,

        @NotNull(message = "Ingrese su ID de autor")
        Long usuario_Id,

        @NotNull(message = "Especifique el curso de tu publicación")
        String curso,
        LocalDateTime date) { }