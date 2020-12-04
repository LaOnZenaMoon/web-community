package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.api.user.UserService;
import me.lozm.entity.user.User;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.board.BoardPostDto;
import me.lozm.object.dto.user.UserGetDto;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static me.lozm.data.BoardTestDto.makeTestBoardPostDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BoardBulkInsert {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;


//    @Test
    public void setBoard() {
        List<User> userList = userService.getUserList();
        userList.add(User.builder()
                .id(2L)
                .name("JUN LEE")
                .identifier("junlee")
                .type(UsersType.USER)
                .build());

        try {
            for (int i = 0; i <2000 ; i++) {
                UserGetDto getUser = UserGetDto.of(userList.get(ThreadLocalRandom.current().nextInt(0, userList.size())));
                postBoard(getUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postBoard(UserGetDto user) throws Exception {
        BoardPostDto.Request reqDto = makeTestBoardPostDto(user.getId());

        ResultActions result = mockMvc.perform(
                post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );
    }

}
