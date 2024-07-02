package com.alurachallenges.forohub.forumengineapi.Domain.Reply;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.DTOResponses.DTOUpdateReply;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import com.alurachallenges.forohub.forumengineapi.Domain.User.User;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name="reply")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
public class Reply{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDate;
    private String solution;

    @OneToOne
    @JoinColumn(name="author", referencedColumnName="id")
    private User author;
    @OneToOne
    @JoinColumn(name="topico", referencedColumnName="id")
    private Topico topico;
    private boolean active;

    public Reply(Long id, String solution, User user, Topico topico, LocalDateTime creationDate) {
        this.id=id;
        this.solution=solution;
        this.author=user;
        this.topico=topico;
        this.creationDate=LocalDateTime.now();
    }

    public void updateReply(DTOUpdateReply dtoUpdateReply) {
        if (dtoUpdateReply.solution() != null){
            this.solution=dtoUpdateReply.solution();
        }
    }
    public void deleteReply(){

        this.active=false;
    }
}