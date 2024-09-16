package by.kiok.domain;

import by.kiok.common.PositionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private UUID id;
    private String name;
    private PositionType position;
    private OffsetDateTime dateOfBirth;
}
