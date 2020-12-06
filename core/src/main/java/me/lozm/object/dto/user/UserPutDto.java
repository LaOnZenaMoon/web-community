package me.lozm.object.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotNull;

public class UserPutDto {

    @Getter @Builder
    public static class Request extends BaseUserDto {
        @NotNull
        private Long id;

        private String name;

        private String identifier;

        @Setter
        private String password;

        private UsersType type;
    }

}
