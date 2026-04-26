package com.smartcoaching.repository;

import com.smartcoaching.entity.MarkConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MarkConfigRepository extends JpaRepository<MarkConfig, Long> {
    Optional<MarkConfig> findByCourseIdAndSubjectId(Long courseId, Long subjectId);
}
