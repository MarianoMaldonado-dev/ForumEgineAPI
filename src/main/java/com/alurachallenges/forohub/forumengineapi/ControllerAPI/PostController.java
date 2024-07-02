package com.alurachallenges.forohub.forumengineapi.ControllerAPI;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import com.alurachallenges.forohub.forumengineapi.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Topicos")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Topico> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Topico createPost(@RequestBody Topico topico) {
        return postService.savePost(topico);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}