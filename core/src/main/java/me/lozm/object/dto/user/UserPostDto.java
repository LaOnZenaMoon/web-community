package me.lozm.object.dto.user;

import lombok.Getter;
import lombok.Setter;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.NotEmpty;

public class UserPostDto {

    @Getter
    public static class Request extends BaseUserDto {
        @NotEmpty
        private String name;

        @NotEmpty
        private String identifier;

        @NotEmpty
        @Setter
        private String password;

        @NotEmpty
        private String type;

        public static Request setRequestTestData(String name, String identifier) {
            UserPostDto.Request reqDto = new UserPostDto.Request();
            reqDto.name = name;
            reqDto.identifier = identifier;
            reqDto.password = "asdf1234";
            reqDto.type = "USER";

            return reqDto;
        }
    }

}
