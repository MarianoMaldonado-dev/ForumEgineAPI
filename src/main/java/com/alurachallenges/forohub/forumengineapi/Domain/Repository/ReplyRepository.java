package com.alurachallenges.forohub.forumengineapi.Domain.Repository;

import com.alurachallenges.forohub.forumengineapi.Domain.Reply.Reply;
import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Reply, Long> {
    Page<Reply> findByActiveTrue(Pageable paged);
}