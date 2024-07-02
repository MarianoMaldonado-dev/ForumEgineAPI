package com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations;

import com.alurachallenges.forohub.forumengineapi.Domain.Repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicsValidations {

    @Autowired
    private TopicoRepository topicoRepository;

    public boolean isTituloUnico(String titulo) {
        return !topicoRepository.existsByTituloAndMensaje(titulo, null);
    }

    // Otras validaciones que necesites
}