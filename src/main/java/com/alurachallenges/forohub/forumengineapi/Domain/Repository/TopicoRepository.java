package com.alurachallenges.forohub.forumengineapi.Domain.Repository;

import com.alurachallenges.forohub.forumengineapi.Domain.Topics.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
    boolean existsByTitleIgnoreCase(String title);
    boolean existsByMessageIgnoreCase(String message);
    Page<Topico> findByActiveTrue(Pageable paged);
}