package me.lozm.object.dto.board;

import lombok.Getter;
import me.lozm.object.code.CommentType;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentPostDto {

    @Getter
    public static class Request extends BaseUserDto {
        @NotNull
        private Long boardId;

        @NotEmpty
        private CommentType commentType;

        @NotEmpty
        private String content;
    }

}
