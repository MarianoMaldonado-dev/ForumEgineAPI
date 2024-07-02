package com.alurachallenges.forohub.forumengineapi.Domain.Topics;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.DTOPosts.DTOUpdatedTopic;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDateTime;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "author_id")
    private com.alurachallenges.forohub.forumengineapi.Domain.User.User author;
    private String course;
    private boolean active;

    public Topico topic(Long id, String title, String message, LocalDateTime date, Status status, com.alurachallenges.forohub.forumengineapi.Domain.User.User user, String curso) {
        this.id=id;
        this.title=title;
        this.message=message;
        this.date = date;
        this.date=LocalDateTime.now();
        this.status=status;
        this.author=user;
        this.course=curso;
    }
    public void updatedTopic(DTOUpdatedTopic dtoUpdatedTopic){
        if (dtoUpdatedTopic.title() !=null){
            this.title= dtoUpdatedTopic.title();
        }
        if (dtoUpdatedTopic.message() != null){
            this.message=dtoUpdatedTopic.message();
        }
        if (dtoUpdatedTopic.status() != null){
            this.status=dtoUpdatedTopic.status();
        }
        if (dtoUpdatedTopic.curso() != null){
            this.course=dtoUpdatedTopic.curso();
        }
    }
    public void desactivateTopic(){
        this.active=false;
    }
}