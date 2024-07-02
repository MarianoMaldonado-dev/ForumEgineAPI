package com.alurachallenges.forohub.forumengineapi.Service;
/*
import com.alurachallenges.forohub.forumengineapi.Domain.Repository.PostRepository;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Validations.TopicsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Autowired
    private TopicsValidations topicsValidations;

    public Topico createTopico(Topico topico) {
        if (!topicsValidations.isTituloUnico(topico.getTitulo())) {
            throw new IllegalArgumentException("El título ya existe.");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> listAllTopicos() {
        return topicoRepository.findAll();
    }

    public Topico getTopico(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado."));
    }

    public Topico updateTopico(Long id, Topico topico) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado.");
        }
        topico.setId(id);
        return topicoRepository.save(topico);
    }

    public void deleteTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado.");
        }
        topicoRepository.deleteById(id);
    }
}*/