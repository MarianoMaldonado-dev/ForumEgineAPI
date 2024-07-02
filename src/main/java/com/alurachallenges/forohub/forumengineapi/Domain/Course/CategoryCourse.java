package com.alurachallenges.forohub.forumengineapi.Domain.Course;

public enum CategoryCourse {

    PRINCIPIANTE_PROGRAMACION("Principiante_Programación"),
    FRONT_END("Front_End"),
    BACK_END("Back_End"),
    ALUMNI_ONE("Alumni_ONE"), category();

    private String Category(String category){
        this.category = category;
    }

    public static Category fromString(String text){
        for (Category category : Category.values()){
            if (category.category.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("La categoría solicitada no existe " + text);
    }
}