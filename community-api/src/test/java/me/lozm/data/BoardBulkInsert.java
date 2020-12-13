package me.lozm.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.object.dto.board.BoardPostDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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


//    @Test
    public void setBoard() {
        for (int i = 0; i <2000 ; i++) {
            postBoard();
        }
    }

    private void postBoard() {
        BoardPostDto.Request reqDto = makeTestBoardPostDto();

        try {
            ResultActions result = mockMvc.perform(
                    post("/api/board")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(reqDto))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
