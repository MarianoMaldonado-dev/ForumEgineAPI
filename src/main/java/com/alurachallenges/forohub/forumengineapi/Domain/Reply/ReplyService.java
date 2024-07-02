package com.alurachallenges.forohub.forumengineapi.Domain.Reply;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOCreatedReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.IntegrityValidations;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.TopicoRepository;

@Service
public class ReplyService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Reply repository; //Revisar porque no encuentro coincidencias

    public DTOCreatedReply dtoCreatedReply(DTOReply dtoReply) {
        if (!userRepository.findById(DTOReply.usuario_Id()).isPresent()) {
            throw new IntegrityValidations("El usuario ${id} no se encuentra en la base de datos");
        }
        if (!topicoRepository.findById(DTOReply.topico_Id()).isPresent()) {
            throw new IntegrityValidations("El tópico ${id} no se encuentra en la base de datos");
        }

        var user = userRepository.findById(DTOReply.usuario_Id()).get();
        var topic = topicoRepository.findById(DTOReply.topico_Id()).get();
        var rVerified = new Reply(null, DTOReply.solution(), user, topic, DTOReply.creationDate());
        repository.save(rVerified);
        return new DTOCreatedReply(rVerified);
    }
}