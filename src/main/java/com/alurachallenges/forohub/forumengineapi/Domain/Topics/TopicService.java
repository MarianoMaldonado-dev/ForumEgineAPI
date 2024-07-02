package com.alurachallenges.forohub.forumengineapi.Domain.Topics;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOTopic;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOTopicReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.TopicoRepository;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.IntegrityValidations;

@Service
public class TopicService {
    @Autowired
    private TopicoRepository topicRepository;
    @Autowired
    private UserRepository userRepository;

    public DTOTopicReply topicoCreado(DTOTopic dtoTopic){
        if (!userRepository.findById(dtoTopic.usuario_Id()).isPresent()){
            throw new IntegrityValidations("Este ID de usuario no está registrado en la base de datos.");
        }
        var title= dtoTopic.title();
        if (title != null && topicRepository.existsByTitleIgnoreCase(title)){
            throw new IntegrityValidations("Este título ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        String message = dtoTopic.message();
        if (message != null && topicRepository.existsByMessageIgnoreCase(message)){
            throw new IntegrityValidations("Este mensaje ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        var user = userRepository.findById(dtoTopic.usuario_Id()).get();
        var idTopic= new Topico(null,title,message,dtoTopic.date(),dtoTopic.status(),user,dtoTopic.curso());
        topicRepository.save(idTopic);
        return new DTOTopicReply(idTopic);
    }
}