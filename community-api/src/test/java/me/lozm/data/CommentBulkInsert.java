package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.entity.board.Board;
import me.lozm.object.code.BoardType;
import me.lozm.object.dto.board.CommentPostDto;
import me.lozm.repository.board.BoardRepository;
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

import static me.lozm.data.BoardTestDto.makeTestCommentPostDto;
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
    private BoardRepository boardRepository;


    @Test
    public void setComment() {
        List<Board> newsList = boardRepository.selectBoardListByBoardType(String.valueOf(BoardType.NEWS));
        List<Board> magazineList = boardRepository.selectBoardListByBoardType(String.valueOf(BoardType.MAGAZINE));
        List<Board> diaryList = boardRepository.selectBoardListByBoardType(String.valueOf(BoardType.DIARY));
        List<Board> freeContentsList = boardRepository.selectBoardListByBoardType(String.valueOf(BoardType.FREE_CONTENTS));
        List<Board> sportsList = boardRepository.selectBoardListByBoardType(String.valueOf(BoardType.SPORTS));

        newsList.forEach((news) -> postComment(news));
        magazineList.forEach((magazine) -> postComment(magazine));
        diaryList.forEach((diary) -> postComment(diary));
        freeContentsList.forEach((freeContent) -> postComment(freeContent));
        sportsList.forEach((sports) -> postComment(sports));
    }

    private void postComment(Board board) {
        CommentPostDto.Request reqDto = makeTestCommentPostDto(board.getId());

        try {
            ResultActions result = mockMvc.perform(
                    post("/api/board/comment")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(reqDto))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
