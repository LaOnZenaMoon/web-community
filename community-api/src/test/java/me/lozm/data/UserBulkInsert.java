package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.object.dto.user.UserPostDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static me.lozm.data.UserTestDto.makeTestUserPostDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("local")
public class UserBulkInsert {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


//    @Test
    public void setUser() {
        postUser(makeTestUserPostDto("JUN LEE", "junlee"));

        for (int i = 0; i < 100; i++) {
            postUser(makeTestUserPostDto());
        }
    }

    public void postUser(UserPostDto.Request reqDto) {
        try {
            ResultActions result = mockMvc.perform(
                    post("/api/user")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(reqDto))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
