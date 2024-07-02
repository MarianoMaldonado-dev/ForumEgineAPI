package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOUpdateReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.*;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOTopic;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOTopicList;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOTopicReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.TopicoRepository;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.IntegrityValidations;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@RestController
@ResponseBody
@RequestMapping("/topics")
@SecurityRequirement(name="bearer-key")
public class TopicController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicService topicService;

    /*Metodo POST para iniciar un Topic nuevo
    *URL= localhost:666/topics/topico
    */
    @PostMapping("/topico")
    @Transactional
    public ResponseEntity postTopic(@RequestBody @Valid DTOTopic dtoTopic) throws IntegrityValidations{
        var registeredTopic = topicService.createdTopic(dtoTopic);
        return ResponseEntity.ok(registeredTopic);
    }

    /*Metodo GET para listar todos los Topics
    * URL= localhost:666/topics/topicos
    */
    @GetMapping("/topicos");
    public ResponseEntity<Page<DTOTopicList>>(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(topicoRepository.findByActivateTrue(paged).map(DTOTopicList::new));
    }

    /*Metodo PUT para actualizar un topic por id
     * URL= localhost:666/topics/{id}
    */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateTopic (@RequestBody @Valid DTOUpdateReply dtoUpdateReply){
        Topico topico = topicoRepository.getReferenceById(dtoUpdateReply.id());
        topico.updateTopic(dtoUpdateReply);
        return ResponseEntity.ok(new DTOTopicReply(
                topico.getId(),
                topico.getStatus(),
                topico.getTitle(),
                topico.getMessage(),
                topico.getAuthor().getId(),
                topico.getCourse(),
                topico.getDate()));
    }

    /*Metodo DELETE para eliminar un topic por id
     * URL= localhost:666/topics/{id}
    */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity topidDelete(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactiveTopic();
        return ResponseEntity.noContent().build();
    }

    /*Metodo GET para listar un topic por id
     * URL= localhost:666/topics/{id}
    */
    @GetMapping("/{id}")
    public ResponseEntity<DTOTopicReply> topicReply(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var topicoId = new DTOTopicReply(
                topico.getId(),
                topico.getStatus(),
                topico.getDate(),
                topico.getTitle(),
                topico.getAuthor().getId(),
                topico.getCourse(),
                topico.getMessage());
        return ResponseEntity.ok(topicoId);
    }

}