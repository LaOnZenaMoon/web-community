package me.lozm.object.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserPostDto {

    @Getter @Builder
    public static class Request extends BaseUserDto {
        @NotEmpty
        private String name;

        @NotEmpty
        private String identifier;

        @NotEmpty
        @Setter
        private String password;

        @NotNull
        private UsersType type;
    }

}
