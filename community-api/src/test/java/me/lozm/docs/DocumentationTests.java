package me.lozm.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.object.code.BoardType;
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

import static me.lozm.docs.ApiDocumentUtils.getDocumentRequest;
import static me.lozm.docs.ApiDocumentUtils.getDocumentResponse;
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
public class DocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void getBoard() throws Exception {
        try {
            //Given
            //When
            ResultActions result = mockMvc.perform(
                    RestDocumentationRequestBuilders.get("/api/board/boardType/{boardType}",
                            String.valueOf(BoardType.MAGAZINE)
                    ).accept(MediaType.APPLICATION_JSON)
            );

            //Then
            result.andExpect(status().is(200))
                    .andDo(document("get-board",
                            getDocumentRequest(),
                            getDocumentResponse(),
                            pathParameters(
                                    parameterWithName("boardType").description("게시판 유형").attributes(getYnFormat())
                            ),
                            responseFields(
                                    fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("API 호출 성공여부"),
                                    fieldWithPath("code").type(JsonFieldType.STRING).description("API 호출 코드"),
                                    fieldWithPath("message").type(JsonFieldType.STRING).description("API 호출 메시지"),
                                    fieldWithPath("data").type(JsonFieldType.OBJECT).description("API 호출 데이터"),
                                    fieldWithPath("data.list").type(JsonFieldType.OBJECT).description(""),
                                    fieldWithPath("data.list.content").type(JsonFieldType.ARRAY).description(""),
                                    fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description(""),
                                    fieldWithPath("data.list.content[].boardType").type(JsonFieldType.STRING).description(""),
                                    fieldWithPath("data.list.content[].contentType").type(JsonFieldType.STRING).description(""),
                                    fieldWithPath("data.list.content[].title").type(JsonFieldType.STRING).description(""),
                                    fieldWithPath("data.list.content[].content").type(JsonFieldType.STRING).description(""),
                                    fieldWithPath("data.list.content[].comments").type(JsonFieldType.ARRAY).description(""),
                                    fieldWithPath("data.list.content[].comments[].id").type(JsonFieldType.NUMBER).description(""),
                                    fieldWithPath("data.list.content[].comments[].commentType").type(JsonFieldType.STRING).description(""),
                                    fieldWithPath("data.list.content[].comments[].flag").type(JsonFieldType.NUMBER).description(""),
                                    fieldWithPath("data.list.content[].comments[].content").type(JsonFieldType.STRING).description(""),
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
        } catch (Exception e) {
            e.printStackTrace();
        }

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
