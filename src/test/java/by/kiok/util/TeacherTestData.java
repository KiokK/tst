package by.kiok.util;

import by.kiok.common.PositionType;
import by.kiok.domain.Teacher;
import by.kiok.entity.TeacherEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TeacherTestData {

    public static final UUID TEST_ID = UUID.randomUUID();
    public static final UUID NULL_ID = null;
    public static final String DEF_NAME = "Ivanov";
    public static final OffsetDateTime DEF_DATA = OffsetDateTime.now();

    public static Teacher getTeacher() {
        return new Teacher()
                .setName(DEF_NAME)
                .setPosition(PositionType.TEACHER)
                .setDateOfBirth(DEF_DATA);
    }

    public static TeacherEntity getTeacherEntity() {
        return new TeacherEntity()
                .setName(DEF_NAME)
                .setPosition(PositionType.TEACHER)
                .setDateOfBirth(DEF_DATA);
    }
}
