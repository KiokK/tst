package by.kiok.mapper;

import by.kiok.domain.Teacher;
import by.kiok.entity.TeacherEntity;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherMapperTest {

    private final static TeacherMapper mapper = new TeacherMapperImpl();

    @Test
    void toTeachers() {
        //given
        EasyRandom generator = new EasyRandom();
        List<TeacherEntity> entities = generator.objects(TeacherEntity.class, 5).toList();

        //when//then
        List<Teacher> actual = mapper.toTeachers(entities);

        assertEquals(5, actual.size());
    }

    @Test
    void toTeacher() {
        //given
        EasyRandom generator = new EasyRandom();
        TeacherEntity entity = generator.nextObject(TeacherEntity.class);

        //when//then
        Teacher actual = mapper.toTeacher(entity);
        assertAll(
                () -> assertEquals(entity.getId(), actual.getId()),
                () -> assertEquals(entity.getName(), actual.getName()),
                () -> assertEquals(entity.getPosition(), actual.getPosition()),
                () -> assertEquals(entity.getDateOfBirth(), actual.getDateOfBirth())
        );
    }

    @Test
    void toEntity() {
        //given
        EasyRandom generator = new EasyRandom();
        Teacher entity = generator.nextObject(Teacher.class);

        //when//then
        TeacherEntity actual = mapper.toEntity(entity);
        assertAll(
                () -> assertEquals(entity.getId(), actual.getId()),
                () -> assertEquals(entity.getName(), actual.getName()),
                () -> assertEquals(entity.getPosition(), actual.getPosition()),
                () -> assertEquals(entity.getDateOfBirth(), actual.getDateOfBirth())
        );
    }
}
