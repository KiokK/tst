package by.kiok.service;

import by.kiok.domain.Teacher;
import by.kiok.entity.TeacherEntity;
import by.kiok.exception.EntityNotFoundException;
import by.kiok.mapper.TeacherMapper;
import by.kiok.repository.TeacherRepository;
import by.kiok.util.TeacherTestData;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static by.kiok.util.TeacherTestData.NULL_ID;
import static by.kiok.util.TeacherTestData.TEST_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private TeacherMapper teacherMapper;

    @InjectMocks
    private TeacherService teacherService;

    @Nested
    class GetTeachers {

        @Test
        void shouldReturnCorrectSize() {
            //given
            TeacherEntity entity = new TeacherEntity();
            List<TeacherEntity> entities = List.of(entity);
            List<Teacher> teachers = List.of(new Teacher());
            int size = 1;

            //when
            when(teacherRepository.getTeachers())
                    .thenReturn(entities);
            when(teacherMapper.toTeachers(entities))
                    .thenReturn(teachers);

            //then
            List<Teacher> actual = teacherService.getTeachers();
            assertEquals(size, actual.size());
        }
    }

    @Nested
    class GetTeacherById {

        @Test
        void shouldReturnTeacherById() {
            //given
            UUID teacherId = TEST_ID;
            TeacherEntity entity = new TeacherEntity();
            Teacher teacher = new Teacher();

            //when
            when(teacherRepository.getTeacherById(teacherId))
                    .thenReturn(Optional.of(entity));
            when(teacherMapper.toTeacher(entity))
                    .thenReturn(teacher);

            //then
            Teacher actual = teacherService.getTeacherById(teacherId);
            assertEquals(teacher.getId(), actual.getId());
        }

        @Test
        void shouldThrowNotFoundException() {
            //given//when
            when(teacherRepository.getTeacherById(NULL_ID))
                    .thenReturn(Optional.empty());

            //then
            assertThrows(
                    EntityNotFoundException.class,
                    () -> teacherService.getTeacherById(NULL_ID));
        }
    }

    @Nested
    class CreatedEntity {

        @Test
        void shouldReturnCreatedEntity() {
            //given
            TeacherEntity entity = TeacherTestData.getTeacherEntity();
            Teacher teacher = TeacherTestData.getTeacher();
            Teacher expected = TeacherTestData.getTeacher();
            expected.setId(TEST_ID);

            //when
            when(teacherMapper.toEntity(teacher))
                    .thenReturn(entity);
            when(teacherRepository.createEntity(TEST_ID, entity))
                    .thenReturn(Optional.of(entity));
            when(teacherMapper.toTeacher(entity))
                    .thenReturn(expected);

            //then
            Teacher actual = teacherService.createEntity(TEST_ID, teacher);
            assertEquals(expected.getId(), actual.getId());
        }

        @Test
        void shouldThrowEntityNotFoundException() {
            //given
            TeacherEntity entity = TeacherTestData.getTeacherEntity();
            Teacher teacher = TeacherTestData.getTeacher();

            // when
            when(teacherMapper.toEntity(teacher))
                    .thenReturn(entity);

            //then
            assertThrows(
                    EntityNotFoundException.class,
                    () -> teacherService.createEntity(TEST_ID, teacher));
        }
    }

    @Nested
    class UpdateEntity {

        @Test
        void shouldReturnUpdatedEntity() {
            //given
            TeacherEntity entity = TeacherTestData.getTeacherEntity();
            Teacher teacher = TeacherTestData.getTeacher();
            Teacher expected = TeacherTestData.getTeacher();
            expected.setId(TEST_ID);

            //when
            when(teacherMapper.toEntity(teacher))
                    .thenReturn(entity);
            when(teacherRepository.updateEntity(TEST_ID, entity))
                    .thenReturn(Optional.of(entity));
            when(teacherMapper.toTeacher(entity))
                    .thenReturn(expected);

            //then
            Teacher actual = teacherService.updateEntity(TEST_ID, teacher);
            assertEquals(expected, actual);
        }

        @Test
        void shouldThrowEntityNotFoundException() {
            //given
            TeacherEntity entity = TeacherTestData.getTeacherEntity();
            Teacher teacher = TeacherTestData.getTeacher();

            // when
            when(teacherMapper.toEntity(teacher))
                    .thenReturn(entity);

            //then
            assertThrows(
                    EntityNotFoundException.class,
                    () -> teacherService.updateEntity(TEST_ID, teacher));
        }
    }

    @Test
    void deleteById() {
        //given//when
        teacherService.deleteById(TEST_ID);

        //then
        verify(teacherRepository).deleteById(TEST_ID);
    }
}
