package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserRegister;
import com.alurachallenges.forohub.forumengineapi.Domain.model.User;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserRepository usuerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
     * Uso del método POST para crear un nuevo registro
     * Como buena práctica, se implementa un manejo de excepciones.
     * localhost:666/register
    */
    @PostMapping
    @Transactional
    public ResponseEntity userRegister(@RequestBody @Valid DTOUserRegister dtoUserRegister, UriComponentsBuilder uriComponentsBuilder){
        try{
            User user = usuerRepository.save(new User(DTOUserRegister), bCryptPasswordEncoder);
        DTOUserReply dtoUserReply = new DTOUserReply(user.getId(), user.getName());
        URI url = uriComponentsBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri();
        } catch (ConstraintViolationException exception){
            return ResponseEntity.badRequest().body("Response Validation Failed: "+exception.getMessage());
        }
    }
}