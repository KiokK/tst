package by.kiok.controller;

import by.kiok.domain.Teacher;
import by.kiok.service.TeacherService;
import by.kiok.util.TeacherTestData;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static by.kiok.util.TeacherTestData.TEST_ID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
@WebMvcTest(TeacherController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class TeacherControllerTest {

    @Autowired
    private final MockMvc mockMvc;

    @MockBean
    private final TeacherService teacherService;

    @Test
    @SneakyThrows
    void getTeachersById() {
        //given
        UUID foundId = TEST_ID;
        Teacher expectedDto = TeacherTestData.getTeacher().setId(TEST_ID);

        //when
        when(teacherService.getTeacherById(foundId))
                .thenReturn(expectedDto);

        //then
        mockMvc.perform(get("/api/v1/teachers/" + foundId))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.id").value(expectedDto.getId().toString()),
                        jsonPath("$.name").value(expectedDto.getName()),
                        jsonPath("$.position").value(expectedDto.getPosition().toString())
                );
    }
}
