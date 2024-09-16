package by.kiok.controller;

import by.kiok.domain.Teacher;
import by.kiok.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> createTeachers(@RequestBody Teacher newsRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teacherService.createEntity(newsRequestDto.getId(), newsRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeachersById(@PathVariable UUID id) {

        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

}
