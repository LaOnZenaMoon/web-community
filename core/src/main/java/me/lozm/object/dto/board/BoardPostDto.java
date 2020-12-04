package me.lozm.object.dto.board;

import lombok.Builder;
import lombok.Getter;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;

public class BoardPostDto {

    @Getter @Builder
    public static class Request extends BaseUserDto {
        @NotNull
        private String boardType;

        @NotNull
        private String contentType;

        @NotNull
        private String title;

        @NotNull
        private String content;
    }

}
