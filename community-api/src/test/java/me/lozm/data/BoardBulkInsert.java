package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import me.lozm.api.user.UserService;
import me.lozm.entity.user.User;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.board.BoardPostDto;
import me.lozm.object.dto.board.BoardPutDto;
import me.lozm.object.dto.user.UserGetDto;
import org.junit.jupiter.api.Test;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BoardBulkInsert {

    private static Faker faker = new Faker();


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

    public static BoardPostDto.Request makeTestBoardPostDto(Long userId) {
        Faker faker = new Faker();
        BoardPostDto.Request reqDto = BoardPostDto.Request.builder()
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();

        return reqDto;
    }

    public static BoardPutDto.Request makeTestBoardPutDto(Long boardId) {
        BoardPutDto.Request reqDto = BoardPutDto.Request.builder()
                .id(boardId)
                .boardType(getRandomBoardType())
                .contentType(getRandomContentType())
                .title(faker.book().title())
                .content(faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 10)).toString())
                .build();

        return reqDto;
    }

    private static String getRandomBoardType() {
        BoardType[] boardTypeArr = BoardType.values();
        String boardType = boardTypeArr[ThreadLocalRandom.current().nextInt(1, boardTypeArr.length - 1)].toString();
        return boardType;
    }

    private static String getRandomContentType() {
        ContentType[] contentTypeArr = ContentType.values();
        String contentType = contentTypeArr[ThreadLocalRandom.current().nextInt(0, contentTypeArr.length - 1)].toString();
        return contentType;
    }

}
