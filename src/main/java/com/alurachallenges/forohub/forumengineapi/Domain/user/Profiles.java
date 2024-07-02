package com.alurachallenges.forohub.forumengineapi.Domain.user;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

public enum Profiles {
    ADMINISTRATOR("Administrador"),
    INSTRUCTOR("Instructor"),
    STUDENT("Estudiante");

    private static String text;
    private String profile;
    Profiles(String profile){
        this.profile = profile;
    }

    public static @NotNull Profiles fromString(String text){
        Profiles.text = text;
        for(Profiles profile: Profiles.values()){
            if (profile.profile.equalsIgnoreCase(text)){
                return profile;
            }
        }
        throw new IllegalArgumentException("El perfil no existe: " + text);
    }
}