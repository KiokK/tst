package by.kiok.mapper;

import by.kiok.domain.Teacher;
import by.kiok.entity.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> toTeachers(List<TeacherEntity> entities);

    Teacher toTeacher(TeacherEntity entity);

    TeacherEntity toEntity(Teacher teacher);
}
