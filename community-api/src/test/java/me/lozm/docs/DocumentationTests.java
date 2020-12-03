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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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
                                    fieldWithPath("data").type(JsonFieldType.OBJECT).description("API 호출 데이터")
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
