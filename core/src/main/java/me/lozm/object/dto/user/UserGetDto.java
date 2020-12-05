package me.lozm.object.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.lozm.entity.user.User;
import me.lozm.object.code.UsersType;
import org.springframework.data.domain.Page;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserGetDto {

    private Long id;
    private String name;
    private String identifier;
    private String password;
    private UsersType type;


    public static UserGetDto of(User user) {
        return UserGetDto.builder()
                .id(user.getId())
                .name(user.getName())
                .identifier(user.getIdentifier())
                .password(user.getPassword())
                .type(user.getType())
                .build();
    }


    @Getter
    public static class Response {
        Page<UserGetDto> list;

        public void setList(Page<User> userList) {
            this.list = userList.map((entity) -> UserGetDto.of(entity));
        }
    }

}
