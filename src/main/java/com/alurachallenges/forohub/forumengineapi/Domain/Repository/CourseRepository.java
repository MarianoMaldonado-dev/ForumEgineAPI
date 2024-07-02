package com.alurachallenges.forohub.forumengineapi.Domain.Repository;

import com.alurachallenges.forohub.forumengineapi.Domain.Course.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByNombreContainsIgnoreCase(String s);
}