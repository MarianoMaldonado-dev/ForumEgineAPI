package com.alurachallenges.forohub.forumengineapi.Domain.user.DTO;

import com.alurachallenges.forohub.forumengineapi.Domain.user.User;

public record DTOUserList(
        Long id,
        String name,
        String email
){
    public DTOUserList(User user){

        this(user.getId(),user.getName(),user.getEmail());
    }
}