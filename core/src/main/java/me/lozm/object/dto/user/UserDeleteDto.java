package me.lozm.object.dto.user;

import lombok.*;
import me.lozm.object.dto.BaseUserDto;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class UserDeleteDto {

    private Long id;

    @Getter @Setter
    public static class Request extends BaseUserDto {
        @Size(min = 1)
        private List<UserDeleteDto> list = new ArrayList<>();
    }

}
