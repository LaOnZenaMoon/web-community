package me.lozm.object.dto.board;

import lombok.Getter;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentPostDto {

    @Getter
    public static class Request extends BaseUserDto {
        @NotNull
        private Long boardId;

        @NotEmpty
        private String commentType;

        @NotEmpty
        private String content;

        public static CommentPostDto.Request setRequestTestData(Long boardId, String commentType, String content, Long userId) {
            CommentPostDto.Request reqDto = new CommentPostDto.Request();
            reqDto.boardId = boardId;
            reqDto.commentType = commentType;
            reqDto.content = content;
            reqDto.setCreatedBy(userId);

            return reqDto;
        }
    }

}
