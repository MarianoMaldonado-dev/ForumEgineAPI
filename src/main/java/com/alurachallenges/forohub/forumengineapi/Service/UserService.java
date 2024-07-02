package com.alurachallenges.forohub.forumengineapi.Service;

import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserRegister;
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.UserRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.user.DTO.DTOUserUpdate;
import com.alurachallenges.forohub.forumengineapi.Domain.user.User;
import com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController.IntegrityValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void UserRegister(DTOUserRegister dtoUserRegister) {
        if (userRepository.existsByEmail(dtoUserRegister.email())) {
            throw new IntegrityValidations("El email ingresado ya está registrado, utilice otro email");
        }

        // Verificación de la existencia del usuario en la base de datos
        if (userRepository.existsByUsername(dtoUserRegister.username())) {
            throw new IntegrityValidations("El nombre de usuario ingresado ya existe, utilice otro");
        }

        // Esta línea crea el usuario y encripta la contraseña
        var usuario = new User(dtoUserRegister, passwordEncoder);
        userRepository.save(usuario);
    }

    public void actualizarUsuario(Long id, DTOUserUpdate dtoUserUpdate) {
        // Verificamos por id si el usuario existe en la base de datos
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IntegrityValidations("El usuario ${id} no existe");
        }

        var user = userOptional.get();

        // Se actualiza los campos al proporcionar nuevos valores
        user.userUpdate(dtoUserUpdate);

        // Guardado del usuario actualizado en la base de datos
        userRepository.save(user);
    }

    public void userDesativate(Long id) {
        // Verificación por id de usuario existente en la base de datos
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IntegrityValidations("El usuario ${id} no existe");
        }

        var user = userOptional.get();

        // Desactiva la cuenta del usuario y se almacena su estado en la base de datos
        user.desactivateUser();
        userRepository.save(user);
    }
}