package com.alurachallenges.forohub.forumengineapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumEngineApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ForumEngineApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenid@! Forum Engine está siendo ejecutado en el puerto 666");
        System.out.println("""
                                Este programa fue codificado por:
                                { Dev</>Code } © Informatic Solutions
                                Autor: Mariano Maldonado
                            
                                Puede contactarme en los siguientes medios:
                                Instagram: @MarianoMaldonado.dev
                                Linkedin: https://www.linkedin.com/in/mariano-maldonado-810847288
                                Alura: https://app.aluracursos.com/user/cyberwargamesproductions
                            """);
        System.out.println("""
                Nombre del producto: Forum Engine
                Versión: v0.1
                Estado: Alpha (Aun en estado temprano de desarrollo)
                """);
    }
}
