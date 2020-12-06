package me.lozm.docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.lozm.entity.board.Board;
import me.lozm.entity.board.Comment;
import me.lozm.entity.user.User;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.board.*;
import me.lozm.object.dto.user.UserDeleteDto;
import me.lozm.object.dto.user.UserPostDto;
import me.lozm.object.dto.user.UserPutDto;
import me.lozm.repository.board.BoardRepository;
import me.lozm.repository.board.CommentRepository;
import me.lozm.repository.user.UserRepository;
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
import static me.lozm.data.UserTestDto.makeTestUserPostDto;
import static me.lozm.data.UserTestDto.makeTestUserPutDto;
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
public class UserDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void getUserList() throws Exception {
        //Given
        //When
        ResultActions result = mockMvc.perform(
                RestDocumentationRequestBuilders.get("/api/user/usersType/{usersType}",
                        String.valueOf(UsersType.ALL)
                ).accept(MediaType.APPLICATION_JSON)
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("get-user-list",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("usersType").description("User type").attributes(getUsersType())
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("Whether invoking API is successful"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("Invoking API code"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("Invoking API message"),
                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("Invoking API data"),
                                fieldWithPath("data.list").type(JsonFieldType.OBJECT).description("User list"),
                                fieldWithPath("data.list.content").type(JsonFieldType.ARRAY).description("User content"),
                                fieldWithPath("data.list.content[].id").type(JsonFieldType.NUMBER).description("User ID").optional(),
                                fieldWithPath("data.list.content[].name").type(JsonFieldType.STRING).description("User name").optional(),
                                fieldWithPath("data.list.content[].identifier").type(JsonFieldType.STRING).description("User identifier").optional(),
                                fieldWithPath("data.list.content[].type").type(JsonFieldType.STRING).description("User type").optional(),
                                fieldWithPath("data.list.content[].flag").type(JsonFieldType.NUMBER).description("User flag").attributes(getFlagFormat()).optional(),
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
    public void postUser() throws Exception {
        //Given
        UserPostDto.Request reqDto = makeTestUserPostDto("test", "test_id");

        //When
        ResultActions result = mockMvc.perform(
                post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("post-user",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("User name"),
                                fieldWithPath("identifier").type(JsonFieldType.STRING).description("User identifier"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("User password"),
                                fieldWithPath("type").type(JsonFieldType.STRING).description("User type").attributes(getUsersType()),
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
    public void putUser() throws Exception {
        //Given
        List<User> userList = userRepository.findAll();

        UserPutDto.Request reqDto = makeTestUserPutDto(userList.get(0).getId(), "name", "identifier", "test");

        //When
        ResultActions result = mockMvc.perform(
                put("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("put-user",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("User ID"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("User name"),
                                fieldWithPath("identifier").type(JsonFieldType.STRING).description("User identifier"),
                                fieldWithPath("password").type(JsonFieldType.STRING).description("User password"),
                                fieldWithPath("type").type(JsonFieldType.STRING).description("User type").attributes(getUsersType()),
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
    public void deleteUser() throws Exception {
        //Given
        List<User> userList = userRepository.findAll();
        List<UserDeleteDto> deletedUserList = userList.stream()
                .filter((board) -> board.getFlag() != 0)
                .map((board) ->
                        UserDeleteDto.builder()
                                .id(board.getId())
                                .build()
                )
                .limit(10)
                .collect(Collectors.toList());

        UserDeleteDto.Request reqDto = new UserDeleteDto.Request();
        reqDto.setList(deletedUserList);

        //When
        ResultActions result = mockMvc.perform(
                delete("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqDto))
        );

        //Then
        result.andExpect(status().is(200))
                .andDo(document("delete-user",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestFields(
                                fieldWithPath("list").type(JsonFieldType.ARRAY).description("the list of deleted user IDs"),
                                fieldWithPath("list[].id").type(JsonFieldType.NUMBER).description("User ID"),
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

}
