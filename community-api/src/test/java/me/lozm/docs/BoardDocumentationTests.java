package me.lozm.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.entity.board.Board;
import me.lozm.object.code.BoardType;
import me.lozm.object.dto.board.BoardDeleteDto;
import me.lozm.object.dto.board.BoardPostDto;
import me.lozm.object.dto.board.BoardPutDto;
import me.lozm.object.dto.board.CommentPostDto;
import me.lozm.repository.board.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.stream.Collectors;

import static me.lozm.data.BoardTestDto.*;
import static me.lozm.docs.ApiDocumentUtils.getDocumentRequest;
import static me.lozm.docs.ApiDocumentUtils.getDocumentResponse;
import static me.lozm.docs.DocumentFormatGenerator.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ActiveProfiles("local")
public class BoardDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void getBoardList() throws Exception {
        //Given
        //When
        ResultActions result = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/api/board/boardType/{boardType}",
                        String.valueOf(BoardType.MAGAZINE)
                ).accept(MediaType.APPLICATION_JSON)
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("get-board-list",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("boardType").description("Board type").attributes(getBoardType())
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("Invoking API data"),
                                fieldWithPath("data.list").type(JsonFieldType.OBJECT).description("Board list"),
                                fieldWithPath("data.list.content").type(JsonFieldType.ARRAY).description("Board content"),
                                fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description("Board ID").optional(),
                                fieldWithPath("data.list.content[].boardType").type(JsonFieldType.STRING).description("Board type").optional(),
                                fieldWithPath("data.list.content[].contentType").type(JsonFieldType.STRING).description("Board content type").optional(),
                                fieldWithPath("data.list.content[].title").type(JsonFieldType.STRING).description("Board title").optional(),
                                fieldWithPath("data.list.content[].content").type(JsonFieldType.STRING).description("Board content").optional(),
                                fieldWithPath("data.list.content[].flag").type(JsonFieldType.NUMBER).description("Board flag").attributes(getFlagFormat()).optional(),
                                fieldWithPath("data.list.pageable").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.pageable.sort").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.sort.empty").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.pageNumber").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.pageSize").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.offset").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.unpaged").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.paged").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.last").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.totalPages").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.totalElements").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.numberOfElements").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.first").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.sort.sorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort.unsorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort.empty").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.size").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.number").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.empty").type(JsonFieldType.BOOLEAN).description("")
                        )
                ));
    }

    @Test
    public void getBoardDetail() throws Exception {
        //Given
        List<Board> boardList = boardRepository.findAll();

        //When
        ResultActions result = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/api/board/{boardId}",
                        boardList.get(0).getId()
                ).accept(MediaType.APPLICATION_JSON)
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("get-board-detail",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("boardId").description("Board ID")
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("Invoking API data"),
                                fieldWithPath("data.id").type(JsonFieldType.NUMBER).description("Board ID"),
                                fieldWithPath("data.boardType").type(JsonFieldType.STRING).description("Board type"),
                                fieldWithPath("data.contentType").type(JsonFieldType.STRING).description("Board content type"),
                                fieldWithPath("data.title").type(JsonFieldType.STRING).description("Board title"),
                                fieldWithPath("data.content").type(JsonFieldType.STRING).description("Board content"),
                                fieldWithPath("data.flag").type(JsonFieldType.NUMBER).description("Board flag").attributes(getFlagFormat())
                        )
                ));
    }

    @Test
    public void getCommentList() throws Exception {
        //Given
        List<Board> boardList = boardRepository.findAll();

        //When
        ResultActions result = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/api/board/{boardId}/comment",
                        boardList.get(0).getId()
                ).accept(MediaType.APPLICATION_JSON)
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("get-comment-list",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("boardId").description("Board ID")
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("Invoking API data"),
                                fieldWithPath("data.list").type(JsonFieldType.OBJECT).description("Comment list"),
                                fieldWithPath("data.list.content").type(JsonFieldType.ARRAY).description("Comment content").optional(),
                                fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description("Comment ID").optional(),
                                fieldWithPath("data.list.content[].commentType").type(JsonFieldType.STRING).description("Comment type").attributes(getCommentType()).optional(),
                                fieldWithPath("data.list.content[].content").type(JsonFieldType.STRING).description("Comment content").optional(),
                                fieldWithPath("data.list.content[].flag").type(JsonFieldType.NUMBER).description("Comment flag").attributes(getFlagFormat()).optional(),
                                fieldWithPath("data.list.pageable").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.pageable.sort").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.pageable.sort.sorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.sort.unsorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.sort.empty").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.pageNumber").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.pageSize").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.offset").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.pageable.unpaged").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.pageable.paged").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.last").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.totalPages").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.totalElements").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.numberOfElements").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.first").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort").type(JsonFieldType.OBJECT).description(""),
                                fieldWithPath("data.list.sort.sorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort.unsorted").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.sort.empty").type(JsonFieldType.BOOLEAN).description(""),
                                fieldWithPath("data.list.size").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.number").type(JsonFieldType.NUMBER).description(""),
                                fieldWithPath("data.list.empty").type(JsonFieldType.BOOLEAN).description("")
                        )
                ));
    }

    @Test
    @Rollback
    public void postBoard() throws Exception {
        //Given
        BoardPostDto.Request reqDto = makeTestBoardPostDto();

        //When
        ResultActions result = mockMvc.perform(
                post("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("post-board",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("boardType").type(JsonFieldType.STRING).description("Board type").attributes(getBoardType()),
                                fieldWithPath("contentType").type(JsonFieldType.STRING).description("Content type").attributes(getContentType()),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("Board title"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("Board content"),
                                fieldWithPath("createdBy").type(JsonFieldType.NUMBER).description("User ID who created").optional(),
                                fieldWithPath("modifiedBy").type(JsonFieldType.NUMBER).description("User ID who modified").ignored()
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message").optional(),
                                fieldWithPath("data").type(JsonFieldType.STRING).description("Invoking API data").optional()
                        )
                ));
    }

    @Test
    @Rollback
    public void putBoard() throws Exception {
        //Given
        List<Board> boardList = boardRepository.findAll();

        BoardPutDto.Request putBoardDto = makeTestBoardPutDto(boardList.get(0).getId());

        //When
        ResultActions result = mockMvc.perform(
                put("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(putBoardDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("put-board",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("Board ID"),
                                fieldWithPath("boardType").type(JsonFieldType.STRING).description("Board type").attributes(getBoardType()),
                                fieldWithPath("contentType").type(JsonFieldType.STRING).description("Content type").attributes(getContentType()),
                                fieldWithPath("title").type(JsonFieldType.STRING).description("Board title"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("Board content"),
                                fieldWithPath("createdBy").type(JsonFieldType.NUMBER).description("User ID who created").ignored(),
                                fieldWithPath("modifiedBy").type(JsonFieldType.NUMBER).description("User ID who modified").optional()
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message").optional(),
                                fieldWithPath("data").type(JsonFieldType.STRING).description("Invoking API data").optional()
                        )
                ));
    }

    @Test
    @Rollback
    public void deleteBoard() throws Exception {
        //Given
        List<Board> boardList = boardRepository.findAll();
        List<BoardDeleteDto> deletedBoardList = boardList.stream()
                .filter((board) -> board.getFlag() != 0)
                .map((board) ->
                        BoardDeleteDto.builder()
                                .id(board.getId())
                                .build()
                )
                .limit(10)
                .collect(Collectors.toList());

        BoardDeleteDto.Request reqDto = new BoardDeleteDto.Request();
        reqDto.setList(deletedBoardList);

        //When
        ResultActions result = mockMvc.perform(
                delete("/api/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("delete-board",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("list").type(JsonFieldType.ARRAY).description("the list of deleted Board IDs"),
                                fieldWithPath("list[].id").type(JsonFieldType.NUMBER).description("Board ID"),
                                fieldWithPath("createdBy").type(JsonFieldType.NUMBER).description("User ID who created").ignored(),
                                fieldWithPath("modifiedBy").type(JsonFieldType.NUMBER).description("User ID who modified").optional()
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message").optional(),
                                fieldWithPath("data").type(JsonFieldType.STRING).description("Invoking API data").optional()
                        )
                ));
    }

    @Test
    @Rollback
    public void postComment() throws Exception {
        //Given
        List<Board> boardList = boardRepository.findAll();
        CommentPostDto.Request reqDto = makeTestCommentPostDto(boardList.get(0).getId());

        //When
        ResultActions result = mockMvc.perform(
                post("/api/comment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("post-comment",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("boardId").type(JsonFieldType.STRING).description("Board ID"),
                                fieldWithPath("commentType").type(JsonFieldType.STRING).description("Comment type"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("Comment content"),
                                fieldWithPath("createdBy").type(JsonFieldType.NUMBER).description("User ID who created").optional(),
                                fieldWithPath("modifiedBy").type(JsonFieldType.NUMBER).description("User ID who modified").ignored()
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message").optional(),
                                fieldWithPath("data").type(JsonFieldType.STRING).description("Invoking API data").optional()
                        )
                ));
    }

}
