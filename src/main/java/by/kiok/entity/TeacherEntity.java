package by.kiok.entity;

import by.kiok.common.PositionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

    private UUID id;
    private String name;
    private PositionType position;
    private OffsetDateTime dateOfBirth;
}
