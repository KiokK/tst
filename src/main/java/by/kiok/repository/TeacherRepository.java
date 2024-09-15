package by.kiok.repository;

import by.kiok.common.PositionType;
import by.kiok.entity.TeacherEntity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TeacherRepository {

    private static final List<TeacherEntity> db = List.of(
            new TeacherEntity()
                    .setId(UUID.randomUUID())
                    .setName("Ivanov")
                    .setPosition(PositionType.TEACHER)
                    .setDateOfBirth(OffsetDateTime.of(1995, 1,1, 0, 0, 0, 0, ZoneOffset.UTC)),
            new TeacherEntity(UUID.randomUUID(), "Bibikov", PositionType.ASSISTANT, OffsetDateTime.of(2001, 1,1, 0, 0, 0, 0, ZoneOffset.UTC)),
            new TeacherEntity(UUID.randomUUID(), "Sidorova", PositionType.ASSISTANT, OffsetDateTime.of(2001, 1,1, 0, 0, 0, 0, ZoneOffset.UTC))
    );

    public List<TeacherEntity> getTeachers() {
        return db;
    }

    public Optional<TeacherEntity> getTeacherById(UUID id) {
        return Optional.ofNullable(db.get(0));
    }

    public Optional<TeacherEntity> createEntity(UUID id, TeacherEntity newTeacherEntity) {
        return Optional.ofNullable(newTeacherEntity.setId(id));
    }


    public Optional<TeacherEntity> updateEntity(UUID id, TeacherEntity updatedTeacherEntity) {
        return Optional.ofNullable(updatedTeacherEntity.setId(id));
    }


    public void deleteById(UUID deleteId) {
        //without body
    }
}
