package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import me.lozm.api.board.BoardService;
import me.lozm.api.user.UserService;
import me.lozm.entity.board.Board;
import me.lozm.entity.user.User;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import me.lozm.object.dto.board.PostCommentDto;
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
public class CommentBulkInsert {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;


    @Test
    public void setComment() {
        String[] boardTypeArr = {
                BoardType.NEWS.name(), BoardType.MAGAZINE.name(),
                BoardType.DIARY.name(), BoardType.FREE_CONTENTS.name(),
                BoardType.SPORTS.name()
        };

        List<User> userList = userService.getUserList();
        List<Board> newsList = boardService.getBoardList(boardTypeArr[0]);
        List<Board> magazineList = boardService.getBoardList(boardTypeArr[1]);
        List<Board> diaryList = boardService.getBoardList(boardTypeArr[2]);
        List<Board> freeContentsList = boardService.getBoardList(boardTypeArr[3]);
        List<Board> sportsList = boardService.getBoardList(boardTypeArr[4]);

        try {
            for (int i = 0; i <newsList.size() ; i++) {
                int size = ThreadLocalRandom.current().nextInt(0, 10);
                for (int j = 0; j <size; j++) {
                    User getUser = userList.get(ThreadLocalRandom.current().nextInt(0, userList.size()));
                    postComment(getUser, newsList.get(i));
                }
            }

            for (int i = 0; i <magazineList.size() ; i++) {
                int size = ThreadLocalRandom.current().nextInt(0, 10);
                for (int j = 0; j <size; j++) {
                    User getUser = userList.get(ThreadLocalRandom.current().nextInt(0, userList.size()));
                    postComment(getUser, magazineList.get(i));
                }
            }

            for (int i = 0; i <diaryList.size() ; i++) {
                int size = ThreadLocalRandom.current().nextInt(0, 10);
                for (int j = 0; j <size; j++) {
                    User getUser = userList.get(ThreadLocalRandom.current().nextInt(0, userList.size()));
                    postComment(getUser, diaryList.get(i));
                }
            }

            for (int i = 0; i <freeContentsList.size() ; i++) {
                int size = ThreadLocalRandom.current().nextInt(0, 10);
                for (int j = 0; j <size; j++) {
                    User getUser = userList.get(ThreadLocalRandom.current().nextInt(0, userList.size()));
                    postComment(getUser, freeContentsList.get(i));
                }
            }

            for (int i = 0; i <sportsList.size() ; i++) {
                int size = ThreadLocalRandom.current().nextInt(0, 10);
                for (int j = 0; j <size; j++) {
                    User getUser = userList.get(ThreadLocalRandom.current().nextInt(0, userList.size()));
                    postComment(getUser, sportsList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postComment(User getUser, Board board) throws Exception {
        Faker faker = new Faker();
        String[] contentTypeArr = {ContentType.GENERAL.name(), ContentType.NOTICE.name(), ContentType.EVENT.name()};
        String contentType = contentTypeArr[ThreadLocalRandom.current().nextInt(0, 2)];
        PostCommentDto.Request reqDto = PostCommentDto.Request.setRequestTestData(
                board.getId(),
                contentType,
                faker.lorem().sentences(ThreadLocalRandom.current().nextInt(0, 2)).toString(),
                getUser.getId()
        );

        ResultActions result = mockMvc.perform(
                post("/api/board/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );
    }

}
