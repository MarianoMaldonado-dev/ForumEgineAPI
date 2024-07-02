package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.*;
import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOCreatedReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOReplyList;
import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOUpdateReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.TopicoRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Repository.*;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.IntegrityValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@ResponseBody
@RequestMapping("/reply")
@SecurityRequirement(name="bearer-key")
public class ReplyController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository repository;

/*
* Metodo POST para registrar una respuesta nueva
* URL: localhost:666/reply
*/
    @PostMapping
    @Transactional
    public ResponseEntity replyRegister (@RequestBody @Valid DTOReply dtoReply) throws IntegrityValidations{
        var replyRegister = replyService.DTOCreatedReply(DTOReply);
        return ResponseEntity.ok(replyRegister);
    }

    /*
     * Metodo GET para ver todas las respuestas
     * URL: localhost:666/reply/respuestas
     */
    @GetMapping("/respuestas")
    public ResponseEntity<Page<DTOReplyList>> replyList(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(repository.findByActiveTrue(paged).map(DTOReplyList::new));
    }

    /*
     * Metodo PUT para Actualizar una respuesta por id
     * URL: localhost:666/reply/{id}
     */
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity updateReply(@RequestBody @Valid DTOUpdateReply dtoUpdateReply){
        Reply reply = repository.getReferenceById(dtoUpdateReply.id());
        reply.updateReply(dtoUpdateReply);
        return ResponseEntity.ok(new DTOCreatedReply(
                reply.getId(),
                reply.getSolution(),
                reply.getTopico().getId(),
                reply.getAuthor().getId(),
                reply.getCreationDate()));
    }

    /*
     * Metodo DELETE para eliminar una respuesta por id
     * URL: localhost:666/reply/{id}
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity replyDelete(@PathVariable Long id){
        Reply reply = repository.getReferenceById(id);
        reply.deleteReply();
        return ResponseEntity.noContent().build();
    }

    /*
     * Metodo GET para obtener una respuesta por id
     * URL: localhost:666/reply/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity <DTOCreatedReply> createdReply(@PathVariable Long id){
        Reply reply = repository.getReferenceById(id);
        var registerReply = new DTOCreatedReply(
                reply.getId(),
                reply.getSolution(),
                reply.getTopic().getId(),
                reply.getAuthor().getId(),
                reply.getCreationDate());
        return ResponseEntity.ok(registerReply);
    }
}
























