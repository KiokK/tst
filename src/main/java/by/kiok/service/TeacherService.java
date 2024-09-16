package by.kiok.service;

import by.kiok.domain.Teacher;
import by.kiok.entity.TeacherEntity;
import by.kiok.exception.EntityNotFoundException;
import by.kiok.mapper.TeacherMapper;
import by.kiok.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<Teacher> getTeachers() {
        List<TeacherEntity> entities = teacherRepository.getTeachers();

        return teacherMapper.toTeachers(entities);
    }

    public Teacher getTeacherById(UUID id) {
        TeacherEntity findTeacher = teacherRepository.getTeacherById(id)
                .orElseThrow(() -> EntityNotFoundException.byId(id));

        return teacherMapper.toTeacher(findTeacher);
    }

    public Teacher createEntity(UUID id, Teacher newTeacher) {
        TeacherEntity newTeacherEntity = teacherMapper.toEntity(newTeacher);

        return teacherMapper.toTeacher(
                teacherRepository.createEntity(id, newTeacherEntity)
                        .orElseThrow(() -> EntityNotFoundException.byId(id)));
    }

    public Teacher updateEntity(UUID id, Teacher updateTeacher) {
        TeacherEntity updateTeacherEntity = teacherMapper.toEntity(updateTeacher);

        return teacherMapper.toTeacher(
                teacherRepository.updateEntity(id, updateTeacherEntity)
                        .orElseThrow(() -> EntityNotFoundException.byId(id)));
    }

    public void deleteById(UUID deleteId) {
        teacherRepository.deleteById(deleteId);
    }
}
