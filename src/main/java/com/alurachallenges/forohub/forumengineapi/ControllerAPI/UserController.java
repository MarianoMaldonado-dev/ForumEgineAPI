package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.model.User;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserReply;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserUpdate;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name="bearer-key")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /*
    * Implementado del Metodo GET
    * Obtenemos la lista de usarios
    * URL: localhost:666/user/usuarios
    */
    @GetMapping("usarios")
    public ResponseEntity<Page<DTOUserList>> usersList(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(userRepository.findByActiveTrue(paged).map(DTOUserList::new));
    }

    /*
    * Establecer el Metodo PUT
    * Para actualizar un usuaio po id
    * URL: localhost:666/user/{id}
    */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity UserUpdate (@RequestBody @Valid DTOUserUpdate dtoUserUpdate){
        User user = userRepository.getReferenceById(DTOUserUpdate.id());
        user.userUpdate(DTOUserUpdate);
        return ResponseEntity.ok(new DTOUserUpdate(user.getId(),user.getName()));
    }

    /*
     * Establecer el Metodo DELETE
     * Para eliminar un usuaio po id
     * URL: localhost:666/user/{id}
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity userDelete(@PathVariable Long id){
        User user = userRepository.getReferenceById(id);
        user.userDesactive();
        return ResponseEntity.noContent().build();
    }

    /*
     * Uso del Metodo GET
     * Para obtener un usuario por id
     * URL: localhost:666/user/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<DTOUserReply> userRegister(@PathVariable Long id){
        User user = userRepository.getReferenceById(id);
        var userDetail = new DTOUserReply(user.getId(), user.getName());
        return ResponseEntity.ok(userDetail);
    }
}
