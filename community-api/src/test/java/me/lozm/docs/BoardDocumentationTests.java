package me.lozm.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.entity.board.Board;
import me.lozm.object.code.BoardType;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static me.lozm.docs.ApiDocumentUtils.getDocumentRequest;
import static me.lozm.docs.ApiDocumentUtils.getDocumentResponse;
import static me.lozm.docs.DocumentFormatGenerator.getBoardType;
import static me.lozm.docs.DocumentFormatGenerator.getYnFormat;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
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
                                fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description("Board ID"),
                                fieldWithPath("data.list.content[].boardType").type(JsonFieldType.STRING).description("Board type"),
                                fieldWithPath("data.list.content[].contentType").type(JsonFieldType.STRING).description("Board content type"),
                                fieldWithPath("data.list.content[].title").type(JsonFieldType.STRING).description("Board title"),
                                fieldWithPath("data.list.content[].content").type(JsonFieldType.STRING).description("Board content"),
                                fieldWithPath("data.list.content[].flag").type(JsonFieldType.NUMBER).description("Board flag"),
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
                                fieldWithPath("data.flag").type(JsonFieldType.NUMBER).description("Board flag")
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
                                fieldWithPath("data.list.content").type(JsonFieldType.ARRAY).description("Comment content"),
                                fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description("Comment ID"),
                                fieldWithPath("data.list.content[].commentType").type(JsonFieldType.STRING).description("Comment type"),
                                fieldWithPath("data.list.content[].content").type(JsonFieldType.STRING).description("Comment content"),
                                fieldWithPath("data.list.content[].flag").type(JsonFieldType.NUMBER).description("Comment flag"),
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

//    @Test
//    @Rollback
//    public void postSample() {
//        try {
//            //Given
//
//            //When
//            ResultActions result = mockMvc.perform(
//                    post("/post/url")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(new Object())) //Post DTO
//            );
//
//            //Then
//            result.andExpect(status().is(200))
//                    .andDo(document("post-sample",
//                            getDocumentRequest(),
//                            getDocumentResponse(),
//                            requestFields(
//                                    fieldWithPath("sample").type(JsonFieldType.STRING).description("sample").attributes(getDateFormat())
//                            ),
//                            responseFields(
//                                    fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("API 호출 성공여부"),
//                                    fieldWithPath("code").type(JsonFieldType.STRING).description("API 호출 코드"),
//                                    fieldWithPath("message").type(JsonFieldType.STRING).description("API 호출 메시지"),
//                                    fieldWithPath("data").type(JsonFieldType.OBJECT).description("API 호출 데이터")
//                            )
//                    ));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    @Rollback
//    public void putSample() {
//        try {
//            //Given
//
//            //When
//            ResultActions result = mockMvc.perform(
//                    put("/put/url")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(new Object())) //Post DTO
//            );
//
//            //Then
//            result.andExpect(status().is(200))
//                    .andDo(document("put-sample",
//                            getDocumentRequest(),
//                            getDocumentResponse(),
//                            requestFields(
//                                    fieldWithPath("sample").type(JsonFieldType.STRING).description("sample").attributes(getDateFormat())
//                            ),
//                            responseFields(
//                                    fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("API 호출 성공여부"),
//                                    fieldWithPath("code").type(JsonFieldType.STRING).description("API 호출 코드"),
//                                    fieldWithPath("message").type(JsonFieldType.STRING).description("API 호출 메시지"),
//                                    fieldWithPath("data").type(JsonFieldType.OBJECT).description("API 호출 데이터")
//                            )
//                    ));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    @Rollback
//    public void deleteSample() {
//        try {
//            //Given
//
//            //When
//            ResultActions result = mockMvc.perform(
//                    delete("/delete/url")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(objectMapper.writeValueAsString(new Object())) //Delete DTO
//            );
//
//            //Then
//            result.andExpect(status().is(200))
//                    .andDo(document("delete-sample",
//                            getDocumentRequest(),
//                            getDocumentResponse(),
//                            requestFields(
//                                    fieldWithPath("sample").type(JsonFieldType.STRING).description("sample").attributes(getDateFormat())
//                            ),
//                            responseFields(
//                                    fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("API 호출 성공여부"),
//                                    fieldWithPath("code").type(JsonFieldType.STRING).description("API 호출 코드"),
//                                    fieldWithPath("message").type(JsonFieldType.STRING).description("API 호출 메시지"),
//                                    fieldWithPath("data").type(JsonFieldType.OBJECT).description("API 호출 데이터")
//                            )
//                    ));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
