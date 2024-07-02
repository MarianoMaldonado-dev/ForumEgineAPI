package com.alurachallenges.forohub.forumengineapi.Infrastructure.ExceptionsController;

public class IntegrityValidations extends RuntimeException {
    public IntegrityValidations(String s) {

        super(s);
    }
}