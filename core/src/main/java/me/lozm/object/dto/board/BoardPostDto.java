package me.lozm.object.dto.board;

import lombok.Builder;
import lombok.Getter;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.ContentType;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;

public class BoardPostDto {

    @Getter @Builder
    public static class Request extends BaseUserDto {
        @NotNull
        private BoardType boardType;

        @NotNull
        private ContentType contentType;

        @NotNull
        private String title;

        @NotNull
        private String content;
    }

}
