package com.smartcoaching.controller;

import com.smartcoaching.entity.Subject;
import com.smartcoaching.repository.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectRepository subjectRepository;
    private final com.smartcoaching.repository.UserRepository userRepository;

    public SubjectController(SubjectRepository subjectRepository, com.smartcoaching.repository.UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @GetMapping("/my")
    public ResponseEntity<List<Map<String, Object>>> getMySubjects(@RequestHeader("X-User-Email") String userEmail) {
        List<Subject> all = subjectRepository.findAll();
        List<Map<String, Object>> mySubs = all.stream()
                .filter(s -> s.getTeacher() != null && s.getTeacher().getEmail().equals(userEmail))
                .map(s -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("courseId", s.getCourse().getId());
                    map.put("courseName", s.getCourse().getName());
                    map.put("batchName", s.getCourse().getBatch() != null ? s.getCourse().getBatch().getName() : "N/A");
                    map.put("subjectId", s.getId());
                    map.put("subjectName", s.getName());
                    return map;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(mySubs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        subject.setName(payload.get("name").toString());
        if (payload.containsKey("teacherId")) {
            Long teacherId = Long.parseLong(payload.get("teacherId").toString());
            subject.setTeacher(userRepository.findById(teacherId).orElse(null));
        }
        Subject saved = subjectRepository.save(subject);
        
        Map<String, Object> res = new HashMap<>();
        res.put("id", saved.getId());
        res.put("name", saved.getName());
        res.put("teacherId", saved.getTeacher() != null ? saved.getTeacher().getId() : null);
        return ResponseEntity.ok(res);
    }
}
